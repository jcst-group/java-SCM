package com.nongxin.terminal.controller.backstage.traceability;


import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.entity.traceability.TraceAreaCount;
import com.nongxin.terminal.entity.traceability.TraceCount;
import com.nongxin.terminal.entity.traceability.TraceRecord;
import com.nongxin.terminal.service.traceability.TraceAreaCountService;
import com.nongxin.terminal.service.traceability.TraceCountService;
import com.nongxin.terminal.service.traceability.TraceRecordService;
import com.nongxin.terminal.util.RedisUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.traceability.IpVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/trace")
public class TraceController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TraceRecordService traceRecordService;
    @Autowired
    private TraceCountService traceCountService;
    @Autowired
    private TraceAreaCountService traceAreaCountService;

    /**
     * 解析ip地址详细信息
     *@Param  ip
     *
     */
    @GetMapping(value = "/updateTraceing")
    public Result<String> getIpInfo(String ip,@RequestParam(required = true) String retroCode){
        Result<String> result = new Result<>();
        IpVo ipInfo = (IpVo) redisUtil.get(ip);

        if(ipInfo==null){
            String url="http://whois.pconline.com.cn/ipJson.jsp?ip=";
            ResponseEntity<String> results = restTemplate.exchange(url+ip+"&json=true", HttpMethod.GET, new HttpEntity<>(this.getHeaders()), String.class);
            String json = results.getBody();
            JSONObject jsonObject = JSONObject.parseObject(json);
            //从查询接口解析Ip信息
            IpVo ipVo = new IpVo();
            ipVo.setCode(0);
            ipVo.setIp(jsonObject.getString("ip"));
            ipVo.setCity(jsonObject.getString("city"));
            ipVo.setCityId(jsonObject.getString("cityCode"));
            ipVo.setRegion(jsonObject.getString("pro"));
            ipVo.setRegionId(jsonObject.getString("proCode"));

            redisUtil.set(ip,ipVo);  //放入redis缓存
            redisUtil.expire(ip,180);  //过期时间3分钟
            this.insert(retroCode,ipVo);
            result.setSuccess(true);
            result.setResult("更新成功");
        }else{
            this.insert(retroCode,ipInfo);
            result.setSuccess(true);
            result.setMessage("更新成功");
        }
        return result;
    }

    //统计溯源次数
    public Result<String> insert (String retroCode,IpVo ipVo){
        Result<String> result = new Result<>();
        TraceRecord traceRecord = new TraceRecord();
        traceRecord.setIp(ipVo.getIp());
        traceRecord.setRetroCode(retroCode);
        traceRecordService.insert(traceRecord);  //统计溯源访问记录

        //统计每个追溯码的总溯源次数
        if(traceCountService.isExist(retroCode)){
            traceCountService.updateCount(retroCode);   //更新溯源总次数
        }else{
            traceCountService.insert(retroCode);   //新增新追溯码溯源次数
        }
        //根据IP统计各地区的溯源次数
        if(traceAreaCountService.isExist(retroCode,ipVo.getCityId())){
            traceAreaCountService.updateCount(retroCode,ipVo.getCityId());  //更新次数 +1
        }else{
            TraceAreaCount traceAreaCount = new TraceAreaCount();
            traceAreaCount.setCity(ipVo.getCity());
            traceAreaCount.setCityId(ipVo.getCityId());
            traceAreaCount.setRegion(ipVo.getRegion());
            traceAreaCount.setRegionId(ipVo.getRegionId());
            traceAreaCount.setRetroCode(retroCode);
            traceAreaCountService.insert(traceAreaCount);    //新增该地区溯源记录
        }
        result.setSuccess(true);
        result.setMessage("更新成功");
        return result;
    }

    @GetMapping(value = "/getAreaCountByRetroCode")
    @ApiOperation(value = "查询溯源地区访问记录",notes = "根据追溯码查询溯源地区访问记录")
    public Result<List<TraceAreaCount>> getAreaByBatchId(String retroCode){
        Result<List<TraceAreaCount>> result = new Result<>();
        List<TraceAreaCount> traceAreaCountCount = traceAreaCountService.getByRetroCode(retroCode);
        result.setResult(traceAreaCountCount);
        result.setSuccess(true);
        return result;
    }

    @GetMapping(value = "/getTotalCountByRetroCode")
    @ApiOperation(value = "查询每个溯源总次数",notes = "根据追溯码查询溯源总次数")
    public Result<TraceCount> getTotalByBatchId(String retroCode){
        Result<TraceCount> result = new Result<>();
        TraceCount traceCount = traceCountService.getTotalByRetroCode(retroCode);
        result.setResult(traceCount);
        result.setSuccess(true);
        return result;
    }

    /**
     * 随机生成请求头，防止限制访问
     * @return
     */
    public HttpHeaders getHeaders(){
        String[] userAgent = {"MSIE (MSIE 6.0; X11; Linux; i686) Opera 7.23",
                "Opera/9.20 (Macintosh; Intel Mac OS X; U; en)",
                "Opera/9.0 (Macintosh; PPC Mac OS X; U; en)",
                "iTunes/9.0.3 (Macintosh; U; Intel Mac OS X 10_6_2; en-ca)",
                "Mozilla/4.76 [en_jp] (X11; U; SunOS 5.8 sun4u)",
                "iTunes/4.2 (Macintosh; U; PPC Mac OS X 10.2)",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:5.0) Gecko/20100101 Firefox/5.0",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:9.0) Gecko/20100101 Firefox/9.0",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20120813 Firefox/16.0",
                "Mozilla/4.77 [en] (X11; I; IRIX;64 6.5 IP30)",
                "Mozilla/4.8 [en] (X11; U; SunOS; 5.7 sun4u)"};
        int index = (int) (Math.random()*userAgent.length);
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent",userAgent[index]);
        return headers;
    }
}

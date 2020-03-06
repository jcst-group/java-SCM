package com.nongxin.terminal.schedule;

import com.nongxin.terminal.dao.push.WorkOrderQueryMapper;
import com.nongxin.terminal.util.push.PushUtil;
import com.nongxin.terminal.vo.push.CIDVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Configuration
@EnableScheduling
public class PushTask {

    @Autowired
    private WorkOrderQueryMapper workOrderQueryMapper;

    @Autowired
    private PushUtil pushUtil;

    @Scheduled(cron = "0 0 * * * ?")
    private void configure(){
        List<CIDVo> list = workOrderQueryMapper.getUserCid();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getCidList()!=null){
                for(int j = 0;j<list.get(i).getCidList().size();j++) {  //遍历取得同个用户的多个CID
                    String date = getDateFormat(list.get(i).getExecution_time());
                    String cid = list.get(i).getCidList().get(j);
                    String baseName = list.get(i).getBaseName();
                    String farmingName = list.get(i).getFarmingName();
                    pushUtil.push(cid, baseName + ":" + farmingName + " 需在"
                            + date + "执行");
                }
            }
        }
    }

    public static String getDateFormat(Date date){
        String dateString =null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        dateString = formatter.format(date);

        return dateString;
    }
}

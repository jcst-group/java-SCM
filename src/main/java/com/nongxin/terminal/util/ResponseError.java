package com.nongxin.terminal.util;

import com.alibaba.fastjson.JSON;
import com.nongxin.terminal.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseError {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseError.class);

    public static void response500(ServletResponse resp, String msg,HttpStatus httpStatus) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletResponse.setStatus(httpStatus.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = httpServletResponse.getWriter();
            Result result = new Result();
            result.setResult(false);
            result.setMessage(msg);
            out.append(JSON.toJSONString(result));
        } catch (IOException e) {
            LOGGER.error("返回Response信息出现IOException异常:" + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}

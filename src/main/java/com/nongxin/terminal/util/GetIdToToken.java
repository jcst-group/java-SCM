package com.nongxin.terminal.util;

import com.nongxin.terminal.vo.constant.DefContants;
import org.apache.shiro.authc.AuthenticationException;

import javax.servlet.http.HttpServletRequest;

public class GetIdToToken {

    public static Integer getId(HttpServletRequest request){
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(DefContants.X_ACCESS_TOKEN);
        if (token == null) {
            throw new AuthenticationException("token为空!");
        }
        Integer id = JwtUtil.getId(token);
        if (id==null || id==0){
            throw new AuthenticationException("token非法无效!");
        }
        return id;
    }

}

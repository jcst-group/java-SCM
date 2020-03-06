package com.nongxin.terminal.module.shiro;
 
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Scott
 * @create 2018-07-12 15:19
 * @desc
 **/
public class AppToken implements AuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String token;

    public AppToken(String token) {
        this.token = token;
    }
 
    @Override
    public Object getPrincipal() {
        return token;
    }
 
    @Override
    public Object getCredentials() {
        return token;
    }
}

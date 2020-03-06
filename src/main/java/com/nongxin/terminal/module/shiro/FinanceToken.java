package com.nongxin.terminal.module.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class FinanceToken implements AuthenticationToken {


    private static final long serialVersionUID = 1L;
    private String token;

    public FinanceToken(String token) {
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

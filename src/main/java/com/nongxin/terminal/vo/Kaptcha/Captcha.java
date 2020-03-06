package com.nongxin.terminal.vo.Kaptcha;

/**
 * @author clover
 * @date 2019/6/21
 * @description
 */
public class Captcha {
    private String token;
    private String captcha;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}

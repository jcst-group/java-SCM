package com.nongxin.terminal.module.shiro.aop;

import com.nongxin.terminal.entity.scfinance.system.FinanceRole;
import com.nongxin.terminal.module.shiro.FinanceToken;
import com.nongxin.terminal.util.ResponseError;
import com.nongxin.terminal.vo.constant.DefContants;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinanceFilter extends BasicHttpAuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceFilter.class);

    private FinanceRole financeRole;

    /**
     * 执行登录认证
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        LOGGER.info("isAccessAllowed：Financefilter");
        String url = getPathWithinApplication(request);
        LOGGER.info("当前用户正在访问："+ url);
        try {

            //判断账号是否错误
            this.executeLogin(request, response);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            //throw new AuthenticationException("Token失效，请重新登录", e);
            e = new AuthenticationException("Token失效，请重新登录");
            String msg = e.getMessage();
            ResponseError.response500(response, msg,HttpStatus.INTERNAL_SERVER_ERROR);
            return false;
        }
        try {
            Subject subject = getSubject(request,response);
            boolean permitted = subject.isPermitted(url);
            //判断账户权限
            return permitted;
        } catch (Exception e) {
            throw new AuthenticationException("鉴权失败，请重新登录", e);
        }
    }

    /**
     *	登录验证
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(DefContants.X_ACCESS_TOKEN);
        //LOGGER.info("executeLogin 执行登陆");
        FinanceToken financeToken = new FinanceToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(financeToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest =(HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //LOGGER.info(response.toString());
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //LOGGER.info("onAccessDenied:"+getPathWithinApplication(httpServletRequest));
        return false;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        //httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}

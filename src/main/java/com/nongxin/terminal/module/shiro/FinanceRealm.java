package com.nongxin.terminal.module.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nongxin.terminal.dao.scfinance.system.FinanceRoleResourceMapper;
import com.nongxin.terminal.entity.scfinance.system.FinanceResource;
import com.nongxin.terminal.entity.scfinance.system.FinanceResourceRel;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.service.scfinance.detection.IFinanceUserService;
import com.nongxin.terminal.service.scfinance.system.IFinanceRoleResourceService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.RedisUtil;
import com.nongxin.terminal.util.enumUtil.system.ResourceTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;
import com.nongxin.terminal.util.oConvertUtils;
import com.nongxin.terminal.vo.constant.CommonConstant;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FinanceRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceRealm.class);
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IFinanceUserService userService;

    @Autowired
    private IFinanceRoleResourceService roleResourceService;

    @Autowired
    private FinanceRoleResourceMapper roleResourceMapper;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof FinanceToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.info("进入 FinanceRealm doGetAuthorizationInfo，鉴权验证");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(principals!=null) {
            FinanceUser financeUser =  (FinanceUser) principals.getPrimaryPrincipal();
            List<FinanceResource> apiList = roleResourceMapper.getFinanceResourceByUid(financeUser.getId(), ResourceTypeEnum.FRONT_RECOURCE);
            Set<String> permissionSet = new HashSet<>();
            for(FinanceResource a:apiList){
                if (a.getResourceRelList()!=null && !a.getResourceRelList().isEmpty()){
                    for (FinanceResourceRel financeResourceRel : a.getResourceRelList()){
                        permissionSet.add(financeResourceRel.getUrl());
                    }
                }
                permissionSet.add(a.getCode());
            }
            info.addStringPermissions(permissionSet);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        LOGGER.info("进入 AppRealm doGetAuthenticationInfo，登陆验证");

        String token = (String) auth.getCredentials();

        LOGGER.info("token"+token);

        if (token == null) {
            throw new AuthenticationException("token为空!");
        }

        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);

        if (username == null) {
            throw new AuthenticationException("token非法无效!");
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        wrapper.eq("status", UserStatusEnum.ENABLED.getValue());
        // 查询用户信息
        FinanceUser sysUser = userService.getOne(wrapper);
        if (sysUser == null) {
            throw new AuthenticationException("用户名或密码错误!");
        }
        //校验token是否超时失效 & 或者账号密码是否错误
        if (!jwtTokenRefresh(token, username, sysUser.getPassword())) {
            throw new AuthenticationException("用户名或密码错误!");
        }

		/*// 判断用户状态
		if (sysUser.getStatus() != 1) {
			throw new AuthenticationException("账号已被锁定,请联系管理员!");
		}*/

        return new SimpleAuthenticationInfo(sysUser, token, getName());

    }

    /**
     * JWTToken刷新生命周期 1、登录成功后将用户的JWT生成的Token作为k、v存储到cache缓存里面(这时候k、v值一样)
     * 2、当该用户再次请求时，通过JWTFilter层层校验之后会进入到doGetAuthenticationInfo进行身份验证
     * 3、当该用户这次请求JWTToken值还在生命周期内，则会通过重新PUT的方式k、v都为Token值，缓存中的token值生命周期时间重新计算(这时候k、v值一样)
     * 4、当该用户这次请求jwt生成的token值已经超时，但该token对应cache中的k还是存在，则表示该用户一直在操作只是JWT的token失效了，程序会给token对应的k映射的v值重新生成JWTToken并覆盖v值，该缓存生命周期重新计算
     * 5、当该用户这次请求jwt在生成的token值已经超时，并在cache中不存在对应的k，则表示该用户账户空闲超时，返回用户信息已失效，请重新登录。
     * 6、每次当返回为true情况下，都会给Response的Header中设置Authorization，该Authorization映射的v为cache对应的v值。
     * 7、注：当前端接收到Response的Header中的Authorization值会存储起来，作为以后请求token使用
     *
     * @param userName
     * @param passWord
     * @return
     */
    public boolean jwtTokenRefresh(String token, String userName, String passWord) {
        String cacheToken = String.valueOf(redisUtil.get(CommonConstant.PREFIX_FINANCE_TOKEN + token));
        if (oConvertUtils.isNotEmpty(cacheToken)) {
            //校验token有效性
            if (!JwtUtil.verify(token, userName, passWord)) {
                String newAuthorization = JwtUtil.sign(userName, passWord);
                redisUtil.set(CommonConstant.PREFIX_FINANCE_TOKEN + token, newAuthorization);
                //设置超时时间
                //redisUtil.expire(CommonConstant.PREFIX_APP_TOKEN + token, JwtUtil.EXPIRE_TIME/1000);
            } else {
                redisUtil.set(CommonConstant.PREFIX_FINANCE_TOKEN + token, cacheToken);
                //设置超时时间
                //redisUtil.expire(CommonConstant.PREFIX_APP_TOKEN + token, JwtUtil.EXPIRE_TIME/1000);
            }
            return true;
        }
        return false;
    }
}

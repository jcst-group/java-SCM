package com.nongxin.terminal.config;

import com.nongxin.terminal.module.shiro.*;
import com.nongxin.terminal.module.shiro.aop.AppFilter;
import com.nongxin.terminal.module.shiro.aop.FinanceFilter;
import com.nongxin.terminal.module.shiro.aop.JwtFilter;
import com.nongxin.terminal.module.shiro.aop.ShowFilter;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;

/**
 *
 */

@Configuration
public class ShiroConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

	/**
	 * Filter Chain定义说明 
	 *
	 * 1、一个URL可以配置多个Filter，使用逗号分隔
	 * 2、当设置多个过滤器时，全部验证通过，才视为通过
	 * 3、部分过滤器可指定参数，如perms，roles
	 */
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/user/login", "anon");
		filterChainDefinitionMap.put("/pictureInfo/show/**", "anon");	//图片查看接口过滤
		filterChainDefinitionMap.put("/enum/**", "anon");				//枚举接口过滤
		filterChainDefinitionMap.put("/resource/getUserMenu", "anon");  //菜单接口过滤
		filterChainDefinitionMap.put("/prepareItem/export", "anon");    //导出准备事项接口过滤
		filterChainDefinitionMap.put("/workOrder/export", "anon");      //导出工单接口过滤
		filterChainDefinitionMap.put("/budget/export", "anon");      	//导出预算报表接口过滤
		filterChainDefinitionMap.put("/budget/businessExport", "anon"); //导出经营报表接口过滤
		filterChainDefinitionMap.put("/budget/getBusinessReport", "anon"); //导出经营报表接口过滤
		filterChainDefinitionMap.put("/fileInfo/getAudio","anon");  //工单音频播放接口过滤
		filterChainDefinitionMap.put("/fileInfo/getVideo","anon");  //工单音频播放接口过滤
		filterChainDefinitionMap.put("/retroCoding/export", "anon"); //导出追溯码接口过滤
		filterChainDefinitionMap.put("/common/**", "anon"); 		//公共接口过滤
		filterChainDefinitionMap.put("/resource/selectByCode", "anon");
		filterChainDefinitionMap.put("/resource/getWaitHandle", "anon");


		//公共api
		filterChainDefinitionMap.put("/area/**", "anon");

		//app权限
		filterChainDefinitionMap.put("/app/user/login", "anon");        //app登录接口放行
		filterChainDefinitionMap.put("/app/pictureInfo/show/**", "anon");	//图片查看接口过滤
		filterChainDefinitionMap.put("/app/pictureInfo/addOrderPic", "anon");	//添加工单图片
		filterChainDefinitionMap.put("/app/fileInfo/uploadOrderFile", "anon");	//上传工单音频放行
		filterChainDefinitionMap.put("/app/fileInfo/uploadOrderApplyFile", "anon");	//工单申请音频放行
		filterChainDefinitionMap.put("/app/fileInfo/getAudio", "anon"); //获取工单音频接口过滤
		filterChainDefinitionMap.put("/app/pictureInfo/addFeedBackPic", "anon"); //上传巡视反馈图片接口过滤
		filterChainDefinitionMap.put("/app/pictureInfo/addIllFeedbackPic", "anon"); //上传巡视反馈图片接口过滤
        filterChainDefinitionMap.put("/app/enum/**", "anon");					//枚举类型过滤
		filterChainDefinitionMap.put("/app/user/**", "anon");					//app用户相关接口过滤



		//溯源
		filterChainDefinitionMap.put("/proTraceability/getProTraceability", "anon");	//产品溯源接口放行
		filterChainDefinitionMap.put("/proTraceability/getBatchAndBase", "anon");	//产品溯源接口放行
		filterChainDefinitionMap.put("/proTraceability/getBaseById", "anon");	//产品溯源接口放行
		filterChainDefinitionMap.put("/proTraceability/getTraceabilityPic", "anon");	//产品溯源接口放行
		filterChainDefinitionMap.put("/proTraceability/getShopUrl", "anon");	//商城链接接口放行
		filterChainDefinitionMap.put("/workOrder/getOrderByBatchId", "anon");	//工单溯源接口放行
		filterChainDefinitionMap.put("/batchEnvironment/getBatchEnvironment", "anon");	//环境溯源接口放行
		filterChainDefinitionMap.put("/trace/**", "anon");	//溯源码查询接口放行

		//追溯码
		filterChainDefinitionMap.put("/retro/**", "anon");	//追溯码接口过滤
		filterChainDefinitionMap.put("/retroCoding/getRetroByRetroCode", "anon");	//追溯码接口过滤


		//看板
		filterChainDefinitionMap.put("/board/**","anon");

		//市场价格
		filterChainDefinitionMap.put("/market/**","anon");

		filterChainDefinitionMap.put("/finance/enum/**","anon");
		filterChainDefinitionMap.put("/finance/notify/**","anon");
		filterChainDefinitionMap.put("/financeuser/login","anon");
		filterChainDefinitionMap.put("/financeuser/logout","anon");
		filterChainDefinitionMap.put("/financeuser/getUserMenu","anon");


		filterChainDefinitionMap.put("/bank-info/**","anon");
		//测试用，可删除
		//filterChainDefinitionMap.put("/app/base/**", "anon");

		/**
		 * 公共资源
		 */
		filterChainDefinitionMap.put("/**.js", "anon");
		filterChainDefinitionMap.put("/**.css", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
		filterChainDefinitionMap.put("/swagger**/**", "anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/v2/**", "anon");
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/csrf", "anon");

		filterChainDefinitionMap.put("/processInstance/**", "anon");
		filterChainDefinitionMap.put("/task/**", "anon");
		//filterChainDefinitionMap.put("/probatch/**", "anon");

		//TODO 排除Online请求
		filterChainDefinitionMap.put("/auto/cgform/**", "anon");

		// 添加自己的过滤器并且取名为jwt
		Map<String, Filter> filterMap = new HashMap<String, Filter>(1);
		filterMap.put("jwt", new JwtFilter());
		filterMap.put("app", new AppFilter());
		filterMap.put("show", new ShowFilter());
		filterMap.put("finance", new FinanceFilter());
		shiroFilterFactoryBean.setFilters(filterMap);

		// <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
		filterChainDefinitionMap.put("/app/**", "app");
		filterChainDefinitionMap.put("/show/**", "show");
		filterChainDefinitionMap.put("/finance/**", "finance");
		filterChainDefinitionMap.put("/**", "jwt");


		// 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/*@Bean("securityManager")
	public DefaultWebSecurityManager securityManager(MyRealm myRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//securityManager.setRealms();
		*//*ArrayList realms = new ArrayList();
		realms.add()
		securityManager.setRealms();*//*
		securityManager.setRealm(myRealm);

		*//*
		 * 关闭shiro自带的session，详情见文档
		 * http://shiro.apache.org/session-management.html#SessionManagement-
		 * StatelessApplications%28Sessionless%29
		 *//*
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		securityManager.setSubjectDAO(subjectDAO);
		return securityManager;
	}*/

	@Bean("securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//securityManager.setRealms();
		/*ArrayList realms = new ArrayList();
		realms.add()
		securityManager.setRealms();*/
		securityManager.setAuthenticator(modularRealmAuthenticator());
		List<Realm> realms=new ArrayList<>();

		securityManager.setAuthorizer(modularRealmAuthorizer());
		realms.add(myRealm());
		realms.add(appRealm());
		realms.add(showRealm());
		realms.add(financeRealm());
		securityManager.setRealms(realms);

		/*
		 * 关闭shiro自带的session，详情见文档
		 * http://shiro.apache.org/session-management.html#SessionManagement-
		 * StatelessApplications%28Sessionless%29
		 */
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		securityManager.setSubjectDAO(subjectDAO);
		return securityManager;
	}

	@Bean
	public MyRealm myRealm(){
		//LOGGER.info("MyRealm的初始化");
		MyRealm myRealm = new MyRealm();
		return myRealm;
	}

    @Bean
    public FinanceRealm financeRealm(){
        //LOGGER.info("financeRealm的初始化");
        FinanceRealm financeRealm = new FinanceRealm();
        return financeRealm;
    }

	@Bean
	public AppRealm appRealm(){
		//LOGGER.info("MyRealm的初始化");
		AppRealm appRealm = new AppRealm();
		return appRealm;
	}

	@Bean
	public ShowRealm showRealm(){
		//LOGGER.info("MyRealm的初始化");
		ShowRealm showRealm = new ShowRealm();
		return showRealm;
	}


	@Bean
	public ModularRealmAuthenticator modularRealmAuthenticator(){
		ModularRealmAuthenticator modularRealmAuthenticator=new ModularRealmAuthenticator();
		modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		return modularRealmAuthenticator;
	}

	@Bean
	public ModularRealmAuthorizer modularRealmAuthorizer(){
		ModularRealmAuthorizer modularRealmAuthorizer = new MyModularRealmAuthorizer();
		return modularRealmAuthorizer;
	}

	/**
	 * 下面的代码是添加注解支持
	 * @return
	 */
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		return defaultAdvisorAutoProxyCreator;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

}

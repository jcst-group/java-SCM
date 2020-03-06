package com.nongxin.terminal.vo.constant;

public interface CommonConstant {

	/**
	 * 正常状态
	 */
	Integer STATUS_NORMAL = 0;

	/**
	 * 禁用状态
	 */
	Integer STATUS_DISABLE = -1;

	/**
	 * 删除标志
	 */
	Integer DEL_FLAG_1 = 1;

	/**
	 * 未删除
	 */
	Integer DEL_FLAG_0 = 0;

	/**
	 * 系统日志类型： 登录
	 */
	int LOG_TYPE_1 = 1;

	/**
	 * 系统日志类型： 操作
	 */
	int LOG_TYPE_2 = 2;


	/** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
	public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
	/** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
	public static final Integer SC_OK_200 = 200;


	public static String PREFIX_USER_ROLE = "PREFIX_USER_ROLE";
	public static String PREFIX_USER_PERMISSION  = "PREFIX_USER_PERMISSION";
	public static int  TOKEN_EXPIRE_TIME  = 3600;

	//后台token常量
	String PREFIX_USER_TOKEN  = "PREFIX_USER_TOKEN";

	//APP token常量
	String PREFIX_APP_TOKEN  = "PREFIX_APP_TOKEN";

	String PREFIX_FINANCE_TOKEN ="PREFIX_FINANCE_TOKEN";

	//看板token常量
	String PREFIX_SHOW_TOKEN  = "PREFIX_SHOW_TOKEN";

	//管理员类型
	Short ADMIN_TYPE = 1;

	//萤石token常量
	String PREFIX_YS_ACCESS_TOKEN = "PREFIX_YS_ACCESS_TOKEN";


	//地区列表常量
	String AREA_TREENODES = "AREA_TREENODES";

	String AREA_BOARD_NODES ="AREA_BOARD_NODES";
	//权限常量
	String ALL_RESOURCES = "ALL_RESOURCES";

	String USER_RESOURCES = "USER_RESOURCES";

	//用户登陆验证码常量
	public static String CLIENT_TOKEN = "USER_CAPTACHA";


	/**
	 *  0：一级菜单
	 */
	public static Integer MENU_TYPE_0  = 0;
	/**
	 *  1：子菜单
	 */
	public static Integer MENU_TYPE_1  = 1;
	/**
	 *  2：按钮权限
	 */
	public static Integer MENU_TYPE_2  = 2;
}

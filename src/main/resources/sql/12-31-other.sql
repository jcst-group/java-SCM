-- ----------------------------
-- Table structure for detect_fee_item
-- ----------------------------
DROP TABLE IF EXISTS `detect_fee_item`;
CREATE TABLE `detect_fee_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detect_order_id` int(11) NULL DEFAULT NULL,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `item_unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `item_price` decimal(32, 8) NULL DEFAULT NULL,
  `item_sum` decimal(32, 8) NULL DEFAULT NULL,
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `int_one` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of detect_fee_item
-- ----------------------------
INSERT INTO `detect_fee_item` VALUES (1, 7, 'aaa', '1', 2.00000000, 2.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (2, 9, 'bbb', '1', 3.00000000, 3.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (3, 6, 'ccc', '2', 3.00000000, 6.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (4, 10, 'test', '23', 4.00000000, 92.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (5, 11, 'all test', '213', 123.00000000, 26199.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (6, 13, '测试', '20', 30.00000000, 600.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (7, 14, '测试2', '30', 40.00000000, 1200.00000000, NULL, NULL, NULL, NULL);
INSERT INTO `detect_fee_item` VALUES (8, 16, '全部测试', '全部测试', 23.00000000, 276.00000000, NULL, NULL, 12, NULL);
INSERT INTO `detect_fee_item` VALUES (9, 17, '全部测试2', '全部测试2', 123.00000000, 5043.00000000, NULL, NULL, 41, NULL);
INSERT INTO `detect_fee_item` VALUES (10, 16, 'test', 'test', 123.00000000, 5166.00000000, NULL, NULL, 42, NULL);
INSERT INTO `detect_fee_item` VALUES (11, 18, 'abcd', 'abcd', 12.00000000, 276.00000000, NULL, NULL, 23, NULL);
INSERT INTO `detect_fee_item` VALUES (12, 15, 'test2', 'test2', 123.00000000, 52152.00000000, NULL, NULL, 424, NULL);
INSERT INTO `detect_fee_item` VALUES (13, 19, 'test2', 'test2', 123.00000000, 507252.00000000, NULL, NULL, 4124, NULL);
INSERT INTO `detect_fee_item` VALUES (14, 19, '测试费用', '个', 10.00000000, 10.00000000, NULL, NULL, 1, NULL);
INSERT INTO `detect_fee_item` VALUES (15, 19, '测试费用', '个', 10.00000000, 10.00000000, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for detect_order
-- ----------------------------
DROP TABLE IF EXISTS `detect_order`;
CREATE TABLE `detect_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_user_id` int(11) NULL DEFAULT NULL COMMENT '订单用户ID',
  `finance_user_id` int(11) NULL DEFAULT NULL COMMENT '合作社ID',
  `detect_user_id` int(11) NULL DEFAULT NULL,
  `insurance_type` int(11) NULL DEFAULT NULL,
  `number_id` int(11) NULL DEFAULT NULL,
  `detect_status` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `num_two` decimal(32, 8) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  `relate_plant` int(11) NULL DEFAULT NULL,
  `relate_price` int(11) NULL DEFAULT NULL,
  `relate_one` int(11) NULL DEFAULT NULL,
  `relate_two` int(11) NULL DEFAULT NULL,
  `relate_normal` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of detect_order
-- ----------------------------
INSERT INTO `detect_order` VALUES (1, '检测编号', 8, 1, 9, 1, 1, 7, '2019-12-24 17:32:15', '备注', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (6, 'DETECT-20191225-84869', 8, 1, 9, 2, 1, 7, '2019-12-25 11:11:30', '123', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (7, 'DETECT-20191225-83551', 8, 1, 9, 1, 1, 5, '2019-12-25 11:49:55', '4456', 'test2', NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (9, 'DETECT-20191226-29618', 8, 1, 9, 1, 1, 5, '2019-12-26 10:30:51', 'test', 'test', NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (10, 'DETECT-20191226-74654', 8, 1, 9, 1, 1, 5, '2019-12-27 11:05:26', '123', 'all test', NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (11, 'DETECT-20191227-64669', 8, 1, 9, 1, 1, 4, '2019-12-27 16:24:56', 'all test', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (13, 'DETECT-20191228-31989', 8, 5, 9, 1, 5, 5, '2019-12-28 15:32:28', '测试', '测试', NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (15, 'DETECT-20191228-67198', 8, 5, 9, 4, 5, 3, '2019-12-28 16:05:49', '无检测内容信息', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (16, 'DETECT-20191228-53092', 8, 5, 9, 1, 5, 3, '2019-12-28 17:04:52', '全部测试', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (17, 'DETECT-20191228-61547', 8, 5, 9, 1, 5, 5, '2019-12-28 17:09:53', '全部测试2', '全部测试2', NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (18, 'DETECT-20191228-82668', 8, 5, 9, 1, 5, 3, '2019-12-28 17:15:55', 'abcd', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `detect_order` VALUES (19, 'DETECT-20191228-48839', 8, 5, 9, 1, 5, 3, '2019-12-28 17:38:05', 'test2', NULL, NULL, NULL, NULL, 8, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fianceuser_user_base_rel
-- ----------------------------
DROP TABLE IF EXISTS `fianceuser_user_base_rel`;
CREATE TABLE `fianceuser_user_base_rel`  (
  `financeuser_id` int(11) NULL DEFAULT NULL,
  `base_id` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fianceuser_user_base_rel
-- ----------------------------
INSERT INTO `fianceuser_user_base_rel` VALUES (5, 72, NULL);
INSERT INTO `fianceuser_user_base_rel` VALUES (6, 73, NULL);
INSERT INTO `fianceuser_user_base_rel` VALUES (1, 53, NULL);
INSERT INTO `fianceuser_user_base_rel` VALUES (1, 55, NULL);

-- ----------------------------
-- Table structure for finance_member
-- ----------------------------
DROP TABLE IF EXISTS `finance_member`;
CREATE TABLE `finance_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid,用户账号,主键',
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `member_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `real_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真名',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码(唯一)',
  `identify_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件地址(唯一)',
  `block_area` decimal(32, 8) NULL DEFAULT NULL,
  `block_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` smallint(6) NULL DEFAULT NULL COMMENT '性别(1.男 2.女)',
  `status` smallint(6) NULL DEFAULT NULL COMMENT '账户状态(1，已启用，2，未启用）',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `CREATE_WHERE` tinyint(4) NULL DEFAULT NULL COMMENT '创建来源(1.web 2.android 3.ios 4.win 5.macos 6.ubuntu)',
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance_member
-- ----------------------------
INSERT INTO `finance_member` VALUES (1, 1, '12313124', '陈朝胜', '13750528071', '441461188545670037', '1170714974@qq.com', 3.20000000, '三台县永明镇本源麦冬种植专业合作社花园分社', 1, NULL, NULL, NULL, NULL, 1);
INSERT INTO `finance_member` VALUES (5, 5, NULL, '合作社1社员1', '13750528071', '445121199304136818', NULL, 2.00000000, '123', NULL, NULL, NULL, NULL, NULL, 5);
INSERT INTO `finance_member` VALUES (6, 5, NULL, '合作社1社员2', '13750528071', '445121199304136818', NULL, 3.00000000, 'sss', NULL, NULL, NULL, NULL, NULL, 5);
INSERT INTO `finance_member` VALUES (7, 1, NULL, 'cccc', '13435506555', '441481199607290035', NULL, 55.00000000, '55', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `finance_member` VALUES (9, 5, 'MEMBER-20191228-45928', 'test', '13435501111', '123423232323233', NULL, 11.00000000, '11', NULL, NULL, NULL, NULL, NULL, 5);

-- ----------------------------
-- Table structure for finance_resource
-- ----------------------------
DROP TABLE IF EXISTS `finance_resource`;
CREATE TABLE `finance_resource`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `CODE` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `PARENT_ID` int(11) NULL DEFAULT NULL COMMENT '父资源编码->菜单',
  `URI` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址URL',
  `TYPE` smallint(4) NULL DEFAULT NULL COMMENT '类型 1:菜单menu 2:资源element(rest-api) 3:资源分类',
  `METHOD` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问方式 GET POST PUT DELETE PATCH',
  `ICON` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `STATUS` smallint(4) NULL DEFAULT 1 COMMENT '状态   1:正常、9：禁用',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `role_type` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 150 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源信息表(菜单,资源)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance_resource
-- ----------------------------
INSERT INTO `finance_resource` VALUES (1, '/finance', '金融管理', -1, '/finance', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (108, '/', '系统管理', 1, NULL, 2, 'POST', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (109, '/user', '用户管理', 1, '/user/list', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (110, '/finance/basic', '基础信息', 1, '/finance/basic', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (111, '/finance/member', '社员管理', 1, '/finance/member', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (112, '/finance/guarantee', '担保&贷款管理', 1, '/finance/guarantee', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (113, '/finance/insurance', '合作社保险管理', 1, '/finance/insurance', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (115, '/finance/insuranceofis', '保险端保险管理', 1, '/finance/insuranceofis', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (116, '/finance/user', '金融账户管理', 1, '/finance/user', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (117, '/insurance/insuranceAll', '保险端保险申请汇总', 1, '/insurance/insuranceAll', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (118, '/insurance/insuranceApply', '保险端申请中保险', 1, '/insurance/insuranceApply', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (119, '/insurance/insuranceHandle', '保险端受理中保险', 1, '/insurance/insuranceHandle', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (120, '/insurance/insuranceFinish', '保险端已完成保险', 1, '/insurance/insuranceFinish', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (121, '/loan/guarantee/all', '担贷款担保申请汇总', 1, '/loan/guarantee/allApply', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (122, '/loan/guarantee/apply', '担审核中贷款拟担保', 1, '/loan/guarantee/apply', 1, 'GET', '', 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (123, '/loan/guarantee/approve', '担审批中贷款担保', 1, '/loan/guarantee/approve', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (124, '/loan/guarantee/Finish', '担已完成担保贷款', 1, '/loan/guarantee/Finish', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (125, '/loan/bank/all', '银贷款担保申请汇总', 1, '/loan/bank/allApply', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (126, '/loan/bank/apply', '银审核中贷款', 1, '/loan/bank/apply', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (127, '/loan/bank/approve', '银审批中贷款', 1, '/loan/bank/approve', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (128, '/loan/bank/finish', '银已完成贷款', 1, '/loan/bank/finish', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (129, '/detect/order/all', '定检测申请汇总', 1, '/detect/order/all', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (130, '/detect/order/add', '定检测申请新增', 1, '/detect/order/add', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (131, '/detect/order/deal', '定处理中检测申请', 1, '/detect/order/deal', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (132, '/detect/order/finish', '定已完成检测申请', 1, '/detect/order/finish', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (133, '/detect/detect/all', '检检测申请汇总', 1, '/detect/detect/all', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (134, '/detect/detect/confirm', '检检测申请确认', 1, '/detect/detect/confirm', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (135, '/detect/detect/deal', '检检测中检测申请', 1, '/detect/detect/deal', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (136, '/detect/detect/finish', '检已完成检测申请', 1, '/detect/detect/finish', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (137, '/detect/coop/all', '合检测申请汇总', 1, '/detect/coop/all', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (138, '/detect/coop/confirm', '合待确认检测申请', 1, '/detect/coop/confirm', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (139, '/detect/coop/finish', '合已完成检测申请', 1, '/detect/coop/confirm', 1, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (140, '/finance/loan/listToCoop', '贷款申请列表', 112, '/finance/loan/listToCoop', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (141, '/finance/member/list\r\n', '社员管理功能', 111, '/finance/member/list\r\n', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (142, '/finance/order/listToCoop\r\n', '合作社保险功能', 113, '/finance/order/listToCoop\r\n', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (143, '/finance/cominfo/query\r\n', '基础信息功能', 110, '/finance/cominfo/query\r\n', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (144, '/finance/detect/listToFinanceUser', '合作社检测功能', 137, '/finance/detect/listToFinanceUser', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (145, '/finance/order/listToInsurance\r\n', '保险公司保险功能', 117, '/finance/order/listToInsurance\r\n', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (146, '/finance/loan/listToGuarantee\r\n', '担保公司功能', 121, '/finance/loan/listToGuarantee\r\n', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (147, '/finance/loan/listToBank', '银行贷款功能', 125, '/finance/loan/listToBank', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (148, '/finance/detect/listToOrderUser', '订单企业功能', 129, '/finance/detect/listToOrderUser', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `finance_resource` VALUES (149, '/finance/detect/listToDetectUser\r\n', '检测企业功能', 133, '/finance/detect/listToDetectUser\r\n', 2, 'GET', NULL, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for finance_resource_rel
-- ----------------------------
DROP TABLE IF EXISTS `finance_resource_rel`;
CREATE TABLE `finance_resource_rel`  (
  `resource_id` int(11) NOT NULL COMMENT '权限id',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url',
  `tenant_id` int(11) NULL DEFAULT NULL,
  INDEX `resource_id`(`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance_resource_rel
-- ----------------------------
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/123/123', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/saveorupdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/area/getAreaByLevel', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/area/getAreaByParentCode', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/legalPerson/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/legalPerson/saveorupdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addFinanceBusinessPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/registInfo/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/registInfo/saveorupdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addLegalPersonPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/financeUser/list', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/list', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/addOrUpdate ', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addJoinAssocialPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addMemberIDPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addMemberHeadPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/list2', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/list3', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/listAll', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/listToCoop', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/listToInsurance', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/queryInsuranceCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/saveOrUpdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/applyOrder', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/cancelOrder', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/acceptOrder', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/rejectOrder', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/order/finishOrder', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addInsuranceOrderPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/base/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/base/bind', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/enum/getInsStatusEnumToIns', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/baseRelateBatch/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/baseRelateBatch/calPrepareItem', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/listToCoop', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/saveOrUpdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/enum/getLoanApplyTypeEnum', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/queryBankCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/queryWarrantCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/financeUser/save', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addLoanRelatePic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addWarrantApplyedPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addLoanApplyedPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addWarrantApprovedPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addLoanApprovedPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/listToBank', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/apply', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/listToGuarantee', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/baseRelateBatch/allById', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/warrantApplyAgree', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/loanApplyAgree', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/WarrantApproveAgree', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/loanApproveAgree', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/loanreject', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/loanCancel', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/enum/getLoanApplyStatusEnum', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/enum/getLoanApplyStatusEnumToBank', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/enum/getDetectionTypeEnum', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, 'getDetectionTypeEnum', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/enum/getDetectionStatusEnum', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/member/listAllByUserId', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/queryCoopCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/listToFinanceUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/saveOrUpdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/cominfo/queryDetectCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/listToOrderUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/listToDetectUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, ' /finance/pictureInfo/addDetectRelatePics', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/pictureInfo/addDetectResultPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/apply', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/detectAccept', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/coopAccept', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/finish', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/cancel', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/reject', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/detect/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/loan/queryWorker', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/financeUser/updateUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/financeUser/updatePassword', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/role/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (109, '/finance/financeUser/list', NULL);
INSERT INTO `finance_resource_rel` VALUES (109, '/finance/financeUser/save', NULL);
INSERT INTO `finance_resource_rel` VALUES (109, '/finance/financeUser/updatePassword', NULL);
INSERT INTO `finance_resource_rel` VALUES (109, '/finance/financeUser/updateUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (109, '/finance/base/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/role/addRoleToUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (112, '/finance/loan/listToCoop\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (112, '/finance/loan/saveOrUpdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (112, '/finance/loan/apply\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (112, '/finance/loan/delete\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (112, '/finance/loan/loanCancel\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/loan/listToCoop', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/loan/saveOrUpdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/loan/apply\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/loan/delete\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/loan/loanCancel\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, '/finance/order/listToCoop\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, '/finance/cominfo/query\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, '/finance/order/saveOrUpdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, '/finance/order/delete\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, '/finance/order/applyOrder\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, ' /finance/order/cancelOrder\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (142, '/finance/cominfo/queryInsuranceCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/cominfo/query\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/legalPerson/query\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/registInfo/query\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/legalPerson/saveorupdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/registInfo/saveorupdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/cominfo/saveorupdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (144, '/finance/detect/listToFinanceUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (144, '/finance/detect/coopAccept', NULL);
INSERT INTO `finance_resource_rel` VALUES (144, '/finance/detect/reject', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/cominfo/queryBankCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/cominfo/queryWarrantCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/base/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/base/bind', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, ' /finance/baseRelateBatch/allById', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/baseRelateBatch/calPrepareItem', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/loan/listToGuarantee\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/pictureInfo/addWarrantApplyedPic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/pictureInfo/addWarrantApprovedPic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/loan/warrantApplyAgree\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/loan/loanreject\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/loan/WarrantApproveAgree\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/cominfo/queryBankCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/cominfo/queryWarrantCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/base/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, '/finance/base/bind', NULL);
INSERT INTO `finance_resource_rel` VALUES (146, ' /finance/baseRelateBatch/allById', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/loan/loanApplyAgree\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/loan/listToBank\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/loan/loanApproveAgree\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/loan/loanreject\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/pictureInfo/addLoanApplyedPic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/pictureInfo/addLoanApprovedPic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/cominfo/queryBankCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/cominfo/queryWarrantCominfos', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/base/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/base/bind', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, ' /finance/baseRelateBatch/allById', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/detect/listToOrderUser\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/detect/saveOrUpdate\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/detect/delete\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/pictureInfo/addDetectRelatePic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (149, '/finance/pictureInfo/addDetectResultPic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/cominfo/queryDetectCominfos\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/cominfo/queryCoopCominfos\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/member/listAllByUserId\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/detect/apply\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (148, '/finance/detect/cancel\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/baseRelateBatch/all', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/member/listAll', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/pictureInfo/addLoanRelatePic', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/pictureInfo/addMemberHeadPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/pictureInfo/addMemberIDPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/pictureInfo/addJoinAssocialPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/member/addOrUpdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/member/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/pictureInfo/addFinanceBusinessPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/order/saveOrUpdate', NULL);
INSERT INTO `finance_resource_rel` VALUES (143, '/finance/pictureInfo/addLegalPersonPic', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/financeUser/checkUserName', NULL);
INSERT INTO `finance_resource_rel` VALUES (108, '/finance/financeUser/deleteUser', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/cominfo/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/cominfo/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/legalPerson/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/registInfo/query', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/order/listToInsurance\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/order/acceptOrder\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/order/rejectOrder\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '  /finance/order/finishOrder\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/pictureInfo/addInsuranceOrderPic\r\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (145, '/finance/pictureInfo/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (149, '/finance/detect/detectAccept\n', NULL);
INSERT INTO `finance_resource_rel` VALUES (149, '/finance/detect/reject', NULL);
INSERT INTO `finance_resource_rel` VALUES (149, '/finance/pictureInfo/delete', NULL);
INSERT INTO `finance_resource_rel` VALUES (149, '/finance/detect/finish', NULL);
INSERT INTO `finance_resource_rel` VALUES (140, '/finance/loan/queryWorker', NULL);
INSERT INTO `finance_resource_rel` VALUES (147, '/finance/loan/queryWorker', NULL);

-- ----------------------------
-- Table structure for finance_role
-- ----------------------------
DROP TABLE IF EXISTS `finance_role`;
CREATE TABLE `finance_role`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `TYPE` smallint(4) NOT NULL COMMENT '角色类型 1:管理员 2:非管理员',
  `STATUS` smallint(4) NOT NULL DEFAULT 1 COMMENT '状态   1:正常、9：禁用',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance_role
-- ----------------------------
INSERT INTO `finance_role` VALUES (25, '管理员', 1, 1, '2019-12-10 16:43:27', NULL, NULL);
INSERT INTO `finance_role` VALUES (26, '合作社', 1, 1, '2019-12-27 15:58:30', NULL, NULL);
INSERT INTO `finance_role` VALUES (27, '保险公司', 1, 1, '2019-12-27 15:57:48', NULL, NULL);
INSERT INTO `finance_role` VALUES (28, '担保公司', 1, 1, NULL, NULL, NULL);
INSERT INTO `finance_role` VALUES (29, '银行', 1, 1, NULL, NULL, NULL);
INSERT INTO `finance_role` VALUES (30, '订单企业', 1, 1, NULL, NULL, NULL);
INSERT INTO `finance_role` VALUES (31, '检测公司', 1, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for finance_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `finance_role_resource`;
CREATE TABLE `finance_role_resource`  (
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` int(11) NOT NULL COMMENT '资源ID',
  `tenant_id` int(11) NULL DEFAULT NULL,
  UNIQUE INDEX `ROLE_ID`(`ROLE_ID`, `RESOURCE_ID`) USING BTREE,
  INDEX `RESOURCE_ID`(`RESOURCE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance_role_resource
-- ----------------------------
INSERT INTO `finance_role_resource` VALUES (25, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 108, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 109, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 111, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 112, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 113, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 115, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 116, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 117, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 118, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 119, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 120, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 121, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 122, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 123, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 124, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 125, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 126, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 127, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 128, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 129, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 130, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 131, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 132, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 133, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 134, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 135, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 136, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 137, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 138, NULL);
INSERT INTO `finance_role_resource` VALUES (25, 139, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 111, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 112, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 113, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 137, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 138, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 139, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 140, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 141, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 142, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 143, NULL);
INSERT INTO `finance_role_resource` VALUES (26, 144, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 117, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 118, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 119, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 120, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 143, NULL);
INSERT INTO `finance_role_resource` VALUES (27, 145, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 121, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 122, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 123, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 124, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 143, NULL);
INSERT INTO `finance_role_resource` VALUES (28, 146, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 125, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 126, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 127, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 128, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 143, NULL);
INSERT INTO `finance_role_resource` VALUES (29, 147, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 129, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 130, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 131, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 132, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 143, NULL);
INSERT INTO `finance_role_resource` VALUES (30, 148, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 1, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 110, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 133, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 134, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 135, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 136, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 143, NULL);
INSERT INTO `finance_role_resource` VALUES (31, 149, NULL);

-- ----------------------------
-- Table structure for finance_user_role
-- ----------------------------
DROP TABLE IF EXISTS `finance_user_role`;
CREATE TABLE `finance_user_role`  (
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance_user_role
-- ----------------------------
INSERT INTO `finance_user_role` VALUES (2, 25, NULL);
INSERT INTO `finance_user_role` VALUES (6, 25, NULL);
INSERT INTO `finance_user_role` VALUES (1, 25, NULL);
INSERT INTO `finance_user_role` VALUES (1, 26, NULL);
INSERT INTO `finance_user_role` VALUES (1, 27, NULL);
INSERT INTO `finance_user_role` VALUES (1, 28, NULL);
INSERT INTO `finance_user_role` VALUES (1, 29, NULL);
INSERT INTO `finance_user_role` VALUES (1, 30, NULL);
INSERT INTO `finance_user_role` VALUES (1, 31, NULL);
INSERT INTO `finance_user_role` VALUES (5, 26, NULL);
INSERT INTO `finance_user_role` VALUES (10, 26, NULL);
INSERT INTO `finance_user_role` VALUES (16, 27, NULL);
INSERT INTO `finance_user_role` VALUES (3, 28, NULL);
INSERT INTO `finance_user_role` VALUES (4, 29, NULL);
INSERT INTO `finance_user_role` VALUES (9, 31, NULL);
INSERT INTO `finance_user_role` VALUES (8, 30, NULL);
INSERT INTO `finance_user_role` VALUES (7, 27, NULL);
INSERT INTO `finance_user_role` VALUES (17, 25, NULL);
INSERT INTO `finance_user_role` VALUES (17, 26, NULL);

-- ----------------------------
-- Table structure for insplant_member_rel
-- ----------------------------
DROP TABLE IF EXISTS `insplant_member_rel`;
CREATE TABLE `insplant_member_rel`  (
  `info_id` int(11) NULL DEFAULT NULL,
  `member_id` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of insplant_member_rel
-- ----------------------------
INSERT INTO `insplant_member_rel` VALUES (1, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (2, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (3, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (5, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (6, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (7, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (8, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (9, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (15, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (16, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (17, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (18, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (19, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (20, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (4, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (21, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (14, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (29, 6, NULL);
INSERT INTO `insplant_member_rel` VALUES (29, 5, NULL);
INSERT INTO `insplant_member_rel` VALUES (30, 5, NULL);
INSERT INTO `insplant_member_rel` VALUES (30, 6, NULL);
INSERT INTO `insplant_member_rel` VALUES (31, 1, NULL);
INSERT INTO `insplant_member_rel` VALUES (31, 7, NULL);
INSERT INTO `insplant_member_rel` VALUES (32, 6, NULL);
INSERT INTO `insplant_member_rel` VALUES (33, 9, NULL);
INSERT INTO `insplant_member_rel` VALUES (34, 6, NULL);
INSERT INTO `insplant_member_rel` VALUES (34, 5, NULL);
INSERT INTO `insplant_member_rel` VALUES (34, 9, NULL);

-- ----------------------------
-- Table structure for insurance_order
-- ----------------------------
DROP TABLE IF EXISTS `insurance_order`;
CREATE TABLE `insurance_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insurance_order` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `insurance_id` int(11) NULL DEFAULT NULL,
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `insurance_type` int(11) NULL DEFAULT NULL,
  `order_status` int(11) NULL DEFAULT NULL,
  `start_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  `apply_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insurance_compid` int(11) NULL DEFAULT NULL,
  `contract_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `num_two` decimal(32, 8) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  `relate_plant` int(11) NULL DEFAULT NULL,
  `relate_price` int(11) NULL DEFAULT NULL,
  `relate_one` int(11) NULL DEFAULT NULL,
  `relate_two` int(11) NULL DEFAULT NULL,
  `relate_normal` int(11) NULL DEFAULT NULL,
  `actual_start_time` date NULL DEFAULT NULL,
  `actual_end_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of insurance_order
-- ----------------------------
INSERT INTO `insurance_order` VALUES (1, '保单号XXXXXX', 2, 1, 1, 6, '2019-12-16', '2019-12-17', '2019-12-16 17:39:13', NULL, NULL, '2019-12-16 17:39:13', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (7, '保单号XXXXXX2', 2, 1, 1, 1, '2019-12-16', '2019-12-17', '2019-12-17 16:38:55', NULL, '18845041512', '2019-12-17 16:38:55', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (8, '保单号XXXXXX3', 2, 1, 1, 1, '2019-12-16', '2019-12-17', '2019-12-17 16:30:40', NULL, NULL, '2019-12-17 16:30:40', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (9, '保单号XXXXXX4', 2, 1, 1, 1, '2019-12-16', '2019-12-17', '2019-12-17 16:30:41', NULL, NULL, '2019-12-17 16:30:41', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (10, '保单号XXXXXX5', 2, 1, 1, 1, '2019-12-16', '2019-12-17', '2019-12-17 16:30:42', NULL, NULL, '2019-12-17 16:30:42', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (11, '保单号XXXXXX6', 2, 1, 1, 5, '2019-12-16', '2019-12-17', '2019-12-17 16:30:43', NULL, NULL, '2019-12-17 16:30:43', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (12, NULL, NULL, 1, 1, 1, '2019-12-15', '2019-12-15', '2019-12-17 16:30:44', NULL, NULL, '2019-12-17 16:30:44', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (13, NULL, 2, 1, 1, 1, '2019-12-05', '2020-01-16', '2019-12-17 16:30:45', NULL, '18845041517', '2019-12-17 16:30:45', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (14, NULL, 2, 1, 1, 1, '2019-12-05', '2020-01-16', '2019-12-17 16:30:46', NULL, '18845041517', '2019-12-17 16:30:46', '123', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (25, 'IS-20191217-33723', 2, 1, 1, 4, '2019-12-17', '2019-12-17', '2019-12-17 17:34:57', NULL, '18845041517', '2019-12-17 17:34:57', NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, '2019-12-21', '2020-01-20');
INSERT INTO `insurance_order` VALUES (26, 'IS-20191219-65494', 2, 2, 1, 4, '2019-12-19', '2019-12-19', '2019-12-19 15:37:38', NULL, '18845041517', '2019-12-19 15:37:38', NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL, '2019-12-20', '2020-01-23');
INSERT INTO `insurance_order` VALUES (29, 'IS-20191219-84582', 2, 2, 1, 4, '2019-12-19', '2019-12-19', '2019-12-19 16:48:06', NULL, '18845041517', '2019-12-19 16:48:06', NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL, '2019-12-13', '2020-01-24');
INSERT INTO `insurance_order` VALUES (30, 'IS-20191219-41179', 2, 2, 1, 4, '2019-12-19', '2019-12-19', '2019-12-19 17:34:55', NULL, '18845041517', '2019-12-19 17:34:55', NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL, '2019-12-14', '2020-01-15');
INSERT INTO `insurance_order` VALUES (31, 'IS-20191220-95286', 2, 2, 1, 1, '2019-12-20', '2019-12-20', NULL, NULL, '18845041517', NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (32, 'IS-20191221-80598', 2, 5, 1, 4, '2020-01-01', '2020-12-31', '2019-12-21 16:26:06', NULL, '13750528071', '2019-12-21 16:26:06', '测试备注信息', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, '2019-12-07', '2019-12-29');
INSERT INTO `insurance_order` VALUES (33, 'IS-20191221-70229', 2, 5, 1, 6, '2019-12-22', '2020-01-31', '2019-12-21 17:35:35', NULL, '13750528071', '2019-12-21 17:35:35', '12312312', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (34, 'IS-20191227-44372', 7, 1, 1, 4, '2019-12-01', '2020-01-31', '2019-12-27 10:48:44', NULL, '13750528071', '2019-12-27 10:48:44', '无', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, '2019-12-01', '2020-01-31');
INSERT INTO `insurance_order` VALUES (35, 'IS-20191227-88590', 7, 1, 2, 5, '2019-12-01', '2020-01-31', '2019-12-27 11:33:36', NULL, '13750528071', '2019-12-27 11:33:36', '12312312', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order` VALUES (36, 'IS-20191228-90075', 7, 5, 1, 4, '2019-12-13', '2020-01-15', '2019-12-28 15:01:53', NULL, '18845041517', '2019-12-28 15:01:53', '测试', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, '2019-12-21', '2020-01-23');
INSERT INTO `insurance_order` VALUES (37, 'IS-20191228-83822', 7, 5, 1, 4, '2019-12-21', '2020-01-18', '2019-12-28 15:54:00', NULL, '18845041571', '2019-12-28 15:54:00', '测试2', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, '2020-01-01', '2020-02-01');
INSERT INTO `insurance_order` VALUES (38, 'IS-20191228-89137', 2, 5, 1, 2, '2019-12-01', '2020-01-31', '2019-12-28 16:15:37', NULL, '13750528071', '2019-12-28 16:15:37', '12312', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for insurance_order_message
-- ----------------------------
DROP TABLE IF EXISTS `insurance_order_message`;
CREATE TABLE `insurance_order_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relate_id` int(11) NULL DEFAULT NULL COMMENT '关联的信息的ID，如类型是保险时关联保险Order',
  `relate_user_id` int(11) NULL DEFAULT NULL COMMENT '关联的操作人信息',
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `relate_type` int(11) NULL DEFAULT NULL,
  `message_status` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `commont` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `int_one` int(11) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 234 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of insurance_order_message
-- ----------------------------
INSERT INTO `insurance_order_message` VALUES (2, 3, 1, NULL, 1, 2, '2019-12-16 19:20:15', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (6, 7, 1, NULL, 1, 2, '2019-12-16 19:44:33', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (7, 8, 1, NULL, 1, 2, '2019-12-16 19:46:25', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (8, 9, 1, NULL, 1, 2, '2019-12-16 19:46:46', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (9, 10, 1, NULL, 1, 2, '2019-12-16 19:46:54', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (10, 11, 1, NULL, 1, 2, '2019-12-16 19:47:37', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (11, 12, 1, NULL, 1, 2, '2019-12-16 20:15:31', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (12, 13, 1, NULL, 1, 2, '2019-12-16 20:52:05', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (13, 14, 1, NULL, 1, 2, '2019-12-16 20:52:07', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (14, 18, 1, NULL, 1, 2, '2019-12-17 14:15:29', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (15, 19, 1, NULL, 1, 2, '2019-12-17 14:16:22', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (16, 21, 1, NULL, 1, 2, '2019-12-17 14:26:17', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (17, 22, 1, NULL, 1, 1, '2019-12-17 16:31:16', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (18, 24, 1, NULL, 1, 1, '2019-12-17 16:39:36', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (19, 21, 1, NULL, 1, 2, '2019-12-17 16:52:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (20, 21, 1, NULL, 1, 6, '2019-12-17 16:53:25', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (21, 21, 1, NULL, 1, 2, '2019-12-17 16:54:44', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (22, 21, 1, NULL, 1, 6, '2019-12-17 17:18:53', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (23, 21, 1, NULL, 1, 2, '2019-12-17 17:20:54', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (24, 21, 1, NULL, 1, 6, '2019-12-17 17:20:57', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (25, 20, 1, NULL, 1, 2, '2019-12-17 17:23:10', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (26, 20, 1, NULL, 1, 6, '2019-12-17 17:23:17', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (27, 25, 1, NULL, 1, 1, '2019-12-17 17:32:45', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (28, 25, 1, NULL, 1, 2, '2019-12-17 17:34:57', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (29, 11, 1, NULL, 1, 2, '2019-12-17 17:41:09', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (30, 11, 2, NULL, 1, 3, '2019-12-19 09:48:32', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (31, 25, 2, NULL, 1, 3, '2019-12-19 09:49:43', '123', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (32, 26, 2, NULL, 1, 1, '2019-12-19 15:36:29', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (33, 27, 2, NULL, 1, 1, '2019-12-19 15:36:49', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (34, 26, 2, NULL, 1, 2, '2019-12-19 15:37:38', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (35, 26, 2, NULL, 1, 3, '2019-12-19 15:50:49', '111', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (36, 26, 2, NULL, 1, 3, '2019-12-19 16:23:22', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (37, 28, 2, NULL, 1, 1, '2019-12-19 16:44:33', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (38, 28, 2, NULL, 1, 2, '2019-12-19 16:44:59', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (39, 28, 2, NULL, 1, 6, '2019-12-19 16:47:47', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (40, 29, 2, NULL, 1, 1, '2019-12-19 16:48:02', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (41, 29, 2, NULL, 1, 2, '2019-12-19 16:48:06', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (42, 29, 2, NULL, 1, 3, '2019-12-19 16:48:23', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (43, 29, 2, NULL, 1, 3, '2019-12-19 17:20:27', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (44, 30, 2, NULL, 1, 1, '2019-12-19 17:34:50', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (45, 30, 2, NULL, 1, 2, '2019-12-19 17:34:55', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (46, 30, 2, NULL, 1, 3, '2019-12-19 17:35:06', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (47, 30, 2, NULL, 1, 3, '2019-12-19 17:43:55', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (48, 31, 2, NULL, 1, 1, '2019-12-20 09:56:39', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (49, 25, 1, NULL, 1, 2, '2019-12-20 10:32:12', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (50, 25, 2, NULL, 1, 3, '2019-12-21 09:40:23', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (51, 25, 2, NULL, 1, 3, '2019-12-21 09:41:18', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (52, 32, 5, NULL, 1, 1, '2019-12-21 16:22:49', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (53, 32, 5, NULL, 1, 2, '2019-12-21 16:26:06', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (54, 32, 2, NULL, 1, 3, '2019-12-21 16:53:55', '允许', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (55, 32, 2, NULL, 1, 3, '2019-12-21 16:54:14', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (56, 33, 5, NULL, 1, 1, '2019-12-21 17:20:31', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (57, 33, 5, NULL, 1, 2, '2019-12-21 17:20:48', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (58, 33, 2, NULL, 1, 3, '2019-12-21 17:34:29', '资料不足，不予处理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (59, 33, 5, NULL, 1, 6, '2019-12-21 17:35:49', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (60, 18, 1, NULL, 2, 20, '2019-12-22 14:39:40', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (61, 19, 1, NULL, 2, 20, '2019-12-22 14:42:19', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (62, 17, 1, NULL, 2, 20, '2019-12-22 14:42:34', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (63, 17, 3, NULL, 2, 8, '2019-12-22 15:14:20', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (64, 20, 1, NULL, 2, 7, '2019-12-22 15:55:37', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (65, 20, 1, NULL, 2, 20, '2019-12-22 15:55:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (66, 17, 4, NULL, 2, 9, '2019-12-22 17:12:59', '银行审核贷款同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (67, 17, 3, NULL, 2, 10, '2019-12-22 17:23:59', '担保已同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (68, 17, 4, NULL, 2, 12, '2019-12-22 17:33:01', '审批贷款操作同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (69, 19, 3, NULL, 2, 16, '2019-12-22 17:47:57', '不同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (70, 18, 3, NULL, 2, 8, '2019-12-22 17:52:23', '拟担保同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (71, 18, 4, NULL, 2, 9, '2019-12-22 18:11:48', '银行审核同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (72, 19, 1, NULL, 2, 20, '2019-12-24 10:31:42', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (73, 1, 1, NULL, 1, 2, '2019-12-24 10:35:14', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (74, 1, 1, NULL, 1, 6, '2019-12-24 10:35:17', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (75, 19, 1, NULL, 2, 14, '2019-12-24 11:11:14', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (76, 21, 1, NULL, 2, 7, '2019-12-24 14:29:33', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (77, 22, 1, NULL, 2, 7, '2019-12-24 14:33:58', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (78, 23, 1, NULL, 2, 7, '2019-12-24 14:34:45', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (79, 23, 1, NULL, 2, 20, '2019-12-24 14:35:11', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (80, 23, 4, NULL, 2, 9, '2019-12-24 14:36:42', '审核同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (81, 23, 4, NULL, 2, 19, '2019-12-24 14:37:10', '审批不同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (82, 23, 1, NULL, 2, 20, '2019-12-24 14:56:21', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (83, 23, 4, NULL, 2, 9, '2019-12-24 14:58:21', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (84, 23, 4, NULL, 2, 12, '2019-12-24 14:58:36', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (85, 1, 8, NULL, 3, 28, '2019-12-24 15:40:14', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (86, 2, 8, NULL, 3, 28, '2019-12-25 09:42:20', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (87, 3, 8, NULL, 3, 28, '2019-12-25 09:44:00', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (88, 4, 8, NULL, 3, 28, '2019-12-25 09:44:40', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (89, 5, 8, NULL, 3, 28, '2019-12-25 10:20:29', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (90, 6, 8, NULL, 3, 28, '2019-12-25 10:23:50', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (91, 7, 8, NULL, 3, 28, '2019-12-25 11:15:10', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (92, 7, 8, NULL, 3, 20, '2019-12-25 11:49:56', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (93, 7, 8, NULL, 3, 26, '2019-12-25 14:18:44', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (94, 7, 8, NULL, 3, 20, '2019-12-25 14:19:06', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (95, 6, 8, NULL, 3, 26, '2019-12-25 14:19:09', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (96, 6, 8, NULL, 3, 26, '2019-12-25 14:19:42', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (97, 6, 8, NULL, 3, 20, '2019-12-25 14:19:54', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (98, 6, 8, NULL, 3, 26, '2019-12-25 14:23:03', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (99, 6, 8, NULL, 3, 26, '2019-12-25 14:24:32', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (100, 6, 8, NULL, 3, 26, '2019-12-25 14:24:36', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (101, 6, 8, NULL, 3, 20, '2019-12-25 14:24:38', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (102, 7, 8, NULL, 3, 26, '2019-12-25 14:24:40', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (103, 7, 8, NULL, 3, 20, '2019-12-25 14:24:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (104, 7, 9, NULL, 3, 21, '2019-12-25 17:06:13', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (105, 24, 1, NULL, 2, 7, '2019-12-26 09:22:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (106, 25, 1, NULL, 2, 7, '2019-12-26 09:58:19', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (107, 25, 1, NULL, 2, 20, '2019-12-26 09:58:25', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (108, 25, 4, NULL, 2, 9, '2019-12-26 10:00:04', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (109, 25, 4, NULL, 2, 19, '2019-12-26 10:11:41', '不同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (110, 8, 8, NULL, 3, 28, '2019-12-26 10:19:04', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (111, 9, 8, NULL, 3, 28, '2019-12-26 10:30:49', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (112, 9, 8, NULL, 3, 20, '2019-12-26 10:30:51', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (113, 9, 9, NULL, 3, 21, '2019-12-26 14:49:37', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (114, 6, 9, NULL, 3, 21, '2019-12-26 14:50:45', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (115, 9, 1, NULL, 3, 23, '2019-12-26 14:56:27', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (116, 7, 1, NULL, 3, 23, '2019-12-26 14:56:44', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (117, 6, 1, NULL, 3, 24, '2019-12-26 14:57:10', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (118, 9, 9, NULL, 3, 25, '2019-12-26 15:20:59', 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (119, 7, 9, NULL, 3, 25, '2019-12-26 15:22:38', 'test2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (120, 25, 1, NULL, 2, 20, '2019-12-26 15:31:33', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (121, 10, 8, NULL, 3, 28, '2019-12-26 16:19:11', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (122, 34, 1, NULL, 1, 1, '2019-12-27 10:48:36', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (123, 34, 1, NULL, 1, 2, '2019-12-27 10:48:44', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (124, 34, 7, NULL, 1, 3, '2019-12-27 10:58:27', 'OK', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (125, 10, 8, NULL, 3, 20, '2019-12-27 11:05:26', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (126, 34, 7, NULL, 1, 3, '2019-12-27 11:09:01', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (127, 10, 9, NULL, 3, 21, '2019-12-27 11:10:47', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (128, 18, 3, NULL, 2, 10, '2019-12-27 11:11:46', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (129, 10, 1, NULL, 3, 23, '2019-12-27 11:15:00', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (130, 35, 1, NULL, 1, 1, '2019-12-27 11:32:37', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (131, 35, 1, NULL, 1, 2, '2019-12-27 11:33:36', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (132, 11, 8, NULL, 3, 28, '2019-12-27 16:24:51', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (133, 11, 8, NULL, 3, 20, '2019-12-27 16:24:56', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (134, 6, 8, NULL, 3, 26, '2019-12-27 16:25:09', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (135, 11, 9, NULL, 3, 21, '2019-12-27 16:26:12', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (136, 10, 9, NULL, 3, 25, '2019-12-27 16:26:59', 'all test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (137, 11, 1, NULL, 3, 23, '2019-12-27 16:27:45', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (138, 26, 5, NULL, 2, 7, '2019-12-28 14:37:39', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (139, 36, 5, NULL, 1, 1, '2019-12-28 14:44:57', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (140, 36, 5, NULL, 1, 2, '2019-12-28 15:01:53', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (141, 36, 5, NULL, 1, 6, '2019-12-28 15:01:56', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (142, 36, 5, NULL, 1, 2, '2019-12-28 15:01:59', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (143, 27, 5, NULL, 2, 7, '2019-12-28 15:04:51', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (144, 27, 5, NULL, 2, 20, '2019-12-28 15:05:17', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (145, 27, 5, NULL, 2, 14, '2019-12-28 15:05:34', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (146, 27, 5, NULL, 2, 20, '2019-12-28 15:05:42', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (147, 36, 7, NULL, 1, 3, '2019-12-28 15:14:01', '接受', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (148, 35, 7, NULL, 1, 3, '2019-12-28 15:14:13', '拒绝', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (149, 36, 7, NULL, 1, 3, '2019-12-28 15:17:55', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (150, 27, 5, NULL, 2, 14, '2019-12-28 15:22:16', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (151, 27, 5, NULL, 2, 20, '2019-12-28 15:23:03', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (152, 12, 8, NULL, 3, 28, '2019-12-28 15:31:48', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (153, 13, 8, NULL, 3, 28, '2019-12-28 15:32:24', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (154, 13, 8, NULL, 3, 20, '2019-12-28 15:32:28', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (155, 1, 8, NULL, 3, 20, '2019-12-28 15:35:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (156, 13, 8, NULL, 3, 26, '2019-12-28 15:40:14', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (157, 13, 8, NULL, 3, 20, '2019-12-28 15:40:22', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (158, 27, 4, NULL, 2, 9, '2019-12-28 15:40:52', '审核同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (159, 27, 4, NULL, 2, 19, '2019-12-28 15:41:26', '不同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (160, 13, 9, NULL, 3, 21, '2019-12-28 15:44:06', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (161, 13, 5, NULL, 3, 23, '2019-12-28 15:45:01', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (162, 27, 5, NULL, 2, 20, '2019-12-28 15:45:54', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (163, 27, 3, NULL, 2, 8, '2019-12-28 15:48:17', '同意', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (164, 27, 4, NULL, 2, 9, '2019-12-28 15:48:58', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (165, 13, 9, NULL, 3, 25, '2019-12-28 15:49:00', '测试', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (166, 27, 3, NULL, 2, 10, '2019-12-28 15:49:51', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (167, 27, 4, NULL, 2, 12, '2019-12-28 15:50:15', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (168, 14, 8, NULL, 3, 28, '2019-12-28 15:50:16', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (169, 14, 8, NULL, 3, 20, '2019-12-28 15:50:19', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (170, 14, 9, NULL, 3, 22, '2019-12-28 15:50:41', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (171, 14, 8, NULL, 3, 20, '2019-12-28 15:51:03', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (172, 14, 9, NULL, 3, 21, '2019-12-28 15:51:30', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (173, 14, 5, NULL, 3, 24, '2019-12-28 15:51:46', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (174, 14, 8, NULL, 3, 20, '2019-12-28 15:52:15', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (175, 14, 8, NULL, 3, 26, '2019-12-28 15:52:24', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (176, 37, 5, NULL, 1, 1, '2019-12-28 15:53:53', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (177, 37, 5, NULL, 1, 2, '2019-12-28 15:54:00', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (178, 37, 5, NULL, 1, 6, '2019-12-28 15:54:03', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (179, 37, 5, NULL, 1, 2, '2019-12-28 15:55:04', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (180, 37, 5, NULL, 1, 6, '2019-12-28 15:55:06', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (181, 37, 5, NULL, 1, 2, '2019-12-28 15:55:20', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (182, 37, 7, NULL, 1, 3, '2019-12-28 15:55:56', '测试2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (183, 37, 5, NULL, 1, 2, '2019-12-28 15:56:24', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (184, 28, 5, NULL, 2, 7, '2019-12-28 16:00:45', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (185, 28, 5, NULL, 2, 20, '2019-12-28 16:02:22', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (186, 28, 4, NULL, 2, 17, '2019-12-28 16:02:51', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (187, 28, 5, NULL, 2, 20, '2019-12-28 16:03:27', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (188, 28, 3, NULL, 2, 16, '2019-12-28 16:04:10', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (189, 15, 8, NULL, 3, 28, '2019-12-28 16:05:46', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (190, 15, 8, NULL, 3, 26, '2019-12-28 16:05:49', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (191, 15, 8, NULL, 3, 20, '2019-12-28 16:05:52', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (192, 15, 9, NULL, 3, 22, '2019-12-28 16:09:45', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (193, 38, 5, NULL, 1, 1, '2019-12-28 16:15:28', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (194, 38, 5, NULL, 1, 2, '2019-12-28 16:15:37', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (195, 38, 5, NULL, 1, 6, '2019-12-28 16:15:41', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (196, 38, 5, NULL, 1, 2, '2019-12-28 16:22:06', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (197, 37, 7, NULL, 1, 3, '2019-12-28 16:24:55', '接受处理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (198, 37, 7, NULL, 1, 3, '2019-12-28 16:25:19', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (199, 29, 5, NULL, 2, 7, '2019-12-28 16:28:00', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (200, 29, 5, NULL, 2, 14, '2019-12-28 16:28:07', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (201, 29, 5, NULL, 2, 20, '2019-12-28 16:28:10', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (202, 29, 5, NULL, 2, 14, '2019-12-28 16:28:25', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (203, 29, 5, NULL, 2, 20, '2019-12-28 16:28:50', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (204, 29, 3, NULL, 2, 16, '2019-12-28 16:30:09', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (205, 29, 5, NULL, 2, 20, '2019-12-28 16:30:22', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (206, 29, 3, NULL, 2, 8, '2019-12-28 16:31:18', '同意担保', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (207, 1, 9, NULL, 3, 22, '2019-12-28 16:36:03', '测试', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (208, 29, 4, NULL, 2, 9, '2019-12-28 16:40:16', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (209, 29, 3, NULL, 2, 10, '2019-12-28 16:47:16', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (210, 29, 4, NULL, 2, 12, '2019-12-28 16:47:35', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (211, 6, 8, NULL, 3, 20, '2019-12-28 16:59:11', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (212, 6, 9, NULL, 3, 22, '2019-12-28 17:01:13', '拒绝', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (213, 16, 8, NULL, 3, 28, '2019-12-28 17:04:50', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (214, 16, 8, NULL, 3, 20, '2019-12-28 17:04:52', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (215, 16, 9, NULL, 3, 21, '2019-12-28 17:06:40', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (216, 16, 5, NULL, 3, 24, '2019-12-28 17:08:45', '拒绝', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (217, 17, 8, NULL, 3, 28, '2019-12-28 17:09:50', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (218, 17, 8, NULL, 3, 20, '2019-12-28 17:09:53', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (219, 17, 9, NULL, 3, 21, '2019-12-28 17:10:36', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (220, 17, 5, NULL, 3, 23, '2019-12-28 17:11:52', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (221, 17, 9, NULL, 3, 25, '2019-12-28 17:12:24', '全部测试2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (222, 16, 8, NULL, 3, 20, '2019-12-28 17:14:11', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (223, 16, 9, NULL, 3, 21, '2019-12-28 17:14:47', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (224, 18, 8, NULL, 3, 28, '2019-12-28 17:15:53', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (225, 18, 8, NULL, 3, 20, '2019-12-28 17:15:55', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (226, 18, 9, NULL, 3, 21, '2019-12-28 17:16:27', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (227, 15, 8, NULL, 3, 20, '2019-12-28 17:23:34', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (228, 15, 9, NULL, 3, 21, '2019-12-28 17:24:00', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (229, 19, 8, NULL, 3, 28, '2019-12-28 17:24:52', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (230, 19, 8, NULL, 3, 20, '2019-12-28 17:24:54', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (231, 19, 9, NULL, 3, 21, '2019-12-28 17:25:17', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (232, 19, 9, NULL, 3, 21, '2019-12-28 17:31:33', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `insurance_order_message` VALUES (233, 19, 9, NULL, 3, 21, '2019-12-28 17:38:37', '测试', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for insurance_plant_info
-- ----------------------------
DROP TABLE IF EXISTS `insurance_plant_info`;
CREATE TABLE `insurance_plant_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insurance_id` int(11) NULL DEFAULT NULL,
  `insurance_area` decimal(32, 8) NULL DEFAULT NULL,
  `insurance_unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of insurance_plant_info
-- ----------------------------
INSERT INTO `insurance_plant_info` VALUES (1, 1, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (4, 7, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (5, 8, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (6, 9, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (7, 10, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (8, 11, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (9, 12, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (10, 13, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (11, 14, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (12, 18, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (13, 19, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (14, 21, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (15, 22, 30.00000000, '亩', NULL);
INSERT INTO `insurance_plant_info` VALUES (21, 24, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (22, 25, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (23, 26, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (24, 27, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (25, 28, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (26, 29, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (27, 30, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (28, 31, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (29, 32, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (30, 33, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (31, 34, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (32, 36, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (33, 37, NULL, NULL, NULL);
INSERT INTO `insurance_plant_info` VALUES (34, 38, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for loan_batch_info
-- ----------------------------
DROP TABLE IF EXISTS `loan_batch_info`;
CREATE TABLE `loan_batch_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_apply_id` int(11) NULL DEFAULT NULL,
  `batch_id` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  `loan_sum` decimal(32, 8) NULL DEFAULT NULL,
  `loan_area` decimal(32, 8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `loan_apply_id`(`loan_apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of loan_batch_info
-- ----------------------------
INSERT INTO `loan_batch_info` VALUES (1, 8, NULL, NULL, NULL, NULL);
INSERT INTO `loan_batch_info` VALUES (5, 12, NULL, NULL, NULL, NULL);
INSERT INTO `loan_batch_info` VALUES (6, 13, 61, NULL, NULL, NULL);
INSERT INTO `loan_batch_info` VALUES (7, 14, NULL, NULL, NULL, NULL);
INSERT INTO `loan_batch_info` VALUES (8, 15, 61, NULL, 65785.68000000, NULL);
INSERT INTO `loan_batch_info` VALUES (9, 16, NULL, NULL, 0.00000000, NULL);
INSERT INTO `loan_batch_info` VALUES (11, 17, 61, NULL, 33457.84000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (14, 18, 61, NULL, 33457.84000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (15, 19, NULL, NULL, 0.00000000, 58.20000000);
INSERT INTO `loan_batch_info` VALUES (16, 20, NULL, NULL, 10000.00000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (17, 21, 61, NULL, 0.00000000, 0.00000000);
INSERT INTO `loan_batch_info` VALUES (18, 22, NULL, NULL, 20000.00000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (19, 23, NULL, NULL, 20000.00000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (20, 24, 61, NULL, 33457.84000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (21, 25, 61, NULL, 33457.84000000, 3.20000000);
INSERT INTO `loan_batch_info` VALUES (22, 26, 16, NULL, 120051.00000000, 11.00000000);
INSERT INTO `loan_batch_info` VALUES (23, 27, 16, NULL, 174056.00000000, 16.00000000);
INSERT INTO `loan_batch_info` VALUES (24, 28, NULL, NULL, 12222.00000000, 16.00000000);
INSERT INTO `loan_batch_info` VALUES (25, 29, 16, NULL, 33023.00000000, 3.00000000);

-- ----------------------------
-- Table structure for loan_batch_member_rel
-- ----------------------------
DROP TABLE IF EXISTS `loan_batch_member_rel`;
CREATE TABLE `loan_batch_member_rel`  (
  `info_id` int(11) NULL DEFAULT NULL,
  `member_id` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of loan_batch_member_rel
-- ----------------------------
INSERT INTO `loan_batch_member_rel` VALUES (5, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (6, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (7, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (9, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (10, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (12, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (13, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (15, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (15, 7, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (16, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (18, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (19, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (20, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (14, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (21, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (11, 1, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (22, 9, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (23, 9, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (23, 6, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (23, 5, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (24, 5, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (24, 9, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (24, 6, NULL);
INSERT INTO `loan_batch_member_rel` VALUES (25, 6, NULL);

-- ----------------------------
-- Table structure for loan_farm_item
-- ----------------------------
DROP TABLE IF EXISTS `loan_farm_item`;
CREATE TABLE `loan_farm_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '准备项目id',
  `loan_batch_id` int(11) NULL DEFAULT NULL COMMENT '作物批次id',
  `farming_item_id` int(11) NULL DEFAULT NULL COMMENT '农事项目id',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `min_person` smallint(6) NULL DEFAULT NULL COMMENT '最少人数',
  `material_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物资名称',
  `company` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `budget_costs` decimal(18, 4) NULL DEFAULT NULL COMMENT '预算费用',
  `inplace_time` datetime(0) NULL DEFAULT NULL COMMENT '到位日期',
  `work_order_id` int(11) NULL DEFAULT NULL COMMENT '工单id',
  `item_type` smallint(6) NULL DEFAULT NULL COMMENT '类型 1:人资  2:物料  3:设备',
  `farming_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1246 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of loan_farm_item
-- ----------------------------
INSERT INTO `loan_farm_item` VALUES (1, 12, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 10, 1000.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (2, 13, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (3, 13, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (4, 13, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (5, 13, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (6, 13, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (7, 13, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (8, 13, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (9, 13, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (10, 13, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (11, 13, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (12, 13, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (13, 13, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (14, 13, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (15, 13, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (16, 13, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (17, 13, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (18, 13, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (19, 13, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (20, 13, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (21, 13, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (22, 13, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (23, 13, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (24, 13, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (25, 13, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (26, 13, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (27, 13, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (28, 13, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (29, 13, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (30, 13, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (31, 13, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (32, 13, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (33, 13, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (34, 13, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (35, 13, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (36, 15, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 7, 700.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (37, 15, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 7, 700.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (38, 15, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 32, 160.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (39, 15, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (40, 15, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 256, 609.2800, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (41, 15, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 3200, 5600.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (42, 15, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (43, 15, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 7, 140.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (44, 15, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 7, 700.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (45, 15, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 2, '技术员', '人', 64, 6400.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (46, 15, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 7, 700.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (47, 15, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 4, '镰刀', '把', 52, 260.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (48, 15, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 4, '技术员', '人', 52, 5200.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (49, 15, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 256, 609.2800, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (50, 15, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (51, 15, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 4, '技术员', '人', 45, 4500.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (52, 15, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 256, 609.2800, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (53, 15, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (54, 15, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (55, 15, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 4, '技术员', '人', 45, 4500.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (56, 15, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 256, 609.2800, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (57, 15, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (58, 15, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (59, 15, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 4, '技术员', '人', 58, 5800.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (60, 15, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 256, 609.2800, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (61, 15, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (62, 15, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (63, 15, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 4, '技术员', '人', 52, 5200.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (64, 15, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 256, 609.2800, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (65, 15, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (66, 15, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (67, 15, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 4, '技术员', '人', 52, 5200.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (68, 15, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 3, '坳撬', '把', 7, 70.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (69, 15, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 3, '技术员', '人', 103, 10300.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (240, 17, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (241, 17, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (242, 17, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (243, 17, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (244, 17, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (245, 17, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (246, 17, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (247, 17, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (248, 17, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (249, 17, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (250, 17, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (251, 17, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (252, 17, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (253, 17, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (254, 17, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (255, 17, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (256, 17, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (257, 17, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (258, 17, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (259, 17, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (260, 17, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (261, 17, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (262, 17, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (263, 17, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (264, 17, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (265, 17, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (266, 17, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (267, 17, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (268, 17, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (269, 17, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (270, 17, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (271, 17, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (272, 17, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (273, 17, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (308, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (309, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (310, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (311, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (312, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (313, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (314, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (315, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (316, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (317, 20, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (318, 20, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (319, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (320, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (321, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (322, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (323, 20, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (324, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (325, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (326, 20, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (327, 20, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (328, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (329, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (330, 20, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (331, 20, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (332, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (333, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (334, 20, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (335, 20, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (336, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (337, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (338, 20, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (339, 20, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (340, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (341, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (342, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (343, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (344, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (345, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (346, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (347, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (348, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (349, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (350, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (351, 20, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (352, 20, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (353, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (354, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (355, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (356, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (357, 20, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (358, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (359, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (360, 20, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (361, 20, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (362, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (363, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (364, 20, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (365, 20, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (366, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (367, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (368, 20, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (369, 20, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (370, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (371, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (372, 20, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (373, 20, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (374, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (375, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (376, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (377, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (378, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (379, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (380, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (381, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (382, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (383, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (384, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (385, 20, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (386, 20, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (387, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (388, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (389, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (390, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (391, 20, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (392, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (393, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (394, 20, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (395, 20, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (396, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (397, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (398, 20, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (399, 20, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (400, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (401, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (402, 20, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (403, 20, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (404, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (405, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (406, 20, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (407, 20, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (408, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (409, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (410, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (411, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (412, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (413, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (414, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (415, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (416, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (417, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (418, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (419, 20, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (420, 20, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (421, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (422, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (423, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (424, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (425, 20, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (426, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (427, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (428, 20, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (429, 20, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (430, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (431, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (432, 20, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (433, 20, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (434, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (435, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (436, 20, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (437, 20, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (438, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (439, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (440, 20, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (441, 20, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (442, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (443, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (444, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (445, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (446, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (447, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (448, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (449, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (450, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (451, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (452, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (453, 20, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (454, 20, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (455, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (456, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (457, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (458, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (459, 20, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (460, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (461, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (462, 20, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (463, 20, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (464, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (465, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (466, 20, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (467, 20, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (468, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (469, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (470, 20, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (471, 20, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (472, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (473, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (474, 20, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (475, 20, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (476, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (477, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (478, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (479, 20, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (480, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (481, 20, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (482, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (483, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (484, 20, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (485, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (486, 20, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (487, 20, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (488, 20, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (489, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (490, 20, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (491, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (492, 20, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (493, 20, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (494, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (495, 20, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (496, 20, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (497, 20, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (498, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (499, 20, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (500, 20, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (501, 20, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (502, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (503, 20, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (504, 20, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (505, 20, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (506, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (507, 20, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (508, 20, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (509, 20, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (510, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (511, 20, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (716, 14, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (717, 14, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (718, 14, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (719, 14, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (720, 14, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (721, 14, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (722, 14, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (723, 14, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (724, 14, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (725, 14, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (726, 14, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (727, 14, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (728, 14, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (729, 14, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (730, 14, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (731, 14, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (732, 14, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (733, 14, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (734, 14, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (735, 14, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (736, 14, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (737, 14, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (738, 14, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (739, 14, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (740, 14, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (741, 14, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (742, 14, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (743, 14, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (744, 14, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (745, 14, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (746, 14, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (747, 14, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (748, 14, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (749, 14, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (750, 21, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (751, 21, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (752, 21, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (753, 21, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (754, 21, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (755, 21, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (756, 21, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (757, 21, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (758, 21, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (759, 21, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (760, 21, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (761, 21, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (762, 21, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (763, 21, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (764, 21, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (765, 21, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (766, 21, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (767, 21, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (768, 21, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (769, 21, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (770, 21, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (771, 21, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (772, 21, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (773, 21, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (774, 21, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (775, 21, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (776, 21, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (777, 21, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (778, 21, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (779, 21, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (780, 21, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (781, 21, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (782, 21, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (783, 21, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (988, 11, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 4, 400.0000, '2019-03-16 00:00:00', NULL, 3, 64);
INSERT INTO `loan_farm_item` VALUES (989, 11, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-03-21 00:00:00', NULL, 1, 64);
INSERT INTO `loan_farm_item` VALUES (990, 11, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '剪刀', '1', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 66);
INSERT INTO `loan_farm_item` VALUES (991, 11, 17, '2019-04-05 00:00:00', '2019-05-10 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-26 00:00:00', NULL, 1, 66);
INSERT INTO `loan_farm_item` VALUES (992, 11, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (993, 11, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1600, 2800.0000, '2019-03-31 00:00:00', NULL, 2, 67);
INSERT INTO `loan_farm_item` VALUES (994, 11, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-03-31 00:00:00', NULL, 1, 67);
INSERT INTO `loan_farm_item` VALUES (995, 11, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 4, 80.0000, '2019-04-05 00:00:00', NULL, 2, 68);
INSERT INTO `loan_farm_item` VALUES (996, 11, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-13 00:00:00', NULL, 1, 68);
INSERT INTO `loan_farm_item` VALUES (997, 11, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 32, 3200.0000, '2019-04-10 00:00:00', NULL, 1, 69);
INSERT INTO `loan_farm_item` VALUES (998, 11, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 4, 400.0000, '2019-04-20 00:00:00', NULL, 1, 70);
INSERT INTO `loan_farm_item` VALUES (999, 11, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 26, 130.0000, '2019-04-26 00:00:00', NULL, 2, 71);
INSERT INTO `loan_farm_item` VALUES (1000, 11, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-04-26 00:00:00', NULL, 1, 71);
INSERT INTO `loan_farm_item` VALUES (1001, 11, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-05-07 00:00:00', NULL, 2, 72);
INSERT INTO `loan_farm_item` VALUES (1002, 11, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-05 00:00:00', NULL, 1, 72);
INSERT INTO `loan_farm_item` VALUES (1003, 11, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-06-21 00:00:00', NULL, 1, 73);
INSERT INTO `loan_farm_item` VALUES (1004, 11, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-06-01 00:00:00', NULL, 2, 74);
INSERT INTO `loan_farm_item` VALUES (1005, 11, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 74);
INSERT INTO `loan_farm_item` VALUES (1006, 11, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 75);
INSERT INTO `loan_farm_item` VALUES (1007, 11, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 23, 2300.0000, '2019-08-06 00:00:00', NULL, 1, 76);
INSERT INTO `loan_farm_item` VALUES (1008, 11, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-07-14 00:00:00', NULL, 2, 77);
INSERT INTO `loan_farm_item` VALUES (1009, 11, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-12 00:00:00', NULL, 1, 77);
INSERT INTO `loan_farm_item` VALUES (1010, 11, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-08-17 00:00:00', NULL, 1, 78);
INSERT INTO `loan_farm_item` VALUES (1011, 11, 22, '2019-09-08 00:00:00', '2019-09-24 00:00:00', 2, '技术员', '人', 29, 2900.0000, '2019-09-07 00:00:00', NULL, 1, 79);
INSERT INTO `loan_farm_item` VALUES (1012, 11, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-08-14 00:00:00', NULL, 2, 80);
INSERT INTO `loan_farm_item` VALUES (1013, 11, 23, '2019-09-13 00:00:00', '2019-09-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-09-12 00:00:00', NULL, 1, 80);
INSERT INTO `loan_farm_item` VALUES (1014, 11, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 81);
INSERT INTO `loan_farm_item` VALUES (1015, 11, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2019-10-07 00:00:00', NULL, 1, 82);
INSERT INTO `loan_farm_item` VALUES (1016, 11, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 128, 304.6400, '2019-09-13 00:00:00', NULL, 2, 83);
INSERT INTO `loan_farm_item` VALUES (1017, 11, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-12 00:00:00', NULL, 1, 83);
INSERT INTO `loan_farm_item` VALUES (1018, 11, 24, '2019-10-18 00:00:00', '2019-11-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 84);
INSERT INTO `loan_farm_item` VALUES (1019, 11, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 26, 2600.0000, '2020-02-04 00:00:00', NULL, 1, 85);
INSERT INTO `loan_farm_item` VALUES (1020, 11, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 4, 40.0000, '2020-02-19 00:00:00', NULL, 2, 86);
INSERT INTO `loan_farm_item` VALUES (1021, 11, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 52, 5200.0000, '2020-02-19 00:00:00', NULL, 1, 86);
INSERT INTO `loan_farm_item` VALUES (1086, 22, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 11, 1100.0000, '2019-03-16 00:00:00', NULL, 3, 30);
INSERT INTO `loan_farm_item` VALUES (1087, 22, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 11, 1100.0000, '2019-03-21 00:00:00', NULL, 1, 30);
INSERT INTO `loan_farm_item` VALUES (1088, 22, 17, '2019-04-05 00:00:00', '2019-05-05 00:00:00', 2, '剪刀', '把', 11, 55.0000, '2019-03-26 00:00:00', NULL, 2, 31);
INSERT INTO `loan_farm_item` VALUES (1089, 22, 17, '2019-04-05 00:00:00', '2019-05-05 00:00:00', 2, '技术员', '人', 55, 5500.0000, '2019-03-26 00:00:00', NULL, 1, 31);
INSERT INTO `loan_farm_item` VALUES (1090, 22, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 2, '有机肥', 'kg', 5500, 9790.0000, '2019-03-31 00:00:00', NULL, 2, 32);
INSERT INTO `loan_farm_item` VALUES (1091, 22, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 2, '复混肥', 'kg', 440, 1047.2000, '2019-03-31 00:00:00', NULL, 2, 32);
INSERT INTO `loan_farm_item` VALUES (1092, 22, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 2, '技术员', '人', 55, 5500.0000, '2019-03-31 00:00:00', NULL, 1, 32);
INSERT INTO `loan_farm_item` VALUES (1093, 22, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 11, 220.0000, '2019-04-05 00:00:00', NULL, 2, 33);
INSERT INTO `loan_farm_item` VALUES (1094, 22, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 11, 1100.0000, '2019-04-13 00:00:00', NULL, 1, 33);
INSERT INTO `loan_farm_item` VALUES (1095, 22, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 4, '技术员', '人', 110, 11000.0000, '2019-04-05 00:00:00', NULL, 1, 34);
INSERT INTO `loan_farm_item` VALUES (1096, 22, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 2, '技术员', '人', 11, 1100.0000, '2019-04-20 00:00:00', NULL, 1, 35);
INSERT INTO `loan_farm_item` VALUES (1097, 22, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 6, '镰刀', '把', 88, 440.0000, '2019-04-26 00:00:00', NULL, 2, 36);
INSERT INTO `loan_farm_item` VALUES (1098, 22, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 6, '技术员', '人', 88, 8800.0000, '2019-04-26 00:00:00', NULL, 1, 36);
INSERT INTO `loan_farm_item` VALUES (1099, 22, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 11, '复混肥', 'kg', 440, 1047.2000, '2019-05-07 00:00:00', NULL, 2, 39);
INSERT INTO `loan_farm_item` VALUES (1100, 22, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 11, '技术员', '人', 77, 7700.0000, '2019-05-27 00:00:00', NULL, 1, 39);
INSERT INTO `loan_farm_item` VALUES (1101, 22, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 7, '技术员', '人', 77, 7700.0000, '2019-06-16 00:00:00', NULL, 1, 40);
INSERT INTO `loan_farm_item` VALUES (1102, 22, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 440, 1047.2000, '2019-06-01 00:00:00', NULL, 2, 41);
INSERT INTO `loan_farm_item` VALUES (1103, 22, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 6, 600.0000, '2019-06-26 00:00:00', NULL, 1, 41);
INSERT INTO `loan_farm_item` VALUES (1104, 22, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-07-06 00:00:00', NULL, 1, 42);
INSERT INTO `loan_farm_item` VALUES (1105, 22, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 7, '技术员', '人', 77, 7700.0000, '2019-08-06 00:00:00', NULL, 1, 43);
INSERT INTO `loan_farm_item` VALUES (1106, 22, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 440, 1047.2000, '2019-07-14 00:00:00', NULL, 2, 44);
INSERT INTO `loan_farm_item` VALUES (1107, 22, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 6, 600.0000, '2019-08-11 00:00:00', NULL, 1, 44);
INSERT INTO `loan_farm_item` VALUES (1108, 22, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 6, '技术员', '人', 6, 600.0000, '2019-08-17 00:00:00', NULL, 1, 45);
INSERT INTO `loan_farm_item` VALUES (1109, 22, 22, '2019-09-08 00:00:00', '2019-09-20 00:00:00', 7, '技术员', '人', 77, 7700.0000, '2019-09-03 00:00:00', NULL, 1, 46);
INSERT INTO `loan_farm_item` VALUES (1110, 22, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-09-17 00:00:00', NULL, 1, 47);
INSERT INTO `loan_farm_item` VALUES (1111, 22, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 6, '技术员', '人', 88, 8800.0000, '2019-09-28 00:00:00', NULL, 1, 48);
INSERT INTO `loan_farm_item` VALUES (1112, 22, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 440, 1047.2000, '2019-09-13 00:00:00', NULL, 2, 49);
INSERT INTO `loan_farm_item` VALUES (1113, 22, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 6, 600.0000, '2019-10-08 00:00:00', NULL, 1, 49);
INSERT INTO `loan_farm_item` VALUES (1114, 22, 24, '2019-10-18 00:00:00', '2019-10-19 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-10-17 00:00:00', NULL, 1, 50);
INSERT INTO `loan_farm_item` VALUES (1115, 22, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 6, '技术员', '人', 88, 8800.0000, '2020-02-04 00:00:00', NULL, 1, 51);
INSERT INTO `loan_farm_item` VALUES (1116, 22, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 6, '坳撬', '把', 11, 110.0000, '2020-02-19 00:00:00', NULL, 2, 52);
INSERT INTO `loan_farm_item` VALUES (1117, 22, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 6, '技术员', '人', 176, 17600.0000, '2020-02-19 00:00:00', NULL, 1, 52);
INSERT INTO `loan_farm_item` VALUES (1150, 23, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 16, 1600.0000, '2019-03-16 00:00:00', NULL, 3, 30);
INSERT INTO `loan_farm_item` VALUES (1151, 23, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-03-21 00:00:00', NULL, 1, 30);
INSERT INTO `loan_farm_item` VALUES (1152, 23, 17, '2019-04-05 00:00:00', '2019-05-05 00:00:00', 3, '剪刀', '把', 16, 80.0000, '2019-03-26 00:00:00', NULL, 2, 31);
INSERT INTO `loan_farm_item` VALUES (1153, 23, 17, '2019-04-05 00:00:00', '2019-05-05 00:00:00', 3, '技术员', '人', 80, 8000.0000, '2019-03-26 00:00:00', NULL, 1, 31);
INSERT INTO `loan_farm_item` VALUES (1154, 23, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 3, '有机肥', 'kg', 8000, 14240.0000, '2019-03-31 00:00:00', NULL, 2, 32);
INSERT INTO `loan_farm_item` VALUES (1155, 23, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 3, '复混肥', 'kg', 640, 1523.2000, '2019-03-31 00:00:00', NULL, 2, 32);
INSERT INTO `loan_farm_item` VALUES (1156, 23, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 3, '技术员', '人', 80, 8000.0000, '2019-03-31 00:00:00', NULL, 1, 32);
INSERT INTO `loan_farm_item` VALUES (1157, 23, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 16, 320.0000, '2019-04-05 00:00:00', NULL, 2, 33);
INSERT INTO `loan_farm_item` VALUES (1158, 23, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 16, 1600.0000, '2019-04-13 00:00:00', NULL, 1, 33);
INSERT INTO `loan_farm_item` VALUES (1159, 23, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 5, '技术员', '人', 160, 16000.0000, '2019-04-05 00:00:00', NULL, 1, 34);
INSERT INTO `loan_farm_item` VALUES (1160, 23, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 2, '技术员', '人', 16, 1600.0000, '2019-04-20 00:00:00', NULL, 1, 35);
INSERT INTO `loan_farm_item` VALUES (1161, 23, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 9, '镰刀', '把', 128, 640.0000, '2019-04-26 00:00:00', NULL, 2, 36);
INSERT INTO `loan_farm_item` VALUES (1162, 23, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 9, '技术员', '人', 128, 12800.0000, '2019-04-26 00:00:00', NULL, 1, 36);
INSERT INTO `loan_farm_item` VALUES (1163, 23, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 16, '复混肥', 'kg', 640, 1523.2000, '2019-05-07 00:00:00', NULL, 2, 39);
INSERT INTO `loan_farm_item` VALUES (1164, 23, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 16, '技术员', '人', 112, 11200.0000, '2019-05-27 00:00:00', NULL, 1, 39);
INSERT INTO `loan_farm_item` VALUES (1165, 23, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 10, '技术员', '人', 112, 11200.0000, '2019-06-16 00:00:00', NULL, 1, 40);
INSERT INTO `loan_farm_item` VALUES (1166, 23, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 2, '复混肥', 'kg', 640, 1523.2000, '2019-06-01 00:00:00', NULL, 2, 41);
INSERT INTO `loan_farm_item` VALUES (1167, 23, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 8, 800.0000, '2019-06-26 00:00:00', NULL, 1, 41);
INSERT INTO `loan_farm_item` VALUES (1168, 23, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-07-06 00:00:00', NULL, 1, 42);
INSERT INTO `loan_farm_item` VALUES (1169, 23, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 10, '技术员', '人', 112, 11200.0000, '2019-08-06 00:00:00', NULL, 1, 43);
INSERT INTO `loan_farm_item` VALUES (1170, 23, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 2, '复混肥', 'kg', 640, 1523.2000, '2019-07-14 00:00:00', NULL, 2, 44);
INSERT INTO `loan_farm_item` VALUES (1171, 23, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 8, 800.0000, '2019-08-11 00:00:00', NULL, 1, 44);
INSERT INTO `loan_farm_item` VALUES (1172, 23, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 8, '技术员', '人', 8, 800.0000, '2019-08-17 00:00:00', NULL, 1, 45);
INSERT INTO `loan_farm_item` VALUES (1173, 23, 22, '2019-09-08 00:00:00', '2019-09-20 00:00:00', 10, '技术员', '人', 112, 11200.0000, '2019-09-03 00:00:00', NULL, 1, 46);
INSERT INTO `loan_farm_item` VALUES (1174, 23, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-09-17 00:00:00', NULL, 1, 47);
INSERT INTO `loan_farm_item` VALUES (1175, 23, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 9, '技术员', '人', 128, 12800.0000, '2019-09-28 00:00:00', NULL, 1, 48);
INSERT INTO `loan_farm_item` VALUES (1176, 23, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 2, '复混肥', 'kg', 640, 1523.2000, '2019-09-13 00:00:00', NULL, 2, 49);
INSERT INTO `loan_farm_item` VALUES (1177, 23, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 2, '技术员', '人', 8, 800.0000, '2019-10-08 00:00:00', NULL, 1, 49);
INSERT INTO `loan_farm_item` VALUES (1178, 23, 24, '2019-10-18 00:00:00', '2019-10-19 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-10-17 00:00:00', NULL, 1, 50);
INSERT INTO `loan_farm_item` VALUES (1179, 23, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 9, '技术员', '人', 128, 12800.0000, '2020-02-04 00:00:00', NULL, 1, 51);
INSERT INTO `loan_farm_item` VALUES (1180, 23, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 8, '坳撬', '把', 16, 160.0000, '2020-02-19 00:00:00', NULL, 2, 52);
INSERT INTO `loan_farm_item` VALUES (1181, 23, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 8, '技术员', '人', 256, 25600.0000, '2020-02-19 00:00:00', NULL, 1, 52);
INSERT INTO `loan_farm_item` VALUES (1214, 25, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '旋耕机', '台', 3, 300.0000, '2019-03-16 00:00:00', NULL, 3, 30);
INSERT INTO `loan_farm_item` VALUES (1215, 25, 16, '2019-03-31 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 3, 300.0000, '2019-03-21 00:00:00', NULL, 1, 30);
INSERT INTO `loan_farm_item` VALUES (1216, 25, 17, '2019-04-05 00:00:00', '2019-05-05 00:00:00', 1, '剪刀', '把', 3, 15.0000, '2019-03-26 00:00:00', NULL, 2, 31);
INSERT INTO `loan_farm_item` VALUES (1217, 25, 17, '2019-04-05 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 15, 1500.0000, '2019-03-26 00:00:00', NULL, 1, 31);
INSERT INTO `loan_farm_item` VALUES (1218, 25, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '有机肥', 'kg', 1500, 2670.0000, '2019-03-31 00:00:00', NULL, 2, 32);
INSERT INTO `loan_farm_item` VALUES (1219, 25, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '复混肥', 'kg', 120, 285.6000, '2019-03-31 00:00:00', NULL, 2, 32);
INSERT INTO `loan_farm_item` VALUES (1220, 25, 18, '2019-04-10 00:00:00', '2019-05-15 00:00:00', 1, '技术员', '人', 15, 1500.0000, '2019-03-31 00:00:00', NULL, 1, 32);
INSERT INTO `loan_farm_item` VALUES (1221, 25, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '锄头', '把', 3, 60.0000, '2019-04-05 00:00:00', NULL, 2, 33);
INSERT INTO `loan_farm_item` VALUES (1222, 25, 19, '2019-04-15 00:00:00', '2019-05-20 00:00:00', 1, '技术员', '人', 3, 300.0000, '2019-04-13 00:00:00', NULL, 1, 33);
INSERT INTO `loan_farm_item` VALUES (1223, 25, 20, '2019-04-20 00:00:00', '2019-05-25 00:00:00', 1, '技术员', '人', 30, 3000.0000, '2019-04-05 00:00:00', NULL, 1, 34);
INSERT INTO `loan_farm_item` VALUES (1224, 25, 21, '2019-04-25 00:00:00', '2019-05-05 00:00:00', 1, '技术员', '人', 3, 300.0000, '2019-04-20 00:00:00', NULL, 1, 35);
INSERT INTO `loan_farm_item` VALUES (1225, 25, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '镰刀', '把', 24, 120.0000, '2019-04-26 00:00:00', NULL, 2, 36);
INSERT INTO `loan_farm_item` VALUES (1226, 25, 22, '2019-05-06 00:00:00', '2019-05-21 00:00:00', 2, '技术员', '人', 24, 2400.0000, '2019-04-26 00:00:00', NULL, 1, 36);
INSERT INTO `loan_farm_item` VALUES (1227, 25, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 3, '复混肥', 'kg', 120, 285.6000, '2019-05-07 00:00:00', NULL, 2, 39);
INSERT INTO `loan_farm_item` VALUES (1228, 25, 23, '2019-06-06 00:00:00', '2019-06-13 00:00:00', 3, '技术员', '人', 21, 2100.0000, '2019-05-27 00:00:00', NULL, 1, 39);
INSERT INTO `loan_farm_item` VALUES (1229, 25, 22, '2019-06-26 00:00:00', '2019-07-08 00:00:00', 2, '技术员', '人', 21, 2100.0000, '2019-06-16 00:00:00', NULL, 1, 40);
INSERT INTO `loan_farm_item` VALUES (1230, 25, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '复混肥', 'kg', 120, 285.6000, '2019-06-01 00:00:00', NULL, 2, 41);
INSERT INTO `loan_farm_item` VALUES (1231, 25, 23, '2019-07-01 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-06-26 00:00:00', NULL, 1, 41);
INSERT INTO `loan_farm_item` VALUES (1232, 25, 24, '2019-07-07 00:00:00', '2019-07-08 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-07-06 00:00:00', NULL, 1, 42);
INSERT INTO `loan_farm_item` VALUES (1233, 25, 22, '2019-08-08 00:00:00', '2019-08-20 00:00:00', 2, '技术员', '人', 21, 2100.0000, '2019-08-06 00:00:00', NULL, 1, 43);
INSERT INTO `loan_farm_item` VALUES (1234, 25, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '复混肥', 'kg', 120, 285.6000, '2019-07-14 00:00:00', NULL, 2, 44);
INSERT INTO `loan_farm_item` VALUES (1235, 25, 23, '2019-08-13 00:00:00', '2019-08-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-08-11 00:00:00', NULL, 1, 44);
INSERT INTO `loan_farm_item` VALUES (1236, 25, 24, '2019-08-18 00:00:00', '2019-08-19 00:00:00', 2, '技术员', '人', 2, 200.0000, '2019-08-17 00:00:00', NULL, 1, 45);
INSERT INTO `loan_farm_item` VALUES (1237, 25, 22, '2019-09-08 00:00:00', '2019-09-20 00:00:00', 2, '技术员', '人', 21, 2100.0000, '2019-09-03 00:00:00', NULL, 1, 46);
INSERT INTO `loan_farm_item` VALUES (1238, 25, 24, '2019-09-18 00:00:00', '2019-09-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-09-17 00:00:00', NULL, 1, 47);
INSERT INTO `loan_farm_item` VALUES (1239, 25, 22, '2019-10-08 00:00:00', '2019-10-23 00:00:00', 2, '技术员', '人', 24, 2400.0000, '2019-09-28 00:00:00', NULL, 1, 48);
INSERT INTO `loan_farm_item` VALUES (1240, 25, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '复混肥', 'kg', 120, 285.6000, '2019-09-13 00:00:00', NULL, 2, 49);
INSERT INTO `loan_farm_item` VALUES (1241, 25, 23, '2019-10-13 00:00:00', '2019-10-20 00:00:00', 1, '技术员', '人', 2, 200.0000, '2019-10-08 00:00:00', NULL, 1, 49);
INSERT INTO `loan_farm_item` VALUES (1242, 25, 24, '2019-10-18 00:00:00', '2019-10-19 00:00:00', 1, '技术员', '人', 1, 100.0000, '2019-10-17 00:00:00', NULL, 1, 50);
INSERT INTO `loan_farm_item` VALUES (1243, 25, 22, '2020-02-09 00:00:00', '2020-02-24 00:00:00', 2, '技术员', '人', 24, 2400.0000, '2020-02-04 00:00:00', NULL, 1, 51);
INSERT INTO `loan_farm_item` VALUES (1244, 25, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '坳撬', '把', 3, 30.0000, '2020-02-19 00:00:00', NULL, 2, 52);
INSERT INTO `loan_farm_item` VALUES (1245, 25, 25, '2020-03-20 00:00:00', '2020-04-24 00:00:00', 2, '技术员', '人', 48, 4800.0000, '2020-02-19 00:00:00', NULL, 1, 52);

-- ----------------------------
-- Table structure for loan_finance_apply
-- ----------------------------
DROP TABLE IF EXISTS `loan_finance_apply`;
CREATE TABLE `loan_finance_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_order_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `guarantee_id` int(11) NULL DEFAULT NULL COMMENT '担保方ID',
  `bank_id` int(11) NULL DEFAULT NULL,
  `load_type` int(11) NULL DEFAULT NULL,
  `start_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  `apply_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insurance_compid` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `num_two` decimal(32, 8) NULL DEFAULT NULL,
  `int_one` int(11) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  `relate_loan` int(11) NULL DEFAULT NULL,
  `relate_price` int(11) NULL DEFAULT NULL,
  `relate_one` int(11) NULL DEFAULT NULL,
  `ifguarantee` int(11) NULL DEFAULT NULL,
  `relate_normal` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of loan_finance_apply
-- ----------------------------
INSERT INTO `loan_finance_apply` VALUES (17, 'LOAN-20191221-67802', 1, 3, 4, 1, '2019-12-21', '2019-12-21', '2019-12-28 10:12:46', NULL, '2019-12-28 10:12:46', '贷款', '13435506575', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 1, NULL, 7);
INSERT INTO `loan_finance_apply` VALUES (18, 'LOAN-20191221-70877', 1, 3, 4, 1, '2019-12-21', '2019-12-21', '2019-12-26 15:24:22', NULL, '2019-12-26 15:24:22', '收到多少佛山市发大水时阿萨德撒奥奥奥奥奥奥奥奥奥奥啊啊啊啊啊啊啊啊啊啊收到多少佛山市发大水时阿萨德撒奥奥奥奥奥奥奥奥奥奥啊啊啊啊啊啊啊啊啊啊收到多少佛山市发大水时阿萨德撒奥奥奥奥奥奥奥奥奥奥啊啊啊啊啊啊啊啊啊啊', '13435506666', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 1, NULL, 5);
INSERT INTO `loan_finance_apply` VALUES (20, 'LOAN-20191222-11843', 1, NULL, 4, 2, '2019-12-22', '2019-12-22', '2019-12-22 15:55:41', NULL, '2019-12-22 15:55:41', NULL, '13435505544', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, 3);
INSERT INTO `loan_finance_apply` VALUES (23, 'LOAN-20191224-68429', 1, NULL, 4, 2, '2019-12-24', '2019-12-24', '2019-12-24 14:56:16', NULL, '2019-12-24 14:56:16', '重新申请', '13435506576', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, 7);
INSERT INTO `loan_finance_apply` VALUES (25, 'LOAN-20191226-50699', 1, NULL, 4, 1, '2019-12-26', '2019-12-26', '2019-12-26 15:42:28', NULL, '2019-12-26 15:42:28', NULL, '13435506576', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `loan_finance_apply` VALUES (27, 'LOAN-20191228-82851', 5, 3, 4, 1, '2019-12-01', '2019-12-31', '2019-12-28 15:45:48', NULL, '2019-12-28 15:45:48', NULL, '13435506576', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, 1, NULL, 7);
INSERT INTO `loan_finance_apply` VALUES (29, 'LOAN-20191228-35194', 5, 3, 4, 1, '2019-12-01', '2020-01-31', '2019-12-28 16:28:07', NULL, '2019-12-28 16:28:07', '无', '13750528071', NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, 1, NULL, 7);

SET FOREIGN_KEY_CHECKS = 1;

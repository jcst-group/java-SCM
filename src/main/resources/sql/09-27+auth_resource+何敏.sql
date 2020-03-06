/*
 Navicat Premium Data Transfer

 Source Server         : ddwb
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : ddwb

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 27/09/2019 17:34:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource`  (
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
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 472 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源信息表(菜单,资源)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource` VALUES (1, '/', '系统管理', -1, '', 1, 'POST', 'fa fa-user', 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (4, '/users', '用户管理', 1, '/user/list', 1, 'GET', NULL, 1, '2018-04-12 03:08:30', '2018-04-12 03:08:30');
INSERT INTO `auth_resource` VALUES (5, '/base', '基地管理', -1, '/base', 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (6, '/standard/deteitem', '检测标准', 343, '/456', 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (7, '/', '种植过程管理', -1, '/', 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (8, '/user/add', '用户添加', 4, NULL, 2, 'ADD', NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (9, '/user/delete', '用户删除', 4, NULL, 2, 'DELETE', NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (10, '/user/update', '用户修改', 4, NULL, 2, 'UPDATE', NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (11, '/user/list', '用户查询', 4, NULL, 2, 'SELECT', NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (12, '/roles', '角色管理', 1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (13, '/medicine', '药材管理', 7, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (16, '/workorder', '工单管理', -1, '', 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (17, '/recovery/detection', '采收检测工单', 343, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (18, '/initialpro/detection', '初加工检测工单', 343, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (19, '/seed/detection', '种苗检测工单', 343, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (20, '/baseInfo', '基地信息管理', 5, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (21, '/envstandards', '基地环境标准', 343, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (22, '/baseuser', '基地相关人员', 5, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (25, '/initialpro', '采收初加工管理', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (33, '/workorder/overview', '工单总览', 16, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (34, '/datareport', '监测数据', 351, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (111, '/seed', '种子登记', 7, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (121, '/plan', '种植计划管理', 7, NULL, 1, '', NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (141, '/farmingItem', '农事项目管理', 7, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (151, '/batch', '种植批次管理', 7, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (152, '/temporary/farming', '临时农事管理', 7, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (153, '/recovery/batch', '采收批次管理', 25, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (261, '/initialpro/batch', '初加工批次管理', 25, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (271, '/initialpro/methods', '初加工方式管理', 25, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (310, '/prepare', '准备事项', 16, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (343, '/', '检测管理', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (344, '/', '财务预算', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (345, '/budgetereport', '预算报表', 344, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (346, '/businessreport', '经营报表', 344, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (347, '/company', '企业信息管理', 1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (348, '/feedback', '巡视反馈', 16, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (349, '/qualitytraceability', '质量追溯', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (350, '/retrocoding', '追溯打码', 349, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (351, '/', '设备管理', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (352, '/equipment', '监测设备管理', 351, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (354, '/workorder/list', '工单查询', 33, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (355, '/warnenv', '预警阈值管理', 351, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (356, '/user/updateStatus', '用户状态修改', 4, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (357, '/user/addRoleToUser', '绑定角色', 4, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (358, '/familyMenber/getFamilyMemberByUid', '家庭成员管理', 4, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (359, '/warnEnv/list', '预警阈值查看', 355, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (360, '/warnEnv/insert', '预警阈值添加', 355, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (361, '/warnEnv/update', '预警阈值修改', 355, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (362, '/warnEnv/delete', '预警阈值删除', 355, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (363, '/equipment/list', '监测设备查看', 352, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (364, '/equipment/insert', '监测设备添加', 352, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (365, '/equipment/update', '监测设备修改', 352, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (366, '/equipment/delete', '监测设备删除', 352, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (367, '/retroCoding/list', '追溯码查看', 350, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (368, '/retroCoding/add', '追溯码添加', 350, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (369, '/budget/getBusinessReport', '经营报表查看', 346, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (370, '/budget/list', '预算报表查看', 345, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (371, '/envStandards/list', '基地环境标准查看', 21, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (372, '/envStandards/add', '基地环境标准添加', 21, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (373, '/envStandards/update', '基地环境标准修改', 21, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (374, '/envStandards/delete', '基地环境标准删除', 21, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (375, '/seedDetection/list', '种苗检测查看', 19, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (376, '/seedDetection/add', '种苗检测添加', 19, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (377, '/seedDetection/update', '种苗检测修改', 19, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (378, '/seedDetection/delete', '种苗检测删除', 19, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (380, '/initProDetectio/list', '初加工检测查看', 18, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (381, '/initProDetectio/add', '初加工检测添加', 18, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (382, '/initProDetectio/update', '初加工检测修改', 18, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (383, '/initProDetectio/delete', '初加工检测删除', 18, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (384, '/seed/list', '种子查看', 111, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (385, '/seed/add', '种子添加', 111, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (386, '/seed/update', '种子修改', 111, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (387, '/seed/delete', '种子删除', 111, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (388, '/recoveryBatch/list', '采收批次查看', 153, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (389, '/recoveryBatch/add', '采收批次添加', 153, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (390, '/recoveryBatch/update', '采收批次修改', 153, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (391, '/recoveryBatch/delete', '采收批次删除', 153, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (392, '/probatch/list', '初加工批次查看', 261, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (393, '/probatch/add', '初加工批次添加', 261, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (394, '/probatch/update', '初加工批次修改', 261, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (395, '/probatch/delete', '初加工批次删除', 261, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (396, '/processing/list', '初级工方式查看', 271, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (397, '/processing/add', '初加工方式添加', 271, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (398, '/processing/update', '初加工方式修改', 271, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (399, '/processing/delete', '初加工方式删除', 271, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (400, '/recoveryDetection/list', '采收检测查看', 17, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (401, '/recoveryDetection/add', '采收检测添加', 17, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (402, '/recoveryDetection/update', '采收检测修改', 17, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (403, '/recoveryDetection/delete', '采收检测删除', 17, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (404, '/detectionItems/list', '检测标准查看', 6, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (406, '/detectionItems/add', '检测标准添加', 6, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (407, '/detectionItems/update', '检测标准修改', 6, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (408, '/detectionItems/delete', '检测标准删除', 6, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (409, '/feedBack/list', '巡视反馈查看', 348, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (410, '/prepareItem/list', '准备事项查看', 310, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (411, '/workOrder/update', '工单审核', 33, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (412, '/crop/list', '药材查看', 13, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (413, '/crop/add', '药材添加', 13, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (414, '/crop/update', '药材修改', 13, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (415, '/crop/delete', '药材删除', 13, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (416, '/baseUserRel/list', '基地对应人员查看', 22, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (417, '/baseUserRel/add', '基地对应人员编辑', 22, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (418, '/baseUserRel/delete', '基地对应人员删除', 22, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (419, '/envmonitor/list', '监测数据查看', 34, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (420, '/role/list', '角色查看', 12, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (421, '/role/add', '角色添加', 12, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (422, '/role/update', '角色修改', 12, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (423, '/role/delete', '角色删除', 12, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (424, '/role/addResourceToRole', '权限管理', 12, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (425, '/farmingItem/list', '农事项目查看', 141, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (426, '/farmingItem/add', '农事项目添加', 141, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (427, '/farmingItem/update', '农事项目修改', 141, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (428, '/farmingItem/delete', '农事项目删除', 141, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (429, '/cropBatch/list', '种植批次查看', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (430, '/cropBatch/add', '种植批次添加', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (431, '/cropBatch/update', '种植批次修改', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (432, '/cropBatch/delete', '种植批次删除', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (433, '/workOrder/add', '创建工单', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (434, '/workOrder/revokeWorkOrder', '撤销工单', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (435, '/cropBatch/updateStatus', '批次完成', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (436, '/plantingPlan/list', '种植计划查看', 121, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (437, '/plantingPlan/add', '种植计划添加', 121, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (438, '/plantingPlan/update', '种植计划修改', 121, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (439, '/plantingPlan/delete', '种植计划删除', 121, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (440, '/fertilizers/list', '企业信息查看', 347, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (441, '/companyInfo/update', '企业信息修改', 347, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (442, '/baseInfo/list', '基地信息查看', 20, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (443, '/baseInfo/add', '基地信息添加', 20, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (444, '/baseInfo/update', '基地信息修改', 20, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (445, '/baseInfo/delete', '基地信息删除', 20, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (446, '/lot/list', '地块管理', 20, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (447, '/farming/temporaryFarmingList', '临时农事查看', 152, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (448, '/farming/addTemporaryFarming', '临时农事添加', 152, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (449, '/farming/update', '临时农事修改', 152, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (450, '/farming/delete', '临时农事删除', 152, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (451, '/cropBatch/unFinishBatch', '临时工单管理', 152, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (452, '/proTraceability/add', '溯源信息管理', 151, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (453, '/videoequipment', '监控设备管理', 351, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (455, '/dataerror', '监测异常数据', 351, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (456, '/warnRecord/getWarnRecord', '监测异常数据查看', 455, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (457, '/datalose', '监测数据缺失', 351, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (458, '/plantingPlan/copyPlan', '种植计划复制', 121, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (461, '/workOrder/updateOrderRole', '更改工单角色', 33, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (462, '/monitorLack/list', '监测数据缺失查看', 457, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (463, '/videoEquipment/list', '监控设备查看', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (464, '/videoEquipment/insert', '监控设备添加', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (465, '/videoEquipment/update', '监控设备修改', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (466, '/videoEquipment/delete', '监控设备删除', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (468, '/videoChannel/insert', '基地视频通道添加', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (469, '/videoChannel/update', '基地视频通道修改', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (470, '/videoChannel/delete', '基地视频通道删除', 453, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (471, '/BCHFeedback', '病虫害反馈', 16, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (472, '/illFeedback/list', '病虫害反馈查看', 471, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_resource` VALUES (473, '/treatmentPlan/selectByIllId', '病虫害反馈处理', 471, NULL, 2, NULL, NULL, 1, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

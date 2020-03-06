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

 Date: 27/09/2019 17:34:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_app_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_app_resource`;
CREATE TABLE `auth_app_resource`  (
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
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源信息表(菜单,资源)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_app_resource
-- ----------------------------
INSERT INTO `auth_app_resource` VALUES (100, '/app/workOrder/getUserOrder', '种植任务管理', 104, '', 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (101, '/app/feedBack/add', '调查任务管理', 105, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (102, '/app/env/getWarnRecord', '预警任务管理', 106, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (103, '/app/env/getTodayEnv', '环控任务管理', 107, NULL, 2, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (104, '/', '种植任务', -1, '', 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (105, '/', '调查任务', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (106, '/', '预警任务', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);
INSERT INTO `auth_app_resource` VALUES (107, '/', '环控任务', -1, NULL, 1, NULL, NULL, 1, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

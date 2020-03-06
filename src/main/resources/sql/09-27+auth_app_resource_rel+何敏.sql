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

 Date: 27/09/2019 17:34:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_app_resource_rel
-- ----------------------------
DROP TABLE IF EXISTS `auth_app_resource_rel`;
CREATE TABLE `auth_app_resource_rel`  (
  `resource_id` int(11) NOT NULL COMMENT '权限id',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url',
  INDEX `resource_id`(`resource_id`) USING BTREE,
  CONSTRAINT `auth_app_resource_rel_ibfk_1` FOREIGN KEY (`resource_id`) REFERENCES `auth_app_resource` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_app_resource_rel
-- ----------------------------
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/base/getBaseTreeByUid');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/farmingItem/selectById');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/pictureInfo/delete');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/fileInfo/delete');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/workOrder/selectById');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/workOrder/getOrderIsLocal');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/workOrder/getOrderCosts');
INSERT INTO `auth_app_resource_rel` VALUES (100, '/app/workOrder/executingOrder');
INSERT INTO `auth_app_resource_rel` VALUES (101, '/app/pictureInfo/delete');
INSERT INTO `auth_app_resource_rel` VALUES (101, '/app/base/getBaseByUid');
INSERT INTO `auth_app_resource_rel` VALUES (102, '/app/base/getBaseByUid');
INSERT INTO `auth_app_resource_rel` VALUES (103, '/app/base/getBaseByUid');
INSERT INTO `auth_app_resource_rel` VALUES (102, '/app/env/getNormalEnv');
INSERT INTO `auth_app_resource_rel` VALUES (101, '/app/illFeedback/add');
INSERT INTO `auth_app_resource_rel` VALUES (101, '/app/illFeedback/list');

SET FOREIGN_KEY_CHECKS = 1;

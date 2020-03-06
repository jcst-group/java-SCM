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

 Date: 07/11/2019 11:36:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_unit
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_unit`;
CREATE TABLE `ddwb_unit`  (
  `value` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `display_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ddwb_unit
-- ----------------------------
INSERT INTO `ddwb_unit` VALUES (1, 'MPN/100ml', 'MPN/100ml');
INSERT INTO `ddwb_unit` VALUES (2, 'CFU/ml', 'CFU/ml');
INSERT INTO `ddwb_unit` VALUES (3, 'mg/L', 'mg/L');
INSERT INTO `ddwb_unit` VALUES (4, 'mg/m3', 'mg/m3');
INSERT INTO `ddwb_unit` VALUES (5, 'ug/m3', 'ug/m3');
INSERT INTO `ddwb_unit` VALUES (6, 'mg/kg', 'mg/kg');
INSERT INTO `ddwb_unit` VALUES (7, 'cmol(+)/kg', 'cmol(+)/kg');
INSERT INTO `ddwb_unit` VALUES (8, '%', '%');
INSERT INTO `ddwb_unit` VALUES (9, '%(ml/g)', '%(ml/g)');
INSERT INTO `ddwb_unit` VALUES (10, 'g', 'g');
INSERT INTO `ddwb_unit` VALUES (11, 'kg', 'kg');
INSERT INTO `ddwb_unit` VALUES (12, 'ppm', 'ppm');
INSERT INTO `ddwb_unit` VALUES (13, '℃', '℃');
INSERT INTO `ddwb_unit` VALUES (14, 'g/100g', 'g/100g');
INSERT INTO `ddwb_unit` VALUES (15, 'g/100粒', 'g/100粒');
INSERT INTO `ddwb_unit` VALUES (16, '粒/50g', '粒/50g');
INSERT INTO `ddwb_unit` VALUES (17, '个/L', '个/L');
INSERT INTO `ddwb_unit` VALUES (18, '个/mL', '个/mL');
INSERT INTO `ddwb_unit` VALUES (19, 'mg/m²', 'mg/m²');
INSERT INTO `ddwb_unit` VALUES (20, 'g/Kg', 'g/Kg');
INSERT INTO `ddwb_unit` VALUES (21, '个', '个');
INSERT INTO `ddwb_unit` VALUES (22, 'cm', 'cm');
INSERT INTO `ddwb_unit` VALUES (23, '天', '天');

SET FOREIGN_KEY_CHECKS = 1;

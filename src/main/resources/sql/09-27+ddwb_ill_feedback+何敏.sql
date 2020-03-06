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

 Date: 27/09/2019 17:35:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_ill_feedback
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_ill_feedback`;
CREATE TABLE `ddwb_ill_feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病虫害反馈id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `base_id` int(11) NOT NULL COMMENT '基地id',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈内容',
  `feedback_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '反馈时间',
  `answer_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '回答时间',
  `answer_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议内容',
  `status` smallint(6) NOT NULL COMMENT '反馈处理状态 1：未处理 2：已处理',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ddwb_ill_feedback_ibfk_2`(`base_id`) USING BTREE,
  INDEX `ddwb_ill_feedback_ibfk_1`(`user_id`) USING BTREE,
  CONSTRAINT `ddwb_ill_feedback_ibfk_2` FOREIGN KEY (`base_id`) REFERENCES `ddwb_base_info` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ddwb_ill_feedback_plan
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_ill_feedback_plan`;
CREATE TABLE `ddwb_ill_feedback_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '治疗方案id',
  `ill_id` int(11) NOT NULL COMMENT '病虫害id',
  `ill_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病虫害名称',
  `plan_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '治疗方案名称',
  `method` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '治疗方法',
  `feedback_id` int(11) NULL DEFAULT NULL COMMENT '病虫害反馈id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `feedback_id`(`feedback_id`) USING BTREE,
  CONSTRAINT `ddwb_ill_feedback_plan_ibfk_1` FOREIGN KEY (`feedback_id`) REFERENCES `ddwb_ill_feedback` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ddwb_illness
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_illness`;
CREATE TABLE `ddwb_illness`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病虫害id',
  `illness_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病虫害名称',
  `symptom` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '症状',
  `shape` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '形态',
  `habit` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '习性',
  `regular` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规律',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ddwb_treatment_plan
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_treatment_plan`;
CREATE TABLE `ddwb_treatment_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '治疗方案id',
  `ill_id` int(11) NOT NULL COMMENT '病虫害id',
  `plan_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '治疗方案名称',
  `method` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '治疗方法',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_ddwb_treatment_plan_ddwb_treatment_plan_1`(`ill_id`) USING BTREE,
  CONSTRAINT `fk_ddwb_treatment_plan_ddwb_treatment_plan_1` FOREIGN KEY (`ill_id`) REFERENCES `ddwb_illness` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

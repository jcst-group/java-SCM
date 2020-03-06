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

 Date: 09/11/2019 14:19:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_order_apply
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_order_apply`;
CREATE TABLE `ddwb_order_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工单申请表id',
  `order_id` int(11) NOT NULL COMMENT '工单id',
  `apply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请内容',
  `agree` smallint(6) NULL DEFAULT 1 COMMENT '是否同意 1：未处理 2：同意 3：同意',
  `sub_time` datetime(0) NOT NULL COMMENT '提交时间',
  `process_time` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `user_id` int(11) NOT NULL COMMENT '申请人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `ddwb_order_apply_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `ddwb_work_order` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `ddwb_order_apply_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`uid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

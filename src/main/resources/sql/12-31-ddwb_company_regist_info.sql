/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : localhost:3306
 Source Schema         : ddwb

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 28/12/2019 18:45:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_company_regist_info
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_company_regist_info`;
CREATE TABLE `ddwb_company_regist_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `regist_sum` decimal(32, 8) NULL DEFAULT NULL,
  `regist_areacode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `regist_areadetail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_areacode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_areadetail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_income` decimal(32, 8) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `num_two` decimal(32, 8) NULL DEFAULT NULL,
  `int_one` int(11) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  `areacode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `finance_user_id`(`finance_user_id`) USING BTREE,
  CONSTRAINT `ddwb_company_regist_info_ibfk_1` FOREIGN KEY (`finance_user_id`) REFERENCES `ddwb_finance_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ddwb_company_regist_info
-- ----------------------------
INSERT INTO `ddwb_company_regist_info` VALUES (3, 1, 1000.00000000, NULL, NULL, NULL, NULL, 2000.00000000, '2019-12-12 17:32:58', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `ddwb_company_regist_info` VALUES (4, 5, 11.00000000, NULL, NULL, NULL, NULL, NULL, '2019-12-28 14:56:19', NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL);
INSERT INTO `ddwb_company_regist_info` VALUES (5, 7, 1312312.00000000, NULL, NULL, NULL, NULL, 31223123.00000000, '2019-12-28 15:14:02', NULL, NULL, NULL, NULL, NULL, NULL, 7, NULL);

SET FOREIGN_KEY_CHECKS = 1;

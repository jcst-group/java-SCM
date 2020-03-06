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

 Date: 28/12/2019 18:45:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_company_legal_person
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_company_legal_person`;
CREATE TABLE `ddwb_company_legal_person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `legal_person_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `card_type` int(11) NULL DEFAULT NULL,
  `card_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contract_man` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contract_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contract_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
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
  CONSTRAINT `ddwb_company_legal_person_ibfk_1` FOREIGN KEY (`finance_user_id`) REFERENCES `ddwb_finance_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ddwb_company_legal_person
-- ----------------------------
INSERT INTO `ddwb_company_legal_person` VALUES (1, 'chaospanda legalpersonname', 1, NULL, NULL, '陈朝胜', '13750528071', '1170714974@qq.com', '2019-12-16 17:17:45', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_company_legal_person` VALUES (2, '11', 5, NULL, NULL, NULL, NULL, NULL, '2019-12-28 14:55:49', NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL);
INSERT INTO `ddwb_company_legal_person` VALUES (3, '测试测试', 7, NULL, NULL, '联系人', '13750528071', '123123@qq.com', '2019-12-28 15:13:51', NULL, NULL, NULL, NULL, NULL, NULL, 7, NULL);

SET FOREIGN_KEY_CHECKS = 1;

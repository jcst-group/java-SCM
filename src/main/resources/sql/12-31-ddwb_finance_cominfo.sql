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

 Date: 28/12/2019 18:46:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_finance_cominfo
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_finance_cominfo`;
CREATE TABLE `ddwb_finance_cominfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `finance_user_id` int(11) NULL DEFAULT NULL,
  `company_type` int(11) NULL DEFAULT NULL,
  `credit_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属行业社会统一信用代码',
  `business_lience` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_regist_date` date NULL DEFAULT NULL,
  `tax_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '税务登记号',
  `stuff_num` int(11) NULL DEFAULT NULL,
  `Asset_count` decimal(32, 8) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `num_two` decimal(32, 8) NULL DEFAULT NULL,
  `int_one` int(11) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  `areacode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `areadetail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `finance_user_id`(`finance_user_id`) USING BTREE,
  CONSTRAINT `ddwb_finance_cominfo_ibfk_1` FOREIGN KEY (`finance_user_id`) REFERENCES `ddwb_finance_user` (`id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ddwb_finance_cominfo
-- ----------------------------
INSERT INTO `ddwb_finance_cominfo` VALUES (6, 'chaospanda', 1, 4, NULL, '123123123123123123', '2019-12-13', '123123', 122, 123.00000000, '2019-12-12 14:47:30', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (7, '保险公司1', 2, 1, NULL, '12312312312321', '2019-12-18', '12312312', NULL, NULL, '2019-12-16 14:53:54', NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (8, '代代为本担保公司', 3, 1, NULL, '888888888', '2019-12-21', '88888888', NULL, NULL, '2019-12-21 09:31:09', NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (9, '测试银行1', 4, 1, NULL, '88888888', '2019-12-21', '8888888888', NULL, NULL, '2019-12-21 09:32:36', NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (10, '测试合作社1', 5, 1, NULL, '88888888', '2019-12-21', '88888888', 123, NULL, '2019-12-28 14:44:59', NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (11, '测试合作社2', 6, 1, NULL, '123456789012345678', '2019-12-20', '123456789012345678', NULL, NULL, '2019-12-21 16:06:09', NULL, NULL, NULL, NULL, NULL, NULL, 6, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (12, '保险公司2', 7, 1, NULL, '123456789012345678', '2019-12-21', '12312312', NULL, NULL, '2019-12-21 16:53:04', NULL, NULL, NULL, NULL, NULL, NULL, 7, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (13, '检测机构1', 9, 1, NULL, '12345679012345678', '2019-12-25', '12312312312312', NULL, NULL, '2019-12-24 16:22:29', NULL, NULL, NULL, NULL, NULL, NULL, 9, NULL, NULL);
INSERT INTO `ddwb_finance_cominfo` VALUES (14, '订单企业1', 8, 1, NULL, '123456789012345678', '2019-12-26', '12312312312312312', NULL, NULL, '2019-12-25 10:14:24', NULL, NULL, NULL, NULL, NULL, NULL, 8, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

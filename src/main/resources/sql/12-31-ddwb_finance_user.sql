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

 Date: 28/12/2019 18:46:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_finance_user
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_finance_user`;
CREATE TABLE `ddwb_finance_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tel_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `user_type` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `char_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num_one` decimal(32, 8) NULL DEFAULT NULL,
  `num_two` decimal(32, 8) NULL DEFAULT NULL,
  `int_one` int(11) NULL DEFAULT NULL,
  `int_two` int(11) NULL DEFAULT NULL,
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ddwb_finance_user
-- ----------------------------
INSERT INTO `ddwb_finance_user` VALUES (1, 'shenchuankun', '9983285214969AF333726420B52E23C0', '18030931916', 'k5hmfw', NULL, NULL, 1, 1, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (2, 'baoxian', '9983285214969AF333726420B52E23C0', '17353001925', 'k5hmfw', NULL, NULL, 1, 2, '2019-12-16 11:14:20', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (3, 'danbao1', 'B7ED55F23F23E0BDDB0BBF0425AC8191', NULL, '9119b2', NULL, NULL, 1, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (4, 'yinhan1', 'C06CA2DB54645995248E49BBC843938D', NULL, '1y7lfb', NULL, NULL, 1, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (5, 'hezuoshe1', 'FB8D3CBC66772E165BA798F2ACE97C13', NULL, '21yi97', NULL, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (6, 'hezuoshe2', '72A240ABD492EB77C1A0CEDAFBCBF84C', NULL, 'b1q8lw', NULL, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (7, 'baoxian2', 'B1D5C024C37BB06C78A12715F5270572', NULL, '0pr1cv', NULL, NULL, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (8, 'orderuser1', '4BB8998EA63D64D1883FC1677BF2863D', NULL, '9ll87m', NULL, NULL, 1, 4, '2019-12-24 15:18:26', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (9, 'jiance1', '798046A825BED6BE41C441031C5769C8', NULL, 'aoiilo', NULL, NULL, 1, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (10, 'test1222', '51D71C84B4FC0B1078FAF42E651F760E', '13452323232', 'usyg7a', NULL, NULL, 1, 2, '2019-12-27 17:03:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (14, 'test1111', '57A68857FD6B3748C3AB40BAAAF1362B', '13435506572', 'skstw6', NULL, NULL, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (15, 'test111', 'EB7C86EA4EE1CA5CC6D2FDB8A760DD55', '13435504444', '18d4d0', NULL, NULL, 1, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ddwb_finance_user` VALUES (16, 'baoxian3', 'DA67BE2768A812ED17855CD24B9253F6', '13750528071', 'd4glpp', NULL, NULL, 1, 2, '2019-12-28 10:59:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

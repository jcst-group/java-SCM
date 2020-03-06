/*
 Date: 27/08/2019 16:10:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_trace_record
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_trace_record`;
CREATE TABLE `ddwb_trace_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '溯源记录id',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `batch_id` int(11) NULL DEFAULT NULL COMMENT '批次id',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '溯源查看记录表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

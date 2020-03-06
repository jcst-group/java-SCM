/*
 Date: 27/08/2019 16:10:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_trace_count
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_trace_count`;
CREATE TABLE `ddwb_trace_count`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '次数id',
  `batch_id` int(11) NOT NULL COMMENT '批次id',
  `total_count` int(11) NULL DEFAULT NULL COMMENT '查询总次数',
  `first_time` datetime(0) NULL DEFAULT NULL COMMENT '首次查询时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '溯源批次查询总次数表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

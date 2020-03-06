/*

 Date: 27/08/2019 16:10:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_trace_area_count
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_trace_area_count`;
CREATE TABLE `ddwb_trace_area_count`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地区次数id',
  `batch_id` int(11) NOT NULL COMMENT '批次id',
  `area_count` int(11) NULL DEFAULT NULL COMMENT '所在地区查看次数',
  `region` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份名称',
  `region_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份id',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地级市名称',
  `city_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地级市id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '溯源地区查询次数表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : 农芯西南数据库
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 47.108.66.5:3306
 Source Schema         : ddwb

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 04/12/2019 15:44:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddwb_market_good
-- ----------------------------
DROP TABLE IF EXISTS `ddwb_market_good`;
CREATE TABLE `ddwb_market_good`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_src` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `good_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `good_price` decimal(30, 8) NULL DEFAULT NULL,
  `specis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `from_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `good_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `save_one` decimal(30, 8) NULL DEFAULT NULL,
  `save_two` decimal(30, 8) NULL DEFAULT NULL,
  `char_one` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `char_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_one` int(11) NULL DEFAULT NULL,
  `id_two` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ddwb_market_good
-- ----------------------------
INSERT INTO `ddwb_market_good` VALUES (1, 'https://shop.wylmall.com/image/cache/catalog/new/ef5ee0e6e412fded77d2da5cda0c2ad-70x70.jpg', '脉冬旺 饮料', 70.00000000, '310ml*20罐/件', '四川省三台县', '优等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=78', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (2, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '有机麦冬（散装）', 350.00000000, '1000克', '四川省三台县', '特等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=77', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (3, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（二等）/kg', 62.00000000, '1000克', '四川省三台县', '二等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=76', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (4, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（三等）/kg', 40.00000000, '1000克', '四川省三台县', '三等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=75', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (5, 'https://shop.wylmall.com/image/cache/catalog/%E4%BA%A7%E5%93%81/150g%E9%BA%A6%E5%86%AC-70x70.jpg', '150g麦冬/瓶', 58.00000000, '150克', '四川省三台县', '一等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=66&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (6, 'https://shop.wylmall.com/image/cache/catalog/%E4%BA%A7%E5%93%81/200g%E9%BA%A6%E5%86%AC-70x70.jpg', '200g麦冬/瓶', 68.00000000, '200克', '四川省三台县', '一等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=67&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (7, 'https://shop.wylmall.com/image/cache/catalog/%E4%BA%A7%E5%93%81/450g%E9%BA%A6%E5%86%AC%E7%A4%BC%E7%9B%921-70x70.JPG', '450g麦冬/盒', 238.00000000, '450克', '四川省三台县', '一等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=68&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (8, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（二等，低药残）/kg', 160.00000000, '1000克', '四川省三台县', '特等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=70&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (12, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（三等，低药残）/kg', 120.00000000, '1000克', '四川省三台县', '三等，低药残', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=71&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (13, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（统货）/kg', 55.00000000, '1000克', '四川省三台县', '统货', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=73&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (14, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（统货，低药残）/kg', 160.00000000, '1000克', '四川省三台县', '统货，低药残', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=72&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (15, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（一等）/kg', 75.00000000, '1000克', '四川省三台县', '一等', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=74&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);
INSERT INTO `ddwb_market_good` VALUES (16, 'https://shop.wylmall.com/image/cache/catalog/new/001-70x70.jpg', '麦冬（一等，低药残）/kg', 200.00000000, '1000克', '四川省三台县', '一等，低药残', NULL, NULL, NULL, 'https://shop.wylmall.com/index.php?route=product/product&product_id=69&search=%E9%BA%A6%E5%86%AC', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

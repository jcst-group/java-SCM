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

 Date: 27/09/2019 17:34:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_resource_rel
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource_rel`;
CREATE TABLE `auth_resource_rel`  (
  `resource_id` int(11) NOT NULL COMMENT '权限id',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url',
  INDEX `resource_id`(`resource_id`) USING BTREE,
  CONSTRAINT `auth_resource_rel_ibfk_1` FOREIGN KEY (`resource_id`) REFERENCES `auth_resource` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_resource_rel
-- ----------------------------
INSERT INTO `auth_resource_rel` VALUES (354, '/cropBatch/all');
INSERT INTO `auth_resource_rel` VALUES (354, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (357, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (358, '/familyMenber/add');
INSERT INTO `auth_resource_rel` VALUES (358, '/familyMenber/update');
INSERT INTO `auth_resource_rel` VALUES (358, '/familyMenber/delete');
INSERT INTO `auth_resource_rel` VALUES (359, '/equipment/getEquipmentIdAndNameList');
INSERT INTO `auth_resource_rel` VALUES (363, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (368, '/retroCoding/getBatchByType');
INSERT INTO `auth_resource_rel` VALUES (368, '/retroCoding/getResidualOutput');
INSERT INTO `auth_resource_rel` VALUES (369, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (369, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (370, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (370, '/cropBatch/getBatchByPlanId');
INSERT INTO `auth_resource_rel` VALUES (375, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (376, '/detectionItems/getSeedDetection');
INSERT INTO `auth_resource_rel` VALUES (376, '/seed/all');
INSERT INTO `auth_resource_rel` VALUES (376, '/pictureInfo/addSeedDetectionPic');
INSERT INTO `auth_resource_rel` VALUES (376, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (377, '/detectionItems/getSeedDetection');
INSERT INTO `auth_resource_rel` VALUES (377, '/seed/all');
INSERT INTO `auth_resource_rel` VALUES (377, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (377, '/pictureInfo/addSeedDetectionPic');
INSERT INTO `auth_resource_rel` VALUES (380, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (381, '/probatch/getInitProVoByPlanId');
INSERT INTO `auth_resource_rel` VALUES (381, '/pictureInfo/addInitProDetectionPic');
INSERT INTO `auth_resource_rel` VALUES (381, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (382, '/probatch/getInitProVoByPlanId');
INSERT INTO `auth_resource_rel` VALUES (382, '/pictureInfo/addInitProDetectionPic');
INSERT INTO `auth_resource_rel` VALUES (382, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (384, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (385, '/recoveryBatch/getRecoveryByCropId');
INSERT INTO `auth_resource_rel` VALUES (386, '/recoveryBatch/getRecoveryByCropId');
INSERT INTO `auth_resource_rel` VALUES (388, '/cropBatch/all');
INSERT INTO `auth_resource_rel` VALUES (389, '/recoveryBatch/getRecoveryVo');
INSERT INTO `auth_resource_rel` VALUES (390, '/recoveryBatch/getRecoveryVo');
INSERT INTO `auth_resource_rel` VALUES (392, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (393, '/crop/getIdAndNameById');
INSERT INTO `auth_resource_rel` VALUES (393, '/harvestedPro/getHarvestedByCropId');
INSERT INTO `auth_resource_rel` VALUES (393, '/processing/selectByCropId');
INSERT INTO `auth_resource_rel` VALUES (393, '/cropPro/getCropProductByHarvestedId');
INSERT INTO `auth_resource_rel` VALUES (393, '/recoveryBatch/getRecoveryByPlanId');
INSERT INTO `auth_resource_rel` VALUES (394, '/processing/selectByCropId');
INSERT INTO `auth_resource_rel` VALUES (394, '/harvestedPro/getHarvestedByCropId');
INSERT INTO `auth_resource_rel` VALUES (396, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (400, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (401, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (401, '/pictureInfo/addRecDetectionResultPic');
INSERT INTO `auth_resource_rel` VALUES (401, '/pictureInfo/addRecDetectionPic');
INSERT INTO `auth_resource_rel` VALUES (401, '/detectionItems/getRecoveryDetection');
INSERT INTO `auth_resource_rel` VALUES (401, '/recoveryBatch/getRecoveryByPlanId');
INSERT INTO `auth_resource_rel` VALUES (402, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (402, '/pictureInfo/addRecDetectionResultPic');
INSERT INTO `auth_resource_rel` VALUES (402, '/pictureInfo/addRecDetectionPic');
INSERT INTO `auth_resource_rel` VALUES (402, '/recoveryBatch/getRecoveryByPlanId');
INSERT INTO `auth_resource_rel` VALUES (404, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (410, '/cropBatch/all');
INSERT INTO `auth_resource_rel` VALUES (410, '/prepareItem/getYear');
INSERT INTO `auth_resource_rel` VALUES (411, '/workOrder/getOrderLocal');
INSERT INTO `auth_resource_rel` VALUES (411, '/workOrder/setAuditFailed');
INSERT INTO `auth_resource_rel` VALUES (411, '/workOrder/setAuditApproval');
INSERT INTO `auth_resource_rel` VALUES (411, '/workOrder/setNotAudited');
INSERT INTO `auth_resource_rel` VALUES (413, '/pictureInfo/addCropPic');
INSERT INTO `auth_resource_rel` VALUES (413, '/pictureInfo/addEdibleValuePic');
INSERT INTO `auth_resource_rel` VALUES (413, '/pictureInfo/addMedicinalValuePic');
INSERT INTO `auth_resource_rel` VALUES (413, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (414, '/harvestedPro/delete');
INSERT INTO `auth_resource_rel` VALUES (414, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (414, '/pictureInfo/addMedicinalValuePic');
INSERT INTO `auth_resource_rel` VALUES (414, '/pictureInfo/addEdibleValuePic');
INSERT INTO `auth_resource_rel` VALUES (414, '/pictureInfo/addCropPic');
INSERT INTO `auth_resource_rel` VALUES (416, '/baseInfo/selectAll');
INSERT INTO `auth_resource_rel` VALUES (417, '/user/getUserAndRole');
INSERT INTO `auth_resource_rel` VALUES (419, '/equipment/getEquipmentIdAndNameList');
INSERT INTO `auth_resource_rel` VALUES (419, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (419, '/envmonitor/getEnvChart');
INSERT INTO `auth_resource_rel` VALUES (424, '/resource/list');
INSERT INTO `auth_resource_rel` VALUES (424, '/appResource/list');
INSERT INTO `auth_resource_rel` VALUES (424, '/showResource/list');
INSERT INTO `auth_resource_rel` VALUES (425, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (426, '/pictureInfo/addFarmingItemPic');
INSERT INTO `auth_resource_rel` VALUES (426, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (427, '/pictureInfo/addFarmingItemPic');
INSERT INTO `auth_resource_rel` VALUES (427, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (429, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (430, '/seed/all');
INSERT INTO `auth_resource_rel` VALUES (430, '/lot/selectByYear');
INSERT INTO `auth_resource_rel` VALUES (430, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (430, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (431, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (431, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (431, '/seed/all');
INSERT INTO `auth_resource_rel` VALUES (431, '/lot/selectByYear');
INSERT INTO `auth_resource_rel` VALUES (436, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (436, '/planYear/getPlanYearByPlanId');
INSERT INTO `auth_resource_rel` VALUES (436, '/farming/list');
INSERT INTO `auth_resource_rel` VALUES (436, '/deviceInfo/list');
INSERT INTO `auth_resource_rel` VALUES (436, '/materialInfo/list');
INSERT INTO `auth_resource_rel` VALUES (436, '/personnelInfo/list');
INSERT INTO `auth_resource_rel` VALUES (437, '/planYear/add');
INSERT INTO `auth_resource_rel` VALUES (437, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (437, '/farmingItem/getFarmingItemByCropId');
INSERT INTO `auth_resource_rel` VALUES (437, '/farming/add');
INSERT INTO `auth_resource_rel` VALUES (437, '/pictureInfo/addMaterialPic');
INSERT INTO `auth_resource_rel` VALUES (437, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (437, '/materialInfo/add');
INSERT INTO `auth_resource_rel` VALUES (437, '/deviceInfo/add');
INSERT INTO `auth_resource_rel` VALUES (437, '/personnelInfo/add');
INSERT INTO `auth_resource_rel` VALUES (438, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (438, '/farmingItem/getFarmingItemByCropId');
INSERT INTO `auth_resource_rel` VALUES (438, '/farming/update');
INSERT INTO `auth_resource_rel` VALUES (438, '/pictureInfo/addMaterialPic');
INSERT INTO `auth_resource_rel` VALUES (438, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (438, '/materialInfo/update');
INSERT INTO `auth_resource_rel` VALUES (438, '/deviceInfo/update');
INSERT INTO `auth_resource_rel` VALUES (438, '/personnelInfo/update');
INSERT INTO `auth_resource_rel` VALUES (440, '/companyInfo/list');
INSERT INTO `auth_resource_rel` VALUES (441, '/fertilizers/insert');
INSERT INTO `auth_resource_rel` VALUES (441, '/fertilizers/update');
INSERT INTO `auth_resource_rel` VALUES (441, '/fertilizers/delete');
INSERT INTO `auth_resource_rel` VALUES (441, '/companyInfo/addMPicure');
INSERT INTO `auth_resource_rel` VALUES (441, '/companyInfo/update');
INSERT INTO `auth_resource_rel` VALUES (441, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (441, '/companyInfo/addHPicure');
INSERT INTO `auth_resource_rel` VALUES (441, '/companyInfo/uploadVideoCompany');
INSERT INTO `auth_resource_rel` VALUES (441, '/companyInfo/uploadVideoCompany');
INSERT INTO `auth_resource_rel` VALUES (441, '/companyInfo/uploadVideoProduct');
INSERT INTO `auth_resource_rel` VALUES (442, '/envStandards/all');
INSERT INTO `auth_resource_rel` VALUES (442, '/area/getAreaByLevel');
INSERT INTO `auth_resource_rel` VALUES (444, '/pictureInfo/addBasePic');
INSERT INTO `auth_resource_rel` VALUES (444, '/pictureInfo/addWaterPic');
INSERT INTO `auth_resource_rel` VALUES (443, '/pictureInfo/addAirPic');
INSERT INTO `auth_resource_rel` VALUES (443, '/pictureInfo/addSoilPic');
INSERT INTO `auth_resource_rel` VALUES (443, '/area/getAreaByParentCode');
INSERT INTO `auth_resource_rel` VALUES (444, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (443, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (443, '/pictureInfo/addBasePic');
INSERT INTO `auth_resource_rel` VALUES (443, '/pictureInfo/addWaterPic');
INSERT INTO `auth_resource_rel` VALUES (444, '/pictureInfo/addAirPic');
INSERT INTO `auth_resource_rel` VALUES (444, '/pictureInfo/addSoilPic');
INSERT INTO `auth_resource_rel` VALUES (444, '/area/getAreaByParentCode');
INSERT INTO `auth_resource_rel` VALUES (446, '/baseInfo/selectByPrimaryKey');
INSERT INTO `auth_resource_rel` VALUES (446, '/user/getFarmer');
INSERT INTO `auth_resource_rel` VALUES (446, '/lot/add');
INSERT INTO `auth_resource_rel` VALUES (446, '/lot/update');
INSERT INTO `auth_resource_rel` VALUES (446, '/lot/delete');
INSERT INTO `auth_resource_rel` VALUES (448, '/farmingItem/getFarmingItemByCropId');
INSERT INTO `auth_resource_rel` VALUES (448, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (448, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (449, 'farmingItem/getFarmingItemByCropId');
INSERT INTO `auth_resource_rel` VALUES (449, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (449, '/crop/all');
INSERT INTO `auth_resource_rel` VALUES (447, '/deviceInfo/list');
INSERT INTO `auth_resource_rel` VALUES (447, '/materialInfo/list');
INSERT INTO `auth_resource_rel` VALUES (447, '/personnelInfo/list');
INSERT INTO `auth_resource_rel` VALUES (448, '/materialInfo/add');
INSERT INTO `auth_resource_rel` VALUES (448, '/deviceInfo/add');
INSERT INTO `auth_resource_rel` VALUES (448, '/personnelInfo/add');
INSERT INTO `auth_resource_rel` VALUES (448, '/pictureInfo/addMaterialPic');
INSERT INTO `auth_resource_rel` VALUES (448, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (449, '/materialInfo/update');
INSERT INTO `auth_resource_rel` VALUES (449, '/pictureInfo/addMaterialPic');
INSERT INTO `auth_resource_rel` VALUES (449, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (449, '/deviceInfo/update');
INSERT INTO `auth_resource_rel` VALUES (449, '/personnelInfo/update');
INSERT INTO `auth_resource_rel` VALUES (451, '/workOrder/addTemporaryOrder');
INSERT INTO `auth_resource_rel` VALUES (451, '/workOrder/revokeTemporaryOrder');
INSERT INTO `auth_resource_rel` VALUES (452, '/batchEnvironment/add');
INSERT INTO `auth_resource_rel` VALUES (8, '/user/checkUser');
INSERT INTO `auth_resource_rel` VALUES (8, '/pictureInfo/addUserHeadPic');
INSERT INTO `auth_resource_rel` VALUES (8, '/pictureInfo/addUserHukouPic');
INSERT INTO `auth_resource_rel` VALUES (8, '/pictureInfo/addIdentifyCodePic');
INSERT INTO `auth_resource_rel` VALUES (8, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (10, '/user/checkUser');
INSERT INTO `auth_resource_rel` VALUES (10, '/pictureInfo/addUserHeadPic');
INSERT INTO `auth_resource_rel` VALUES (10, '/pictureInfo/addUserHukouPic');
INSERT INTO `auth_resource_rel` VALUES (10, '/pictureInfo/addIdentifyCodePic');
INSERT INTO `auth_resource_rel` VALUES (10, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (11, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (440, '/team/list');
INSERT INTO `auth_resource_rel` VALUES (441, '/fileInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (441, '/team/insert');
INSERT INTO `auth_resource_rel` VALUES (441, '/team/update');
INSERT INTO `auth_resource_rel` VALUES (441, '/team/delete');
INSERT INTO `auth_resource_rel` VALUES (446, '/pictureInfo/addLotPic');
INSERT INTO `auth_resource_rel` VALUES (446, '/pictureInfo/delete');
INSERT INTO `auth_resource_rel` VALUES (456, '/equipment/getEquipmentIdAndNameList');
INSERT INTO `auth_resource_rel` VALUES (456, ' /baseInfo/getBaseEquipment');
INSERT INTO `auth_resource_rel` VALUES (430, '/lot/all');
INSERT INTO `auth_resource_rel` VALUES (430, '/seed/getSeedAndBatch');
INSERT INTO `auth_resource_rel` VALUES (431, '/lot/all');
INSERT INTO `auth_resource_rel` VALUES (431, '/seed/getSeedAndBatch');
INSERT INTO `auth_resource_rel` VALUES (452, '/pictureInfo/addProCropPic');
INSERT INTO `auth_resource_rel` VALUES (447, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (449, '/farmingItem/getFarmingItemByCropId');
INSERT INTO `auth_resource_rel` VALUES (354, '/role/all');
INSERT INTO `auth_resource_rel` VALUES (354, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (410, '/plantingPlan/all');
INSERT INTO `auth_resource_rel` VALUES (409, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (401, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (402, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (381, '/detectionItems/getIniproDetection');
INSERT INTO `auth_resource_rel` VALUES (376, '/pictureInfo/addSeedDetectionResultPic');
INSERT INTO `auth_resource_rel` VALUES (377, '/pictureInfo/addSeedDetectionResultPic');
INSERT INTO `auth_resource_rel` VALUES (462, '/equipment/getEquipmentIdAndNameList');
INSERT INTO `auth_resource_rel` VALUES (388, '/cropBatch/getBatchAndRecovery');
INSERT INTO `auth_resource_rel` VALUES (376, '/seed/getSeedAndBatch');
INSERT INTO `auth_resource_rel` VALUES (377, '/seed/getSeedAndBatch');
INSERT INTO `auth_resource_rel` VALUES (472, '/baseInfo/all');
INSERT INTO `auth_resource_rel` VALUES (472, '/illness/all');
INSERT INTO `auth_resource_rel` VALUES (473, 'illFeedback/processFeedback');

SET FOREIGN_KEY_CHECKS = 1;

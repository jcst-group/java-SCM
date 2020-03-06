
#后台权限添加
INSERT INTO `ddwb`.`auth_resource`(`ID`, `CODE`, `NAME`, `PARENT_ID`, `URI`, `TYPE`, `METHOD`, `ICON`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (484, '/waitHandle', '待处理事项', 16, NULL, 1, NULL, NULL, 1, NULL, NULL);

INSERT INTO `ddwb`.`auth_resource`(`ID`, `CODE`, `NAME`, `PARENT_ID`, `URI`, `TYPE`, `METHOD`, `ICON`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (483, '/orderApply/getPendDisCount', '待处理事项', 484, NULL, 2, NULL, NULL, 1, NULL, NULL);

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/workOrder/list');
INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/orderApply/getOrderByApply');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/workOrder/updateAllowedExecute');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/workOrder/getOrderLocal');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/workOrder/update');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/workOrder/setAuditApproval');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/workOrder/setAuditFailed');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/orderApply/getOrderApply');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (483, '/orderApply/update');
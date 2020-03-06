#app权限添加
INSERT INTO `ddwb`.`auth_app_resource_rel`(`resource_id`, `url`) VALUES (100, '/app/workOrder/addOrderApply');

INSERT INTO `ddwb`.`auth_app_resource_rel`(`resource_id`, `url`) VALUES (100, '/app/workOrder/getOrderApply');
#后台权限添加
INSERT INTO `ddwb`.`auth_resource`(`ID`, `CODE`, `NAME`, `PARENT_ID`, `URI`, `TYPE`, `METHOD`, `ICON`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (482, '/workOrder/updateAllowedExecute', '工单执行许可', 33, NULL, 2, NULL, NULL, 1, NULL, NULL);

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (437, '/farming/updateSequExecute');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (438, '/farming/updateSequExecute');

INSERT INTO `ddwb`.`ddwb_constant_storage`(`type`,`constant`) VALUES (4, 'http://board.scddwb.com/');

INSERT INTO `ddwb`.`auth_resource_rel`(`resource_id`, `url`) VALUES (363, '/equipment/getBoardUrl');

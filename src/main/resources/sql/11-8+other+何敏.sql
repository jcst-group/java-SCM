#修改单位字段类型
alter table ddwb_env_standards MODIFY unit int(11) NOT NULL COMMENT '检测单位';
#添加基地环境检测单位外键
alter table ddwb_env_standards add constraint fk_unit foreign key(unit) REFERENCES ddwb_unit(value);
#修改单位字段类型
alter table ddwb_detection_items MODIFY unit int(11) NOT NULL COMMENT '检测单位';
#添加检测项目单位外键
alter table ddwb_detection_items add constraint fk_item_unit foreign key(unit) REFERENCES ddwb_unit(value);
#工单添加强制执行字段
ALTER TABLE ddwb_work_order ADD allowed_execute TINYINT DEFAULT 0 COMMENT '允许时间外执行 0:false  1:true'; 
#工单添加结束时间字段
ALTER TABLE ddwb_work_order ADD end_time datetime COMMENT '结束时间'; 
#工单结束时间字段赋值
UPDATE ddwb_work_order a
INNER JOIN ddwb_farming b
ON a.farming_id = b.id
SET a.end_time = (DATE_ADD(a.execution_time,INTERVAL b.farming_cycle DAY))
#后台权限添加
INSERT INTO `ddwb`.`auth_resource`(`ID`, `CODE`, `NAME`, `PARENT_ID`, `URI`, `TYPE`, `METHOD`, `ICON`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (481, '/feedBack/update', '巡视反馈处理', 348, NULL, 2, NULL, NULL, 1, NULL, NULL);
#app权限添加
INSERT INTO `ddwb`.`auth_app_resource_rel`(`resource_id`, `url`) VALUES (100, '/app/push/addCid');
INSERT INTO `ddwb`.`auth_app_resource_rel`(`resource_id`, `url`) VALUES (100, '/app/push/addCid');
INSERT INTO `ddwb`.`auth_app_resource_rel`(`resource_id`, `url`) VALUES (100, '/app/workOrder/getSequExecuteOrder');
INSERT INTO `ddwb`.`auth_app_resource_rel`(`resource_id`, `url`) VALUES (101, '/app/feedBack/list');
#公司信息添加商城url
ALTER TABLE ddwb_company_info ADD shop_url VARCHAR(255) COMMENT '商城链接';
#农事添加是否按序执行字段
ALTER TABLE ddwb_farming ADD sequ_execute TINYINT DEFAULT 0 COMMENT '是否按序执行 0:false  1:true';  
#工单添加是否按序执行字段
ALTER TABLE ddwb_work_order ADD sequ_execute TINYINT DEFAULT 0 COMMENT '是否按序执行 0:false  1:true'; 
#巡视反馈添加处理状态字段
ALTER TABLE ddwb_feedback ADD status SMALLINT(6) DEFAULT 1 COMMENT '处理状态 1:未处理 2:已处理';
#巡视反馈添加备注字段
ALTER TABLE ddwb_feedback ADD remark VARCHAR(255) COMMENT '备注';

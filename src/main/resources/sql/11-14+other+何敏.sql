#添加初加工外键
DELETE FROM ddwb_pro_batch_method_rel WHERE pro_batch_id IN(
	SELECT pro_batch_id FROM (SELECT a.pro_batch_id FROM ddwb_pro_batch_method_rel a
	LEFT JOIN ddwb_processing_methods b
	ON a.pro_method_id = b.id
	WHERE b.id IS NULL) a
);
alter table ddwb_pro_batch_method_rel add constraint fk_pro_method_id foreign key(pro_method_id) REFERENCES ddwb_processing_methods(id);
DELETE FROM ddwb_pro_batch_method_rel WHERE pro_batch_id IN(
	SELECT pro_batch_id FROM (SELECT a.pro_batch_id FROM ddwb_pro_batch_method_rel a
	LEFT JOIN ddwb_initialpro_batch b
	ON a.pro_batch_id = b.id
	WHERE b.id IS NULL) a
);
alter table ddwb_pro_batch_method_rel add constraint fk_pro_batch_id foreign key(pro_batch_id) REFERENCES ddwb_initialpro_batch(id) ON DELETE cascade ON UPDATE RESTRICT;
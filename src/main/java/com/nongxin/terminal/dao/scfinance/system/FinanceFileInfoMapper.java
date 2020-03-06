package com.nongxin.terminal.dao.scfinance.system;

import com.nongxin.terminal.entity.file.FileInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FinanceFileInfoMapper {

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 42 ")
    List<FileInfo>  getInsuranceOrder(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 44 ")
    List<FileInfo>  getLoanRelate(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 45 ")
    List<FileInfo>  getWarrantApply(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 46 ")
    List<FileInfo>  getLoanApply(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 47 ")
    List<FileInfo>  getWarrantApprove(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 48 ")
    List<FileInfo>  getLoanApprove(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 49 ")
    List<FileInfo>  getdetectApply(Integer orderId);

    @Select("select a.* from ddwb_file_info a where a.relation_id = #{orderId} and relation_type = 50 ")
    List<FileInfo>  getDetectResult(Integer orderId);
}

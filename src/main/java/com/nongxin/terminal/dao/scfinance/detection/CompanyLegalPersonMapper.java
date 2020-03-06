package com.nongxin.terminal.dao.scfinance.detection;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.detection.CompanyLegalPerson;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
public interface CompanyLegalPersonMapper extends BaseMapper<CompanyLegalPerson> {



    //relationType = 39 代表法人代码
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "pictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getLegalPersonPic"))
    })
    @Select("select * from ddwb_company_legal_person where 1=1 and ${ew.sqlSegment}")
    CompanyLegalPerson queryLegalPerson(@Param("ew") QueryWrapper wrapper);


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "pictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getLegalPersonPic"))
    })
    @Select("select * from ddwb_company_legal_person where finance_user_id = #{financeId}")
    CompanyLegalPerson queryOneByFinanceUserId(Integer financeId);
}

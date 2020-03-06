package com.nongxin.terminal.dao.scfinance.insurance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.insurance.InsurancePlantInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-13
 */
public interface InsurancePlantInfoMapper extends BaseMapper<InsurancePlantInfo> {

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "financeMembers",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.insurance.InsurancePlantInfoMapper.queryRelMebers")),
    })
    @Select(
            "select * from insurance_plant_info where insurance_id = #{OrderId} "
    )
    InsurancePlantInfo queryPlantInfoByOrderId(Integer OrderId);


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "idPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberPersonPic")),
            @Result(property = "concPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getJoinSocialPic",fetchType= FetchType.EAGER)),
            @Result(property = "headPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberheadPic",fetchType=FetchType.EAGER)),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getMemberAddress",fetchType= FetchType.EAGER))
    })
    @Select(
            " select a.* from finance_member a,insplant_member_rel b where b.member_id = a.id and b.info_id = #{infoId}"
    )
    List<FinanceMember> queryRelMebers(Integer infoId);


}

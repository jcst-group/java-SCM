package com.nongxin.terminal.dao.scfinance.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.scfinance.detection.FinanceCominfo;
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
public interface FinanceMemberMapper extends BaseMapper<FinanceMember> {

    @Select(
            "select * from finance_member "
                    + " ${ew.customSqlSegment}"
    )
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "idPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberPersonPic")),
            @Result(property = "concPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getJoinSocialPic")),
            @Result(property = "headPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberheadPic")),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getMemberAddress"))
    })
    IPage<FinanceMember> memberList(Page page, @Param("ew") QueryWrapper wrapper);


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "idPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberPersonPic")),
            @Result(property = "concPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getJoinSocialPic",fetchType=FetchType.EAGER)),
            @Result(property = "headPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberheadPic",fetchType=FetchType.EAGER)),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getMemberAddress",fetchType= FetchType.EAGER))
    })
    @Select("select * from finance_member ${ew.customSqlSegment}")
    List<FinanceMember> financeMemberList(@Param("ew") QueryWrapper wrapper);

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "idPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberPersonPic")),
            @Result(property = "concPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getJoinSocialPic",fetchType=FetchType.EAGER)),
            @Result(property = "headPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberheadPic",fetchType=FetchType.EAGER)),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getMemberAddress",fetchType= FetchType.EAGER))
    })
    @Select("select * from finance_member ${ew.customSqlSegment}")
    FinanceMember queryFinanceMemberOne(@Param("ew") QueryWrapper wrapper);

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "idPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberPersonPic")),
            @Result(property = "concPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getJoinSocialPic",fetchType=FetchType.EAGER)),
            @Result(property = "headPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberheadPic",fetchType=FetchType.EAGER)),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getMemberAddress",fetchType= FetchType.EAGER))
    })
    @Select("select * from finance_member where id = #{id}")
    FinanceMember queryFinanceMemberById(Integer id);

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "pictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getFinanceBusinessPic")),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getCompanyAddress"))
    })
    @Select("select * from ddwb_finance_cominfo ${ew.customSqlSegment}")
    List<FinanceCominfo> queryFinanceCominfo(@Param("ew") QueryWrapper wrapper);

}

//    @Select("<script>"
//            + "select * from finance_member where 1=1"
//            + "<if test='ew != null'>"
//            + "and ${ew.sqlSegment}"
//            +"</if>"
//            +"</script>")

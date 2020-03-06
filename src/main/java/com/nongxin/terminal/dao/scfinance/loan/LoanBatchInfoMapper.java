package com.nongxin.terminal.dao.scfinance.loan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.insurance.LoanBatchInfo;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFarmItem;
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
 * @since 2019-12-18
 */
public interface LoanBatchInfoMapper extends BaseMapper<LoanBatchInfo> {

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "financeMembers",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.loan.LoanBatchInfoMapper.queryRelMebers")),
            @Result(property = "loanFarmItems",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.loan.LoanBatchInfoMapper.queryFarmItems")),
    })
    @Select(
            "select * from loan_batch_info where loan_apply_id = #{loanApplyId} "
    )
    LoanBatchInfo queryPlantInfoByloanApplyId(Integer loanApplyId);



    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "idPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberPersonPic")),
            @Result(property = "concPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getJoinSocialPic",fetchType= FetchType.EAGER)),
            @Result(property = "headPictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getMemberheadPic",fetchType=FetchType.EAGER)),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getMemberAddress",fetchType= FetchType.EAGER)),
    })
    @Select(
            " select a.* from finance_member a,loan_batch_member_rel b where b.member_id = a.id and b.info_id = #{infoId}"
    )
    List<FinanceMember> queryRelMebers(Integer infoId);


    /**
     * 用于查询
     * @param batchInfoId
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "farmingItem",column = "farming_item_id",
                    one = @One(select = "com.nongxin.terminal.dao.plant.FarmingItemMapper.selectByPrimaryKey"))
    })
    @Select(
            " select a.* from loan_farm_item a where a.loan_batch_id = #{batchInfoId}"
    )
    List<LoanFarmItem> queryFarmItems(Integer batchInfoId);

    /**
     * 用于查询
     * @param loanApplyId
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "farmingItem",column = "farming_item_id",
                    one = @One(select = "com.nongxin.terminal.dao.plant.FarmingItemMapper.selectByPrimaryKey")),
            @Result(property = "workOrder",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.plant.WorkOrderMapper.selectworkerOrderByLoanItemId")),
    })
    @Select(
            " select a.* from loan_farm_item a, loan_batch_info b where a.loan_batch_id = b.id and b.loan_apply_id = #{loanApplyId};"
    )
    List<LoanFarmItem> queryFarmItemsWithOrder(Integer loanApplyId);

}

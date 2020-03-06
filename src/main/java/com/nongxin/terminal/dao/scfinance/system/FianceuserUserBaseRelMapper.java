package com.nongxin.terminal.dao.scfinance.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.insurance.FianceuserUserBaseRel;
import com.nongxin.terminal.vo.insurance.CropBatchVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-19
 */
public interface FianceuserUserBaseRelMapper extends BaseMapper<FianceuserUserBaseRel> {



    @Select("select a.id,a.batch_name,b.base_name " +
            "from ddwb_crop_batch a,ddwb_base_info b,fianceuser_user_base_rel c " +
            "where a.base_id = b.id and b.id = c.base_id and a.status = 2 and c.financeuser_id = #{financeUserId}")
    List<CropBatchVo>  querryBaseRelateBatch(Integer financeUserId);

}

package com.nongxin.terminal.entity.scfinance.insurance;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author clover
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsplantMemberRel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer infoId;

    private Integer memberId;

    private Integer tenantId;


}

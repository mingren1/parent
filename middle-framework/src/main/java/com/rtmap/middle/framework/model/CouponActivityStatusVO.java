package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * 券批状态修改条件
 *
 * @author daishaolong@rtmap.com
 * @project app-coupon-luck
 * @package com.rtmap.ma.luck.common.request
 * @date 2018/7/12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class CouponActivityStatusVO {
    /**
     * 商场ID
     */
    private Long marketId;
    /**
     * 券批ID
     */
    @NotBlank(message = "券批ID不能为空")
    private String couponActivityId;
    /**
     * 操作状态英文名称
     */
    @NotBlank(message = "操作状态英文名称不能为空")
    private String operateAction;

}

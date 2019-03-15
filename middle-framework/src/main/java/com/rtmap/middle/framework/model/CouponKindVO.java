package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 券种列表条件
 */
@Getter
@Setter
@ToString(callSuper = true)
public class CouponKindVO {
    private String tenantId;//租户id
    private String token;//权限token
    private String loginId;//当前用户id
    private Integer page = 1;//页码
    private Integer pageSize = 10;//页数

    /**
     * 主体ID
     */
    @NotNull(message = "主体ID不能为空")
    private Integer portalId;
    /**
     * 主题类型
     */
    @NotNull(message = "主题类型不能为空")
    private Integer subjectType;
    /**
     * 商场ID
     */
    private Long marketId;
    /**
     * 商户ID
     */
    private Long shopId;
    /**
     * 券主标题
     */
    private String mainInfo;
}

/*
 * RT MAP, Home of Professional MAP
 * Copyright 2018-07-06 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 87114@rtmap.com
 * @project rtmap-scrm
 * @package com.rtmap.scrm.vo.score
 * @date 2018/7/6
 * @Description: 积分、成长值等补录参数实体
 */
@Getter
@Setter
@ToString
public class ReplenishParamVO {

    /**
     * 注册会员ID
     */
    @NotNull(message = "会员ID不能为空")
    private String cid;

    /**
     * 小票流水号即订单号
     */
    @NotNull(message = "订单号不能为空")
    private String orderNo;

    /**
     * 订单金额
     */
    @NotNull(message = "订单金额不能为空")
    private Long amount;

    /**
     * 交易主体名称(在哪个主体上消费)
     */
    private String tradeTenantName;

    /**
     * 交易主体号(在哪个主体上消费)
     */
    private String tradeTenantNo;

    /**
     * 交易主体类型
     */
    @NotNull(message = "交易主体类型不能为空")
    private Integer tradeTenantType;

    /**
     * 交易主体ID
     */
    @NotNull(message = "交易主体ID不能为空")
    private Long tradeTenantId;

    /**
     * 交易时间
     */
    @NotNull(message = "交易时间不能为空")
    private String tradeTime;

    private Long tenantId;

    private Integer tenantType;

    /**
     * 对应生成的trade记录ID,该值不是参数值
     */
    private Long tradeId;
    /**
     * 会员卡ID，该值不是参数值
     */
    private Long cardId;
    /**
     * 交易时间，对应tradeTime的值的转换，该值不是参数值
     */
    private Date bizTime;

    /**
     * 业务类型，该值不是参数值
     */
    private Integer bizType;

    /**
     * 备注信息，该值不是参数值
     */
    private String comment;

    /**
     * 支付类型1:支付宝 2:微信 3:银行卡号 4:其他，该值不是参数值
     */
    private Integer payType;

    /**
     * 会员类型，该值不是参数值
     * 会员类型 1：注册会员 2：支付会员 3：注册和支付会员 4：其他会员'
     */
    private Integer cidType;

    /**
     * 小票已被使用和正常补录都是返回状态200，为了区分返回是的小票已经被使用了还是操作成功
     * flag=1表示小票已经被使用，空或者其他值表示正常积分
     */
    private Integer flag;

    /**
     * 订单实付款金额
     */
    private Long payAmount;

    /**
     * 操作人
     */
    private Long optId;
    private String optName;
    /**
     * 数据来源ID
     */
    private String sourceId;
    /**
     * 数据来源
     */
    private String source;

}

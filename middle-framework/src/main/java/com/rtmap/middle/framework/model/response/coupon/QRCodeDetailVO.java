/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.coupon;

import com.rtmap.middle.framework.model.MaCouponImageBean;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.response.coupon
 * @date 2018/11/4
 */
@Data
public class QRCodeDetailVO {
    /**商场ID*/
    private Long marketId;
    /**券种ID*/
    private Long couponId;
    /**券批ID*/
    private String couponActivityId;
    /**活动ID*/
    private String activityId;
    /**活动名称*/
    private String activityName;
    /***/
    private String openId;
    private String openIdName;
    /**用户CRM id*/
    private String cid;
    /**券价值，分/RMB*/
    private Long cost;
    /**券面值，分/RMB*/
    private Long facePrice;
    /**券单价，分/RMB*/
    private Long unitPrice;
    /**券折扣*/
    private Integer discount;
    /**券消费门槛 0.无门槛，1有门槛*/
    private Integer conditionType;
    /**消费门槛，分/RMB*/
    private Long conditionPrice;
    /**券码*/
    private String qrCode;
    /**领取时间*/
    private Date getTime;
    /**核销时间*/
    private Date writeoffTime;
    /**有效期类型 0 固定有效期，1.领取后生效*/
    private Integer effectiveType;
    /**有效期开始时间*/
    private Long effectiveStartTime;
    /**有效期结束时间*/
    private Long effectiveEndTime;
    /**非固定有效期 领取后生效天数*/
    private Integer activedLimitedStartDay;
    /**非固定有效期，领取后有效天数*/
    private Integer activedLimitedDays;
    /**券码状态*/
    private Integer status;
    /**券码状态描述*/
    private String statusDesc;
    /**券标题*/
    private String mainInfo;
    /**副标题*/
    private String extendInfo;
    /**券说明*/
    private String descClause;
    /**券种的类型*/
    private Integer categoryId;
    /**券种类型的秒杀*/
    private String categoryDesc;
    /**核销人*/
    private String writeoffUser;
    /**核销渠道*/
    private String writeoffChannel;
    /**核销的名称*/
    private String writeOffName;

    private Long templateId;
    /**优惠券图片*/
    private List<MaCouponImageBean> couponImageList;
}

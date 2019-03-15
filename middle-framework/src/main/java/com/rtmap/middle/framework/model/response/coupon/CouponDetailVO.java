/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.coupon;

import com.rtmap.middle.framework.model.ApplyShopBean;
import com.rtmap.middle.framework.model.MaCouponImageBean;
import lombok.Data;

import java.util.List;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.response.coupon
 * @date 2018/11/4
 */
@Data
public class CouponDetailVO {
    private Long id;
    private Long marketId;
    private Long shopId;
    private Integer categoryId;
    private String categoryDesc;
    private String mainInfo;
    private String extendInfo;
    private Integer effectiveType;
    private String effectiveStartTime;
    private String effectiveEndTime;
    private Integer activedLimitedStartDay;
    private Integer activedLimitedDays;
    private Long facePrice;
    private Long unitPrice;
    private Long cost;
    private Integer discount;
    private Integer quantity;
    private Integer conditionType;
    private Long conditionPrice;
    private Boolean isPrecoupon;
    private Integer status;
    private String statusDesc;
    private String descClause;
    private String imgtxtInfo;
    private List<MaCouponImageBean> couponImageList;
    private List<ApplyShopBean> couponApplyShopList;
    /**领取数*/
    private Integer getNum;
    /**核销数*/
    private Integer writeoffNum;
    /**注券数*/
    private Integer pourNum;
    /**剩余数*/
    private Integer surplusNum;
    private Integer isAllShop;
    private Integer rectangle;

    private String getStartTime;
    private String getEndTime;
    private String displayStartTime;
    private String displayEndTime;
    private Integer displayTimeType;


}

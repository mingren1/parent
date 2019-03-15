/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;

/**
 * mq券实体
 */
@Getter
@Setter
public class MaCouponVO {
    //必填
    private Long couponId;//券ID
    private String couponActivityId;//券批ID
    private String qrCode;//券码
    private String cid;//会员ID
    private Long shopId;//商户ID，可手动指定退券商户
    private String tradeId;//支付订单id

    //非必填
    private Integer type = 1;//领取方式:1:微信openId  2:手机号 3:支付宝
    private Integer channelId;//渠道ID 1:微信渠道 2:短信渠道
    private String openId;//会员ID
    private String mobile;//微信标识
    private String aliPayId;//支付宝ID

}

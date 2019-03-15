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

@Getter
@Setter
public class PreGetCoupon {

    private Long couponId;
    private String couponActivityId;
    private String tradeId;

    private String activityId;
    private String getTime;
    private String qrCode;

    private String cid;
}

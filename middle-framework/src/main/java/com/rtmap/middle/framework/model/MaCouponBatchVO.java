/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model;

import lombok.Data;

@Data
public class MaCouponBatchVO {

    private Long tenantId;
    private Long marketId;
    private Long couponId;
    private String activityId;
    private String activityName;
    private int total;
}

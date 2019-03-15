/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.coupon;

import lombok.Data;

import java.util.Date;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.response.coupon
 * @date 2018/11/4
 */
@Data
public class QRCodePregrantResultVO {
    private Long couponId;
    private String activityId;
    private Date getTime;
    private String qrCode;
    private String couponActivityId;
    private String tradeId;
}

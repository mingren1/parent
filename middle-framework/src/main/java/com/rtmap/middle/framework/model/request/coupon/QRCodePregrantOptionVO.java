/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.request.coupon;

import lombok.Data;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.request.coupon
 * @date 2018/11/4
 */
@Data
public class QRCodePregrantOptionVO extends QRCodePregrantVO {
    private String qrCode;
    private String openId;
    private String cid;
    private Integer type;
    private Integer channelId;

    public QRCodePregrantOptionVO() {
        this.type = 1;
        this.channelId = 1;
    }
}

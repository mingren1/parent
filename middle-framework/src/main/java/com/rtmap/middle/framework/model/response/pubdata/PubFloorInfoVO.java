/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.pubdata;

import lombok.Data;

/**
 * @author chengshuxin@rtmap.com
 * @project CouponMALL
 * @package com.rtmap.micro.services.couponmall.client.dto.pubdata
 * @date 2018/9/10
 */
@Data
public class PubFloorInfoVO {
    /**
     * {
     * "floorId": "F10",
     * "floorName": "F10",
     * "floorAlias": "F10",
     * "description": "123213"
     * }
     */
    private String floorId;
    private String floorName;
    private String floorAlias;
    private String description;
}

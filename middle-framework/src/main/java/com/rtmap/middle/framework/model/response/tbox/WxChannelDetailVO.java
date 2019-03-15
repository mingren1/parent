/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.tbox;

import lombok.Data;

/**
 * @author chengshuxin@rtmap.com
 * @project CouponMALL
 * @package com.rtmap.micro.services.couponmall.client.vo.coupon
 * @date 2018/9/9
 */
@Data
public class WxChannelDetailVO {
    private Long id;
    private Long tenantId;
    private Integer tenantType;
    private String appId;
    private String name;
    private String shopName;
    private String path;
    private String channelTypeName;
    private Integer type;
    private String scanCodeUrl;
    private String qrcodeUrl;
    private Integer isValidate;
}

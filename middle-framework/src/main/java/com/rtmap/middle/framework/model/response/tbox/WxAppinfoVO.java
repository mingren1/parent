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
 * @project mini_apps
 * @package com.rtmap.micro.services.couponmall.client.dto.wx
 * @date 2018/9/27
 */
@Data
public class WxAppinfoVO {
    private String name;
    private Long tenantId;
    private Integer tenantType;
    private String appId;
    private String appSecret;
    private String mchId;
    private String paySign;
    private String notifyUrl;
    private String type;
    private String logo;
}

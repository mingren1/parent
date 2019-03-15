/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.pubdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author chengshuxin@rtmap.com
 * @project CouponMALL
 * @package com.rtmap.micro.services.couponmall.client.vo.pubdata
 * @date 2018/9/13
 */
@Data
public class PubShopSummaryVO {
    @JsonProperty("shopName")
    private String name;
    @JsonProperty("shopId")
    private Long id;
}

/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.request.market;

import com.rtmap.middle.framework.model.ApplyShopBean;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.request.payload
 * @date 2018/11/2
 */
@Data
public class ActivityApplyShopVO {
    /**
     * 活动ID
     */
    @NotNull(message = "活动ID不能为空")
    private String activityId;
    /**
     * 是否适用全商户 1.是 2.否
     */
    @NotNull(message = "参与主体类型不能为空")
    private Integer isAllShop;
    /**
     * 适用商户，部分商户时必填
     */
    private List<ApplyShopBean> applyShops;
}

/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.market;

import lombok.Data;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.response.market
 * @date 2018/11/2
 */
@Data
public class ActivityGroupVO {
    /**
     * 活动组ID
     * */
    private Integer id;
    /**
     * 商场主体ID
     * */
    private Integer portalId;
    /**
     * 活动组名称
     * */
    private String groupName;
}

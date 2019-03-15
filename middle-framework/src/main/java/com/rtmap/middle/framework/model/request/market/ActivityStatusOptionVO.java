/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.request.market;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.request.payload
 * @date 2018/11/2
 */
@Data
public class ActivityStatusOptionVO {
    /**
     * 活动ID
     */
    @NotBlank(message = "活动ID不能为空")
    private String activityId;

    /**
     * 活动状态： 0待配置，1进行中，2暂停，3已结束 4.待启动
     */
    @NotNull(message = "活动状态不能为空")
    @Range(min = 0, max = 4, message = "活动组状态有误")
    private Integer activityStatus;
}

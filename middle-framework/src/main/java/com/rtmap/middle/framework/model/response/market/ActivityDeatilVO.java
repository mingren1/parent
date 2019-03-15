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
public class ActivityDeatilVO {
    /**
     * 活动ID
     */
    private String activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动类型  0长期活动，1短期活动
     */
    private String activityType;
    /**
     * 活动状态：0待配置，1进行中，2暂停，3已结束 4.待启动
     */
    private Integer activityStatus;
    /**
     * 活动状态说明
     */
    private String activityStatusDesc;
    /**
     * 活动组id
     */
    private Long activityGroupId;
    /**
     * 活动组名
     */
    private String activityGroupName;
    /**
     * 应用ID
     */
    private Long appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用跳转地址
     */
    private String appUrl;
    /**
     * 活动开始时间
     */
    private String activityStartDate;
    /**
     * 活动结束时间
     */
    private String activityEndDate;
    /**
     * 是否适用全商户 1. 是 2. 否
     */
    private Integer isAllShop;
    /**
     * 主体ID
     */
    private Long portalId;
    /**
     * 主体类型 0
     */
    private Integer subjectType;
    /**
     * 活动规则
     */
    private String activityRule;
    /**
     * 应用logo
     */
    private String imgLogoUrl;
}

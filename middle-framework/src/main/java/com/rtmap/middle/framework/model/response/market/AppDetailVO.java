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
public class AppDetailVO {
    private Long id;
    private String name;
    private String code;
    private Integer needConnect;
    private Long appPrice;
    private Integer appType;
    private String imgLogoUrl;
    private String appUrl;
    private String manageUrl;

    /**
     * 应用状态 1正常，0下架
     */
    private Integer appStatus;
    private Long orderNum;
    private String createTime;
    /**
     * 应用的审核状态,0待审核，1审核通过，2审核失败
     */
    private Integer auditStatus;
    private String appCategoryName;
}

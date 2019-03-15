package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TenantInfoVO {

    /**
     * 主体名称
     */
    private String tenantName;
    /**
     * 建筑物ID
     */
    private String buildId;
    /**
     * 三方平台pushId
     */
    private String pushId;
    /**
     * 公众号appid
     */
    private String appid;

}

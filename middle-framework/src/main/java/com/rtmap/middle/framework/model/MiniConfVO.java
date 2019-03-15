package com.rtmap.middle.framework.model;

import lombok.Data;

@Data
public class MiniConfVO {

    private String name;

    private Long tenantId;

    private Integer tenantType;

    private String appId;

    private String appSecret;

    private String mchId;

    private String paySign;

    private String notifyUrl;

    private Integer type;

    private Integer isValidate;

    private String logo;

}

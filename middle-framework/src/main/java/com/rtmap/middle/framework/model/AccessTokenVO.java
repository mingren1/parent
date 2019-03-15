package com.rtmap.middle.framework.model;


import lombok.Data;

@Data
public class AccessTokenVO {
    private Integer tenantType;
    private Long tenantId;
    private String appId;

    private String accessToken;
}

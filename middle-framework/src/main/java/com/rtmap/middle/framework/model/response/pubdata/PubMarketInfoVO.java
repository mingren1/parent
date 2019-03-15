/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.pubdata;

import lombok.Data;

@Data
public class PubMarketInfoVO {
    private Long marketId;
    private String buildId;
    private String name;
    private String imgLogoUrl;
    private String companyAddress;
    private String companyName;
    private String email;
    private String tel;
}

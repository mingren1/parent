/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model;

import lombok.Data;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model
 * @date 2018/11/4
 */
@Data
public class MaCouponImageBean {
    private Long couponId;
    /**0 封面，1.非封面*/
    private Integer imgType;
    private String imgUrl;
}

/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.request.crm;

import lombok.Data;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.request.crm
 * @date 2018/11/15
 */
@Data
public class CrmRuleInfoVo {
    private Integer tenantType;
    private Long tenantId;
    private Integer tradeTenantType;
    private Long tradeTenantId;
    private Long cardId;

}

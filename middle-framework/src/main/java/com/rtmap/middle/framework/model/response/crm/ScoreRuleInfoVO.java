/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.crm;

import lombok.Data;

/**
 * @author ishuxin.me@rtmap.com
 * @project wxapp-services
 * @package com.rtmap.middle.framework.model.response.crm
 * @date 2018/11/15
 *
 * http://211.157.182.226:8090/pages/viewpage.action?pageId=16025407
 */
@Data
public class ScoreRuleInfoVO {
    private Long id;
    private Long cardId;
    private String cardName;
    private Integer perComsum;
    private Integer oneDayCapStatus;
    private Integer oneDayCap;
    private Integer effectRangeStatus;
    private Long subjectId;
    private String subjectName;
    private Integer ruleStatus;
    private Integer minAmountStatus;
    private Long minAmount;
}

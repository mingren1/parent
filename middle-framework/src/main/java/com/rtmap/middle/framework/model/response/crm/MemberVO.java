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
 * @date 2018/11/6
 */
@Data
public class MemberVO {
    private Integer total;
    private Integer balance;
    private Integer growthTotal;
    private Integer growth;
    private Long cardId;
    private String cardNo;
    private String cardName;
    private String grade;
    private String icon;
    private String username;
    private String name;
    private String nickname;
}

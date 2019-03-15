package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditScoreVO {
    private Long tenantId;
    private Integer tenantType;
    private String cid;
    /**
     * 调整数额
     * */
    private Integer adjustValue;
    private String comment;
}

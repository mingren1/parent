package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardVO {
    private Long tenantId;
    private Integer tenantType;
    private Integer pageSize;
    private String cid;

    private String cardName;//等级名称
    private Integer growth;//等级对应的成长值
    private Integer balance;//会员可用成长值
    private Integer total;//会员累计成长值
}

package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVO {

    private Integer tenantType;
    private Long tenantId;
    private String cid;

    private Integer cType;
    private Long name;
    private Integer balance;
    private Integer total;
    private Integer searchType;
    private String searchText;
}

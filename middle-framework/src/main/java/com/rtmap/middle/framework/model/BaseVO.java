/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model;


import com.rtmap.middle.framework.model.validate.DDataSyncValidate;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralQueryValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;

import javax.validation.constraints.NotNull;

/**
 * @author huzongtao@rtmap.com
 * @date 2017/3/14
 */
public abstract class BaseVO {

    private String v = "1.0.0";

    private Integer pageNum = 1;

    private Integer pageSize = 20;
    @NotNull(message = "租户Id不能为空", groups = {DGeneralCreateValidate.class,DGeneralUpdateValidate.class,DGeneralQueryValidate.class,DDataSyncValidate.class})
    private Long tenantId;
    @NotNull(message = "租户类型不能为空", groups = {DGeneralCreateValidate.class,DGeneralUpdateValidate.class,DGeneralQueryValidate.class,DDataSyncValidate.class})
    private Integer tenantType;

    private String searchText;

    private String searchColumn;

    private Integer startRow=0;
    /**
     * true:使用定制化service实现 false:使用通用service实现
     * @auther: jinjianjun
     */
    private boolean isCustom=true;

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getSearchColumn() {
        return searchColumn;
    }

    public void setSearchColumn(String searchColumn) {
        this.searchColumn = searchColumn;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getTenantType() {
        return tenantType;
    }

    public void setTenantType(Integer tenantType) {
        this.tenantType = tenantType;
    }
}

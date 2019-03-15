/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author huzongtao@rtmap.com
 * @package com.rtmap.scrm.vo.page
 * @date 2017/3/17
 */
@JsonPropertyOrder({"list"})
public class PageResponseVo<T> implements Serializable {

    private static final long serialVersionUID = 3101459014908527028L;

   /* public PageResponseVo(Page<T> page) {
        setPage(page);
    }

    public PageResponseVo(List<T> list) {
        setPage(list);
    }

    private void setPage(Page<T> page) {
        page = page == null ? new Page<>() : page;
        getProperty(new PageInfo<>(page.getResult()));
    }

    private void setPage(List<T> list) {
        list = CollectionUtils.isEmpty(list) ? new ArrayList<>(0) : list;
        getProperty(new PageInfo<>(list));
    }*/

    /**
     * updated by vector
     * 优化分页数据
     *
     * @param pageInfo
     */
    private void getProperty(PageInfo<T> pageInfo) {
        int pageNum = pageInfo.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;
        setPageNum(pageNum);
        int pageSize = pageInfo.getPageSize();
        pageSize = pageSize <= 0 ? 20 : pageSize;
        setPageSize(pageSize);
        setPages(pageInfo.getPages());
        setPrePage(pageInfo.getPrePage());
        setNextPage(pageInfo.getNextPage());
        setResult(pageInfo.getList());
        setTotal(pageInfo.getTotal());
        setStartRow(pageInfo.getStartRow());
        setEndRow(pageInfo.getEndRow());
    }

    @JsonProperty("list")
    private List<T> result;
    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private int prePage;
    private int nextPage;


    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}

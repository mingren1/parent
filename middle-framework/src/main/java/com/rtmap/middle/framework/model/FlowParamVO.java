package com.rtmap.middle.framework.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询积分流水
 *
 * @author zhangshaohua
 */
public class FlowParamVO extends BaseVO {
    private Integer type;
    private String startTime;
    private String endTime;
    private List<String> cidList = new ArrayList<>();
    // 提供给快速升降级使用单个会员查询一段时间的累计成长值
    private String memberCid;

    //操作类型，by 张磊
    private Integer biz;
    private Long userId;

    public String getCid() {
        return memberCid;
    }

    public void setCid(String memberCid) {
        this.memberCid = memberCid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getCidList() {
        return cidList;
    }

    public void setCidList(List<String> cidList) {
        this.cidList = cidList;
    }

    public Integer getBiz() {
        return biz;
    }

    public void setBiz(Integer biz) {
        this.biz = biz;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FlowParamVO{" +
                "type=" + type +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cidList=" + cidList +
                ", memberCid='" + memberCid + '\'' +
                ", biz=" + biz +
                ", userId=" + userId +
                '}';
    }
}

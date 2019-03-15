package com.rtmap.middle.framework.model;

/**
 * 积分、成长值调整请求参数
 *
 * @author zhangshaohua
 */
public class AccountAdjustParamVO extends BaseVO {
    private String cid;
    private Integer adjustValue;
    private String comment;
    private Long optId;
    private String optName;
    private String sourceId;
    private String source;
    private Long relationId;
    private String externalId;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getAdjustValue() {
        return adjustValue;
    }

    public void setAdjustValue(Integer adjustValue) {
        this.adjustValue = adjustValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getOptId() {
        return optId;
    }

    public void setOptId(Long optId) {
        this.optId = optId;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "AccountAdjustParamVO{" + "cid='" + cid + '\'' + ", adjustValue=" + adjustValue + ", comment='" + comment + '\'' + ", optId=" + optId + ", optName='" + optName + '\'' + ", sourceId='" + sourceId + '\'' + ", source='" + source + '\'' + ", relationId=" + relationId + ", externalId='" + externalId + '\'' + '}';
    }
}

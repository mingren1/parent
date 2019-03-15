package com.rtmap.middle.framework.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 积分、成长值流水查询
 *
 * @author zhangshaohua
 */
public class FlowResultVO {
    private Long id;
    private String name;
    private String cid;
    private String mobile;
    private String cardNo;
    private String openId;
    private String appId;
    private String mac;
    private String idfa;
    private String alipayid;
    private String imei;
    private String miniProgramOpenid;
    private String payerOpenid;
    private String payerAlipayid;
    private Long typeId;
    private String typeName;
    private String sourceId;
    private String source;
    private Integer adjustValue;
    private Long optId;
    private String optName;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Integer biz;
    //操作的类型的名称，by 张磊
    private String bizName;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date bizTime;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Integer getAdjustValue() {
        return adjustValue;
    }

    public void setAdjustValue(Integer adjustValue) {
        this.adjustValue = adjustValue;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBiz() {
        return biz;
    }

    public void setBiz(Integer biz) {
        this.biz = biz;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAlipayid() {
        return alipayid;
    }

    public void setAlipayid(String alipayid) {
        this.alipayid = alipayid;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMiniProgramOpenid() {
        return miniProgramOpenid;
    }

    public void setMiniProgramOpenid(String miniProgramOpenid) {
        this.miniProgramOpenid = miniProgramOpenid;
    }

    public String getPayerOpenid() {
        return payerOpenid;
    }

    public void setPayerOpenid(String payerOpenid) {
        this.payerOpenid = payerOpenid;
    }

    public String getPayerAlipayid() {
        return payerAlipayid;
    }

    public void setPayerAlipayid(String payerAlipayid) {
        this.payerAlipayid = payerAlipayid;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    @Override
    public String toString() {
        return "FlowResultVO{" + "id=" + id + ", name='" + name + '\'' + ", cid='" + cid + '\'' + ", mobile='" + mobile + '\'' + ", cardNo='" + cardNo + '\'' + ", openId='" + openId + '\'' + ", appId='" + appId + '\'' + ", mac='" + mac + '\'' + ", idfa='" + idfa + '\'' + ", alipayid='" + alipayid + '\'' + ", imei='" + imei + '\'' + ", miniProgramOpenid='" + miniProgramOpenid + '\'' + ", payerOpenid='" + payerOpenid + '\'' + ", payerAlipayid='" + payerAlipayid + '\'' + ", typeId=" + typeId + ", typeName='" + typeName + '\'' + ", sourceId='" + sourceId + '\'' + ", source='" + source + '\'' + ", adjustValue=" + adjustValue + ", optId=" + optId + ", optName='" + optName + '\'' + ", createTime=" + createTime + ", biz=" + biz + ", bizTime=" + bizTime + ", bizName=" + bizName + ", comment='" + comment + '\'' + '}';
    }
}

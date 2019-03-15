package com.rtmap.middle.framework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GetCouponVO {

    private String couponGroupId;

    private String giftPackageId;

    private Long couponId;

    private String activityId;

    private String openId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date getTime;

    private String qrCode;

    private Integer status;

    private String statusDesc;

    private String mainInfo;

    private String extendInfo;

    private Long categoryId;

    private String categoryDesc;

    private Long marketId;

    @JsonIgnore
    private String marketName;

    private Long shopId;

    @JsonIgnore
    private String shopName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date effectiveStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date effectiveEndTime;

    private Byte effectiveType;

    private Integer activedLimitedStartDay;

    private Integer activedLimitedDays;

    private Long facePrice;

    private Long unitPrice;

    private Byte discount;

    private Byte conditionType;

    private Long conditionPrice;

    private Long templateId;

    private String couponActivityId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date writeoffTime;

    private List couponApplyShopList = new ArrayList<>();

    private List couponImageList = new ArrayList<>();

    private List couponTagList = new ArrayList<>();

    private String wxOpenId;

    private Integer type;

    private Long channelId;

    private String descClause;

    private String imgtxtInfo;

    private Byte rectangle;

    private String imgLogoUrl;

    private String issuerName;

    private String cid;

    private String mobile;

    private String aliPayId;
}

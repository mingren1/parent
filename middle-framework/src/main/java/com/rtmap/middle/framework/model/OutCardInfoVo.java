package com.rtmap.middle.framework.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: OutCardInfoVo
 * @author: 
 * @Description:
 * @date: 6/20/18 15:36
 */
public class OutCardInfoVo implements Serializable{

    private Long id;

    private Integer tenantType;

    private Long tenantId;

    /**
     * 卡名称
     */
    private String cardName;

    /**
     * 卡等级编码
     */
    private String grade;

    /**
     * 卡样地址
     */
    private String imageUrl;

    /**
     * 卡快速升降级配置信息
     */
    private List<QuickGradeRuleVO> quickGradeRuleVOS;

    /**
     * 成长值
     */
    private Integer growth;
    /**
     * 保级基准成长值
     */
    private Integer downgradeGrowth;
    /**
     * 备注说明
     */
    private String comment;

    private Long clubId;

    public Integer getDowngradeGrowth() {
        return downgradeGrowth;
    }

    public void setDowngradeGrowth(Integer downgradeGrowth) {
        this.downgradeGrowth = downgradeGrowth;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<QuickGradeRuleVO> getQuickGradeRuleVOS() {
        return quickGradeRuleVOS;
    }

    public void setQuickGradeRuleVOS(List<QuickGradeRuleVO> quickGradeRuleVOS) {
        this.quickGradeRuleVOS = quickGradeRuleVOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getTenantType() {
        return tenantType;
    }

    public void setTenantType(Integer tenantType) {
        this.tenantType = tenantType;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }
}

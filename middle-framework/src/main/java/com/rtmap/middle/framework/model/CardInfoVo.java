package com.rtmap.middle.framework.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName: CardInfoVo
 * @Description: 
 * @author: chenliang
 * @date: 6/14/18 19:29
 */
public class CardInfoVo extends BaseVO{

    /**
     * 登陆凭证
     */
    private String token;

    private Long id;


    /**
     * 卡名称
     */
    @NotBlank(message = "卡名不能为空")
    private String cardName;

    /**
     * 卡样地址
     */
    @NotBlank(message = "卡样不能为空")
    private String imageUrl;

    /**
     * 升级基准成长值
     */
    @NotNull(message = "升级基准成长值不能为空")
    private Integer growth;
    /**
     * 保级基准成长值
     */
    //@NotNull(message = "保级基准成长值不能为空")
    private Integer downgradeGrowth;
    /**
     * 卡等级编码
     */
    private String grade;
    /**
     * 卡快速升降级配置信息
     */
    private List<QuickGradeRuleVO> quickGradeRuleVOS;
    /**
     * 备注说明
     */
    private String comment;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

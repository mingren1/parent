package com.rtmap.middle.framework.model;

/**
 * Description:
 *
 * @author jinjianjun
 * @date 2018/9/7
 */
public class QuickGradeRuleVO extends BaseVO {

    private Long cardId;

    private Integer gradeType;

    private Integer growth;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getGradeType() {
        return gradeType;
    }

    public void setGradeType(Integer gradeType) {
        this.gradeType = gradeType;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }
}

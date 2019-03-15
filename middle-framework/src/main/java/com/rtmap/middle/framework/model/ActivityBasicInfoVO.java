package com.rtmap.middle.framework.model;

import com.rtmap.middle.framework.annotation.Valid.AddValid;
import com.rtmap.middle.framework.annotation.Valid.EditValid;
import com.rtmap.middle.framework.annotation.Valid.AddValid;
import com.rtmap.middle.framework.annotation.Valid.EditValid;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class ActivityBasicInfoVO {
    /**
     * 活动iD
     */
    @NotBlank(message = "活动ID不能为空", groups = {EditValid.class})
    private String activityId;
    /**
     * 活动名称
     */
    @NotBlank(message = "活动名称不能为空", groups = {AddValid.class, EditValid.class})
    private String name;
    /**
     * 活动开始日期
     */
    private String activityStartDate;
    /**
     * 活动结束日期
     */
    private String activityEndDate;
    /**
     * 活动组ID
     */
    @NotNull(message = "活动组ID不能为空", groups = {AddValid.class, EditValid.class})
    private Long activityGroupId;
    /**
     * 活动组名称
     */
    private String activityGroupName;
    /**
     * 活动备注
     */
    private String remarks;
    /**
     * 活动类型：0长期活动，1短期活动
     */
    @NotNull(message = "活动类型不能为空", groups = {AddValid.class, EditValid.class})
    @Range(min = 0, max = 1, message = "活动类型不正确")
    private Integer activityType;
    /**
     * 账户主体ID
     */
    @NotNull(message = "商场ID不能为空", groups = {AddValid.class, EditValid.class})
    private Long portalId;
    /**
     * 账号类型：1商场，2商户
     */
    @NotNull(message = "账号类型不能为空", groups = {AddValid.class, EditValid.class})
    private Integer subjectType;
    /**
     * 应用ID
     */
    @NotNull(message = "appId不能为空", groups = {AddValid.class, EditValid.class})
    private Long appId;

//    private String platformType;
}

package com.rtmap.middle.framework.model.request.market;

import com.rtmap.middle.framework.annotation.Valid.AddValid;
import com.rtmap.middle.framework.annotation.Valid.EditValid;
import com.rtmap.middle.framework.annotation.Valid.AddValid;
import com.rtmap.middle.framework.annotation.Valid.EditValid;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ActivityGroupCreationVO {
    /**
     * 活动组名称
     */
    @NotBlank(message = "活动组名称不能为空", groups = {AddValid.class, EditValid.class})
    private String groupName;
    /**
     * 创建主体
     */
    @NotNull(message = "商场ID不能为空", groups = {AddValid.class, EditValid.class})
    private Long portalId;
    /**
     * 创建主体类型
     */
    @NotNull(message = "账号类型不能为空", groups = {AddValid.class, EditValid.class})
    private Integer subjectType;
    /**
     * MA应用AppId
     */
    @NotNull(message = "appId不能为空", groups = {AddValid.class, EditValid.class})
    private Integer appId;
}

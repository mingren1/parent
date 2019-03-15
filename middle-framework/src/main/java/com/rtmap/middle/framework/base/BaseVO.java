package com.rtmap.middle.framework.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtmap.middle.framework.annotation.Valid.EditValid;
import com.rtmap.middle.framework.annotation.Valid.EditValid;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BaseVO {

    private Context cxt;

    @NotNull(message = "id不能为空", groups = EditValid.class)
    private String id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JSONField(serialize = false)
    private Integer page = 1;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JSONField(serialize = false)
    private Integer pageSize = 10;
}

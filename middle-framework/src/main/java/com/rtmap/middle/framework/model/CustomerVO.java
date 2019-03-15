package com.rtmap.middle.framework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author jinjianjun
 * @date 2018/6/19
 */
public class CustomerVO extends BaseVO implements Serializable {

    @NotNull(message = "cid不能为空", groups = {GeneralUpdateValidate.class, DGeneralUpdateValidate.class})
    @NotBlank(message = "cid不能为空", groups = {GeneralUpdateValidate.class, DGeneralUpdateValidate.class})
    private String cid;

    @NotNull(message = "会员类型不能为空", groups = {GeneralUpdateValidate.class,GeneralCreateValidate.class,DGeneralCreateValidate.class, DGeneralUpdateValidate.class})
    private Integer cType;

    private String registerTime;

    private String externalId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

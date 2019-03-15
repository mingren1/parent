package com.rtmap.middle.framework.model.customer;


import com.rtmap.middle.framework.model.CustomerVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

//微信支付会员Vo
public class FansPayerVO extends CustomerVO implements Serializable {

    @NotNull(message = "openid不能为空" ,groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class, DGeneralUpdateValidate.class})
    @NotBlank(message = "openid不能为空" ,groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String openid;
    @NotNull(message = "appid不能为空" ,groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    @NotBlank(message = "appid不能为空" ,groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String appid;

    private static final long serialVersionUID = 1L;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
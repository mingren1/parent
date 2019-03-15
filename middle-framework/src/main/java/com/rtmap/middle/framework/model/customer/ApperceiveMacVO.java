package com.rtmap.middle.framework.model.customer;


import com.rtmap.middle.framework.model.CustomerVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

//感知会员MAC
public class ApperceiveMacVO extends CustomerVO implements Serializable {

    @NotNull(message = "mac地址不能为空",groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class, DGeneralUpdateValidate.class})
    @NotBlank(message = "mac地址不能为空",groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String mac;

    private static final long serialVersionUID = 1L;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

}
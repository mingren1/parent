package com.rtmap.middle.framework.model.customer;


import com.rtmap.middle.framework.model.CustomerVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

//感知会员Idfa
public class ApperceiveIdfaVO extends CustomerVO implements Serializable {

    @NotNull(message = "idfa不能为空",groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class, DGeneralUpdateValidate.class})
    @NotBlank(message = "idfa不能为空",groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String idfa;

    private static final long serialVersionUID = 1L;

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa == null ? null : idfa.trim();
    }

}


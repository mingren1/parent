package com.rtmap.middle.framework.model.customer;

import com.rtmap.middle.framework.model.CustomerVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerBankPayerVO extends CustomerVO implements Serializable {

    @NotNull(message = "银行卡号不能为空",groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class, DGeneralUpdateValidate.class})
    @NotBlank(message = "银行卡号不能为空",groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String bankCardNo;

    @NotNull(message = "银行卡类型不能为空",groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    @NotBlank(message = "银行卡类型不能为空",groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String bankCardType;

    private String firstPayTime;

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getFirstPayTime() {
        return firstPayTime;
    }

    public void setFirstPayTime(String firstPayTime) {
        this.firstPayTime = firstPayTime;
    }
}

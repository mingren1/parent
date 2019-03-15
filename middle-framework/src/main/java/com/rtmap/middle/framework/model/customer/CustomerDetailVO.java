package com.rtmap.middle.framework.model.customer;

import com.rtmap.middle.framework.model.*;
import com.rtmap.middle.framework.model.CustomerFansVO;
import com.rtmap.middle.framework.model.CustomerMiniProgramFansVO;
import com.rtmap.middle.framework.model.enumeration.CustomerType;


import java.io.Serializable;


/**
 * Description:
 *
 * @author jinjianjun
 * @date 2018/6/19
 */
public class CustomerDetailVO extends BaseVO implements Serializable {

    private String cid;

    private Integer cType;

    private String registerTime;

    private String customerTypeName;

    private String externalId;

    private MemberVO member;

    private CustomerAlipayVO alipay;

    private CustomerFansVO fans;

    private CustomerBankPayerVO bankPayer;

    private ApperceiveIdfaVO idfa;

    private ApperceiveImeiVO imei;

    private ApperceiveMacVO mac;

    private CustomerMiniProgramFansVO miniFans;

    private FansPayerVO fansPayer;

    private AlipayPayerVO alipayPayer;

    public CustomerDetailVO() {
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public CustomerDetailVO(CustomerVO customer) {

        this.setTenantId(customer.getTenantId());
        this.setTenantType(customer.getTenantType());
        this.registerTime = customer.getRegisterTime();
        this.cType = customer.getcType();
        this.cid = customer.getCid();
        setCustomer(customer, customer.getcType());
    }

    public void setCustomer(CustomerVO customer, int cType) {

        switch (cType) {

            case CustomerType.MEMBER:
                this.member = (MemberVO) customer;
                break;
            case CustomerType.ALIPAY:
                this.alipay = (CustomerAlipayVO) customer;
                break;
            case CustomerType.FANS:
                this.fans = (CustomerFansVO) customer;
                break;
            case CustomerType.BANK:
                this.bankPayer = (CustomerBankPayerVO) customer;
                break;
            case CustomerType.MAC:
                this.mac = (ApperceiveMacVO) customer;
                break;
            case CustomerType.IDFA:
                this.idfa = (ApperceiveIdfaVO) customer;
                break;
            case CustomerType.IMEI:
                this.imei = (ApperceiveImeiVO) customer;
                break;
            case CustomerType.MINI_PROGRAM_FANS:
                this.miniFans = (CustomerMiniProgramFansVO)customer;
                break;
            case CustomerType.FANS_PAYMENT:
                this.fansPayer = (FansPayerVO)customer;
                break;
            case CustomerType.ALIPAY_PAYMENT:
                this.alipayPayer = (AlipayPayerVO) customer;
                break;

        }

    }

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

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public CustomerAlipayVO getAlipay() {
        return alipay;
    }

    public void setAlipay(CustomerAlipayVO alipay) {
        this.alipay = alipay;
    }

    public CustomerFansVO getFans() {
        return fans;
    }

    public void setFans(CustomerFansVO fans) {
        this.fans = fans;
    }

    public CustomerBankPayerVO getBankPayer() {
        return bankPayer;
    }

    public void setBankPayer(CustomerBankPayerVO bankPayer) {
        this.bankPayer = bankPayer;
    }

    public ApperceiveIdfaVO getIdfa() {
        return idfa;
    }

    public void setIdfa(ApperceiveIdfaVO idfa) {
        this.idfa = idfa;
    }

    public ApperceiveImeiVO getImei() {
        return imei;
    }

    public void setImei(ApperceiveImeiVO imei) {
        this.imei = imei;
    }

    public ApperceiveMacVO getMac() {
        return mac;
    }

    public void setMac(ApperceiveMacVO mac) {
        this.mac = mac;
    }

    public CustomerMiniProgramFansVO getMiniFans() {
        return miniFans;
    }

    public void setMiniFans(CustomerMiniProgramFansVO miniFans) {
        this.miniFans = miniFans;
    }

    public FansPayerVO getFansPayer() {
        return fansPayer;
    }

    public void setFansPayer(FansPayerVO fansPayer) {
        this.fansPayer = fansPayer;
    }

    public AlipayPayerVO getAlipayPayer() {
        return alipayPayer;
    }

    public void setAlipayPayer(AlipayPayerVO alipayPayer) {
        this.alipayPayer = alipayPayer;
    }
}

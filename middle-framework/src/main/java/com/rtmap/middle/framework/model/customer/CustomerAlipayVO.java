package com.rtmap.middle.framework.model.customer;

import com.rtmap.middle.framework.model.CustomerVO;
import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerAlipayVO extends CustomerVO implements Serializable {
    private Long id;

    private String name;

    private String icon;

    private String sex;
    @NotNull(message = "支付宝账号标识不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class, DGeneralUpdateValidate.class})
    @NotBlank(message = "支付宝账号标识不能为空", groups = {GeneralCreateValidate.class,GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String alipayid;

    private String province;

    private String city;

    private String type;

    private Integer isStudent;

    private Integer validated;

    private Boolean del;

    private String ext1;

    private String ext2;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAlipayid() {
        return alipayid;
    }

    public void setAlipayid(String alipayid) {
        this.alipayid = alipayid == null ? null : alipayid.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Integer isStudent) {
        this.isStudent = isStudent;
    }

    public Integer getValidated() {
        return validated;
    }

    public void setValidated(Integer validated) {
        this.validated = validated;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    @Override
    public String toString() {
        return "CustomerAlipayVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", sex='" + sex + '\'' +
                ", alipayid='" + alipayid + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", isStudent=" + isStudent +
                ", validated=" + validated +
                ", del=" + del +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                '}';
    }
}
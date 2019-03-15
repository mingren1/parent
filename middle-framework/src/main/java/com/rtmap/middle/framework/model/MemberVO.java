package com.rtmap.middle.framework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rtmap.middle.framework.common.enums.*;
import com.rtmap.middle.framework.model.validate.*;
import com.rtmap.middle.framework.utils.DateUtil;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.joda.time.Years;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class MemberVO extends CustomerVO {


    private Long id;
    //累计积分
    private int total;
    //可用积分
    private int balance;
    //累计成长值
    private Integer growthTotal;
    //可用成长值
    private Integer growth;
    //@NotNull(message = "用户姓名不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String name;

    private Integer idType;

    private String idcard;

    private Integer validated;

    private Integer mobileValidated;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String birthday;
    @NotNull(message = "手机号不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class,DDataSyncValidate.class})
    @NotBlank(message = "手机号不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class,DDataSyncValidate.class})
    @Size(max = 18,message = "手机号不能超过18位",groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class,DDataSyncValidate.class})
    private String mobile;

    private String telephone;

    private Integer status;

    private String openid;

    private String appid;

    private String unionid;

    private String icon;

    private String sex;

    private Long cardId;

    private String cardNo;

    private String cardName;
    @NotNull(message = "会员卡等级不能为空", groups = {DDataSyncValidate.class})
    private String cardGrade;

    private String grade;

    private String email;

    /*************居住地信息***************/
    private Long provinceId;
    private String provinceName;
    private Long cityId;
    private String cityName;
    private Long areaId;
    private String areaName;
    private String address;
    private Long regionId;
    /*************居住地信息***************/

    /*************籍贯地信息***************/
    private Long nativeProvinceId;
    private String nativeProvinceName;
    private Long nativeCityId;
    private String nativeCityName;
    private Long nativeAreaId;
    private String nativeAreaName;
    private String nativeAddress;
    private Long nativeRegionId;
    /*************籍贯地信息***************/

    private String comment;

    private Integer education;

    private String password;

    private String idphoto;

    private String nation;

    private String zodiac;

    private String profession;

    private Integer sourceType;

    private String alipayid;

    private String bankCard;

    private String mac;

    private String idfa;

    private String imei;

    private Date expireTime;

    private String username;

    private String nickname;

    private String mobileCountryCode;

    private Long countryId;

    private String countryName;

    private String countryNameEn;

    private Boolean del;

    private String ext1;

    private String ext2;

    private String registerSourceId;

    private String registerSource;

    private Integer isDigitalMember;

    private Integer newMember;

    private Integer registerType;

    private Integer keepDays;

    private static final long serialVersionUID = 1L;
    /*=================此处属性字段为 具体码值 对应的 名称==BEGIN==============*/
    private String idTypeVo;
    private String sexVo;
    private String educationVo;
    private String birthdayVo;
    private String cardVO;
    private String statusVo;
    private String validatedVo;
    private String sourceTypeVo;
    private Integer age;

    /*************升级、降级卡id，升级级标示,升降级成长值标准***************/
    public Integer getMobileValidated() {
        return mobileValidated;
    }

    public void setMobileValidated(Integer mobileValidated) {
        this.mobileValidated = mobileValidated;
    }
    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    private Long upDownCardId;

    private int type;

    private int upDownGrawth;

    private String upDownCardName;

    public Integer getKeepDays() {
        return keepDays;
    }

    public void setKeepDays(Integer keepDays) {
        this.keepDays = keepDays;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getCardGrade() {
        return cardGrade;
    }

    public void setCardGrade(String cardGrade) {
        this.cardGrade = cardGrade;
    }

    public Integer getIsDigitalMember() {
        return isDigitalMember;
    }

    public void setIsDigitalMember(Integer isDigitalMember) {
        this.isDigitalMember = isDigitalMember;
    }

    public Integer getNewMember() {
        return newMember;
    }

    public void setNewMember(Integer newMember) {
        this.newMember = newMember;
    }

    public String getIdTypeVo() {
        return idTypeVo = IdType.nameOf(this.idType);
    }

    public void setIdTypeVo(String idTypeVo) {
        this.idTypeVo = idTypeVo;
    }

    public String getSexVo() {
        return sexVo = Sex.nameOf(this.sex);
    }

    public void setSexVo(String sexVo) {
        this.sexVo = sexVo;
    }

    public String getEducationVo() {
        return educationVo = Education.nameOf(this.education);
    }

    public void setEducationVo(String educationVo) {
        this.educationVo = educationVo;
    }

    public String getBirthdayVo() {
        if (this.birthday == null) {
            this.birthdayVo = DateUtil.getCurrentDate();
        } else {
            try {
//                this.birthdayVo = DateUtil.formatDate(this.birthday, "yyyy-MM-dd");
                this.birthdayVo = this.birthday;
            } catch (Exception ex) {
            }
        }
        return birthdayVo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }

    public String getRegisterSourceId() {
        return registerSourceId;
    }

    public void setRegisterSourceId(String registerSourceId) {
        this.registerSourceId = registerSourceId;
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    public void setBirthdayVo(String birthdayVo) {
        this.birthdayVo = birthdayVo;
    }

    public String getCardVO() {
        //TODO xupeng 卡等级名称待处理（需引入缓存)
        return cardVO;
    }

    public void setCardVO(String cardVO) {
        this.cardVO = cardVO;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getStatusVo() {
        return statusVo = Status.nameOf(this.status);
    }

    public void setStatusVo(String statusVo) {
        this.statusVo = statusVo;
    }

    public String getValidatedVo() {
        return validatedVo = Validated.nameOf(this.validated);
    }

    public void setValidatedVo(String validatedVo) {
        this.validatedVo = validatedVo;
    }

    public String getSourceTypeVo() {
        return sourceTypeVo = SourceType.nameOf(this.sourceType);
    }

    public void setSourceTypeVo(String sourceTypeVo) {
        this.sourceTypeVo = sourceTypeVo;
    }

    public Integer getAge() {

        if (birthday != null) {
            DateTime regTime = new DateTime(this.birthday);
            DateTime currentTime = new DateTime(System.currentTimeMillis());
            Years years = Years.yearsBetween(regTime, currentTime);
            age = years.getYears();
            return age;
        } else {
            return age = 0;
        }
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void calculateVO() {
        getIdTypeVo();
        getEducationVo();
        getStatusVo();
        getSexVo();
        getSourceTypeVo();
        getValidatedVo();
        getBirthdayVo();
        getAge();
    }
    /*=================此处属性字段为 具体码值 对应的 名称==END==============*/

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getGrowthTotal() {
        return growthTotal;
    }

    public void setGrowthTotal(Integer growthTotal) {
        this.growthTotal = growthTotal;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

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

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getValidated() {
        return validated;
    }

    public void setValidated(Integer validated) {
        this.validated = validated;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
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

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getIdphoto() {
        return idphoto;
    }

    public void setIdphoto(String idphoto) {
        this.idphoto = idphoto == null ? null : idphoto.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac == null ? null : zodiac.trim();
    }

    public String getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(String nativeAddress) {
        this.nativeAddress = nativeAddress == null ? null : nativeAddress.trim();
    }

    public Long getNativeRegionId() {
        return nativeRegionId;
    }

    public void setNativeRegionId(Long nativeRegionId) {
        this.nativeRegionId = nativeRegionId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getAlipayid() {
        return alipayid;
    }

    public void setAlipayid(String alipayid) {
        this.alipayid = alipayid == null ? null : alipayid.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa == null ? null : idfa.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode == null ? null : mobileCountryCode.trim();
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getNativeProvinceId() {
        return nativeProvinceId;
    }

    public void setNativeProvinceId(Long nativeProvinceId) {
        this.nativeProvinceId = nativeProvinceId;
    }

    public String getNativeProvinceName() {
        return nativeProvinceName;
    }

    public void setNativeProvinceName(String nativeProvinceName) {
        this.nativeProvinceName = nativeProvinceName;
    }

    public Long getNativeCityId() {
        return nativeCityId;
    }

    public void setNativeCityId(Long nativeCityId) {
        this.nativeCityId = nativeCityId;
    }

    public String getNativeCityName() {
        return nativeCityName;
    }

    public void setNativeCityName(String nativeCityName) {
        this.nativeCityName = nativeCityName;
    }

    public Long getNativeAreaId() {
        return nativeAreaId;
    }

    public void setNativeAreaId(Long nativeAreaId) {
        this.nativeAreaId = nativeAreaId;
    }

    public String getNativeAreaName() {
        return nativeAreaName;
    }

    public void setNativeAreaName(String nativeAreaName) {
        this.nativeAreaName = nativeAreaName;
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

    public Long getUpDownCardId() {
        return upDownCardId;
    }

    public void setUpDownCardId(Long upDownCardId) {
        this.upDownCardId = upDownCardId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUpDownGrawth() {
        return upDownGrawth;
    }

    public void setUpDownGrawth(int upDownGrawth) {
        this.upDownGrawth = upDownGrawth;
    }

    public String getUpDownCardName() {
        return upDownCardName;
    }

    public void setUpDownCardName(String upDownCardName) {
        this.upDownCardName = upDownCardName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idType=" + idType +
                ", idcard='" + idcard + '\'' +
                ", validated=" + validated +
                ", birthday=" + birthday +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", status=" + status +
                ", openid='" + openid + '\'' +
                ", icon='" + icon + '\'' +
                ", sex='" + sex + '\'' +
                ", cardId=" + cardId +
                ", cardNo='" + cardNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                ", education=" + education +
                ", password='" + password + '\'' +
                ", regionId=" + regionId +
                ", idphoto='" + idphoto + '\'' +
                ", nation='" + nation + '\'' +
                ", zodiac='" + zodiac + '\'' +
                ", nativeAddress='" + nativeAddress + '\'' +
                ", nativeRegionId=" + nativeRegionId +
                ", profession='" + profession + '\'' +
                ", sourceType=" + sourceType +
                ", alipayid='" + alipayid + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", mac='" + mac + '\'' +
                ", idfa='" + idfa + '\'' +
                ", imei='" + imei + '\'' +
                ", expireTime=" + expireTime +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mobileCountryCode='" + mobileCountryCode + '\'' +
                ", countryId=" + countryId +
                ", del=" + del +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                '}';
    }
}
package com.rtmap.middle.framework.model;

import com.rtmap.middle.framework.model.validate.DGeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.DGeneralUpdateValidate;
import com.rtmap.middle.framework.model.validate.GeneralCreateValidate;
import com.rtmap.middle.framework.model.validate.GeneralUpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerFansVO extends CustomerVO implements Serializable{

    @NotNull(message = "微信公众号微信标识不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    @NotBlank(message = "微信公众号微信标识不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String openid;
    @NotNull(message = "appid不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    @NotBlank(message = "appid不能为空", groups = {GeneralCreateValidate.class, GeneralUpdateValidate.class, DGeneralCreateValidate.class,DGeneralUpdateValidate.class})
    private String appid;
    private String unionid;
    private String icon;
    private String nickname;
    private String city;
    private String country;
    private String province;
    private String language;
    private String subscribeTime;
    private String comment;
    //关注渠道来源
    private String subscribeScene;
    //二维码扫码场景
    private String qrScene;
    //二维码扫码场景描述
    private String qrSceneStr;

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    public String getQrScene() {
        return qrScene;
    }

    public void setQrScene(String qrScene) {
        this.qrScene = qrScene;
    }

    public String getQrSceneStr() {
        return qrSceneStr;
    }

    public void setQrSceneStr(String qrSceneStr) {
        this.qrSceneStr = qrSceneStr;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(String subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

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

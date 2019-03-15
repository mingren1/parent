package com.rtmap.middle.framework.model.enumeration;

import java.util.HashMap;

public enum BizType {
    // 1:消费+  2:补录+ 3:调整+- 4:抵现- 5:礼品兑换- 6:礼品退还+ 7:参加活动- 8:退货- 9:退抵现+ 10:过期- 11:签到+ 12:注册+ 13:分享+ 14:完善个人信息+ 15:实名认证+
    Trade(1, "消费"),
    TradeAdditional(2, "补录"),
    Adjust(3, "调整"),
    ExchangeToCash(4, "抵现"),
    ExchangeToGift(5, "礼品兑换"),
    DeExchangeToGift(6, "礼品退还"),
    ExchangeToActivity(7, "参加活动"),
    DeTrade(8, "退货"),
    DeExchangeToCash(9, "退抵现"),
    Expire(10, "过期"),
    SignIn(11, "签到"),
    Register(12, "注册"),
    Share(13,"分享"),
    ImprovePersonalInfo(14,"完善个人信息"),
    Certification(15,"实名认证");

    private static HashMap<Integer, BizType> map = new HashMap<>();

    BizType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        for (BizType inst : BizType.values()) {
            map.put(inst.code, inst);
        }
    }

    private int code;
    private String name;

    public static String nameOf(Integer code) {
        return map.get(code) == null ? null : map.get(code).name;
    }

    public Integer valueOf() {
        return this.code;
    }

    public static BizType get(Integer code) {
        return map.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

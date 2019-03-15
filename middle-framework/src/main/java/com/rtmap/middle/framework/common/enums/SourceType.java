package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;

public enum SourceType {
    Alipay(1, "支付宝"), Weixin(2, "微信"), Meituan(3, "美团"), Others(4, "其他"), Bank(5, "银行");

    SourceType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static HashMap<Integer, SourceType> map = new HashMap<>();

    static {
        for (SourceType inst : SourceType.values()) {
            map.put(inst.code, inst);
        }
    }

    public static String nameOf(Integer code) {
        return map.get(code) == null ? null : map.get(code).name;
    }

    private int code;
    private String name;
}
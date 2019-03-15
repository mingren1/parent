package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;

public enum Validated {
    Unauthenticated(0, "未认证"), Authenticated(1, "实名认证");

    Validated(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static HashMap<Integer, Validated> map = new HashMap<>();

    static {
        for (Validated inst : Validated.values()) {
            map.put(inst.code, inst);
        }
    }

    public static String nameOf(Integer code) {
        return map.get(code) == null ? null : map.get(code).name;
    }

    private int code;
    private String name;
}
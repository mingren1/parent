package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;

public enum Education {
    Primary(1, "小学"), Junior(2, "初中"), Senior(3, "高中"), JuniorCollege(4, "大专"), Undergraduate(5, "本科"),
    Master(6, "硕士"), Doctor(7, "博士");

    Education(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static HashMap<Integer, Education> map = new HashMap<>();

    static {
        for (Education inst : Education.values()) {
            map.put(inst.code, inst);
        }
    }

    public static String nameOf(Integer code) {
        return map.get(code) == null ? null : map.get(code).name;
    }

    private int code;
    private String name;
}
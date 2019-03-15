package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;

public enum Sex {
    Male("M", "男"), Female("F", "女");

    Sex(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private static HashMap<String, Sex> map = new HashMap<>();

    static {
        for (Sex inst : Sex.values()) {
            map.put(inst.code, inst);
        }
    }

    public static String nameOf(String code) {
        return map.get(code) == null ? null : map.get(code).name;
    }

    private String code;
    private String name;
}
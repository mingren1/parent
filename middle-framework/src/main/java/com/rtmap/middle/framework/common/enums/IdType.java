package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;

public enum IdType {
    PID(1, "身份证"), AID(2, "军官证"), EID(3, "护照");

    private static HashMap<Integer, IdType> map = new HashMap<>();

    IdType(int idtype, String name) {
        this.code = idtype;
        this.name = name;
    }

    static {
        for (IdType inst : IdType.values()) {
            map.put(inst.code, inst);
        }
    }

    private int code;
    private String name;

    public static String nameOf(Integer code) {
        return map.get(code) == null ? null : map.get(code).name;
    }
}
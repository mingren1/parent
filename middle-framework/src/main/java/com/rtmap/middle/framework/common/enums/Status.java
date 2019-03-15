package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;

// 0:正常 1:挂失 2:冻结 3:黑名单 4:注销 5:过期
public enum Status {
        Normal(0, "正常"), Lossed(1, "挂失"), Blocked(2, "冻结"), Blacked(3, "黑名单")
        , Cancel(4, "注销"), Expired(5, "过期"),POSTPONE(6,"延期");

        Status(int code, String name) {
            this.code = code;
            this.name = name;
        }

        private static HashMap<Integer, Status> map = new HashMap<>();

        static {
            for (Status inst : Status.values()) {
                map.put(inst.code, inst);
            }
        }

        public static String nameOf(Integer code) {
            return map.get(code) == null ? null : map.get(code).name;
        }

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
package com.rtmap.middle.framework.utils;

import org.apache.commons.lang3.StringUtils;

public class RtmapUtils {

    /**
     * like支持 % _ \ 查询
     */
    public static String getSafeLikeValue(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        name = name.replaceAll("\\\\", "\\\\\\\\");
        name = name.replaceAll("%", "\\\\%");
        name = name.replaceAll("_", "\\\\_");
        return "%" + name.trim() + "%";
    }
}

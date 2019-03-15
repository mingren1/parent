/*
 * RT MAP, Home of Professional MAP
 * Copyright  Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 活动类型
 * @author chengshuxin@rtmap.com
 * @project CouponMALL
 * @package com.rtmap.micro.services.couponmall.common.constants.enums
 * @date 2018/9/6
 */
public enum ActivityTypeEnum {
    /**0.长期活动，1.短期活动*/
    LONG(0, "长期活动"),
    SHORT(1, "短期活动");

    private int value;
    private String text;

    private static Map<Integer, ActivityTypeEnum> values = new HashMap<>();

    static {
        for (ActivityTypeEnum v : ActivityTypeEnum.values()) {
            values.put(v.getValue(), v);
        }
    }

    ActivityTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static ActivityTypeEnum getEnum(Integer type) {
        ActivityTypeEnum operateEnum = values.get(type);
        if (operateEnum == null) {
            throw new RuntimeException("查无匹配的操作码(operateAction)");
        }
        return operateEnum;
    }
}

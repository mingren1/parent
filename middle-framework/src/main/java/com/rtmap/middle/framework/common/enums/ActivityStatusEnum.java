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
 * @author chengshuxin@rtmap.com
 * @Description 活动类型
 * @project CouponMALL
 * @package com.rtmap.micro.services.couponmall.common.constants.enums
 * @date 2018/9/6
 */
public enum ActivityStatusEnum {
    /**
     * 0待配置，1进行中，2暂停，3已结束 4.待启动
     */
    CONFIGURING(0, "待配置"),
    RUNNING(1, "进行中"),
    PAUSED(2, "暂停"),
    FINISHED(3, "已结束"),
    WAITING(4, "待启动");

    private int value;
    private String text;

    private static Map<Integer, ActivityStatusEnum> values = new HashMap<>();

    static {
        for (ActivityStatusEnum v : ActivityStatusEnum.values()) {
            values.put(v.getValue(), v);
        }
    }

    ActivityStatusEnum(int value, String text) {
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

    public static ActivityStatusEnum getEnum(Integer type) {
        ActivityStatusEnum operateEnum = values.get(type);
        if (operateEnum == null) {
            throw new RuntimeException("查无匹配的操作码(operateAction)");
        }
        return operateEnum;
    }
}

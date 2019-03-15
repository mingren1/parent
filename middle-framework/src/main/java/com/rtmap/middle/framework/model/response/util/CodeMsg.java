/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.util;


/**
 * @author maoyun@rtmap.com
 * @project parent
 * @package com.rtmap.coupon.response
 * @date 3/13/17
 */
public class CodeMsg extends CommonCodeMsg {

    // 渠道配置相关
    public final static int ILLEGAL_ACTID = 82101;
    public final static int ILLEGAL_REQID = 82102;
    public final static int GOING_REQ_NOT_ALLOW_UPDATE = 82103;
    public final static int REQ_STATUS_OPERATE_FAIL = 82104;
    public final static int UNSUPPORTED_OPERATE_CODE = 82105;
    public final static int ILLEGAL_CHANNEL_ID = 82106;
    public final static int CANNOT_REPEAT_ADD_REQ = 82107;

    // 投放相关
    public final static int DELIVERY_FAIL = 82301;
    public final static int REQ_PUSH_OVER_LIMIT = 82302;
    public final static int SCRM_MOBILE_NONEXIST = 82303;
    public final static int REQ_STATUS_NOT_NORMAL = 82304;
    public final static int SCRM_OPENID_NONEXIST = 82305;

    // 系统对接失败
    public final static int REQUEST_SCRM_FAIL = 82401;
    public final static int REQUEST_AUTH_FAIL = 82402;
    public final static int REQUEST_APPMARKETING_FAIL = 82403;
    public final static int REQUEST_PLATFORM_FAIL = 82404;
    public final static int STATUS_ACTIVITY_COUPON_NOT_EXIT = 82405;
    public final static int ACTIVITY_NOT_EXIT = 82406;
    public final static int REACH_COUPON_ACTIVITY_DAY_MAX = 82407;
    public final static int REACH_COUPON_ACTIVITY_ALL_MAX = 82408;
    public final static int COUPON_QUANTITY_NOT_ENOUGH = 82409;
    public final static int ACT_INVALID = 82410;
    public final static int ACT_NOT_OPEN = 82411;
    public final static int REACH_DAY_MAX = 82412;
    public final static int REACH_ALL_MAX = 82413;
    public final static int ACT_ALL_DAY_MAX = 82414;
    public final static int REACH_COUPON_ACTIVITY_ALL_DAY_ISSUE = 82415;
    public final static int SCRM_CUSTOMER_ERROR = 82416;


    /**
     * 服务调用失败
     */
    public final static int UNKNOWN_SERVICE = 82417;

    static {
        // 活动错误码
        MSG.put(ILLEGAL_ACTID, "非法的活动ID");
        MSG.put(ILLEGAL_REQID, "非法的渠道申请单编号");
        MSG.put(GOING_REQ_NOT_ALLOW_UPDATE, "投放中的申请单不允许更新操作");
        MSG.put(REQ_STATUS_OPERATE_FAIL, "更新渠道申请单状态失败");
        MSG.put(UNSUPPORTED_OPERATE_CODE, "不支持的状态操作码");
        MSG.put(ILLEGAL_CHANNEL_ID, "非法的渠道ID");
        MSG.put(CANNOT_REPEAT_ADD_REQ, "该活动已有渠道申请单, 请勿重复添加");

        MSG.put(DELIVERY_FAIL, "投放失败");
        MSG.put(REQ_PUSH_OVER_LIMIT, "该申请单投放次数超过预算限制，投放失败");

        MSG.put(SCRM_MOBILE_NONEXIST, "Scrm会员手机号不存在，投放失败");
        MSG.put(REQ_STATUS_NOT_NORMAL, "渠道申请单状态不在投放中，投放失败");
        MSG.put(SCRM_OPENID_NONEXIST, "Scrm会员微信OpenId不存在，投放失败");

        MSG.put(REQUEST_SCRM_FAIL, "对接SCRM系统失败");
        MSG.put(REQUEST_AUTH_FAIL, "对接权限系统失败");
        MSG.put(REQUEST_APPMARKETING_FAIL, "对接应用市场失败");
        MSG.put(REQUEST_PLATFORM_FAIL, "对接MA三方平台失败");
        MSG.put(STATUS_ACTIVITY_COUPON_NOT_EXIT, "当前券批不存在");
        MSG.put(ACTIVITY_NOT_EXIT, "当前活动不存在");
        MSG.put(REACH_COUPON_ACTIVITY_DAY_MAX, "达到此券批每人每天领取次数限制");
        MSG.put(REACH_COUPON_ACTIVITY_ALL_MAX, "达到此券批每人累计领取次数限制");
        MSG.put(COUPON_QUANTITY_NOT_ENOUGH, "当前活动下券库存不足");
        MSG.put(ACT_INVALID, "无效的活动");
        MSG.put(ACT_NOT_OPEN, "当前活动暂未开始或已经结束");
        MSG.put(REACH_DAY_MAX, "达到活动每人每天领取次数限制");
        MSG.put(REACH_ALL_MAX, "达到活动每人累计领取次数限制");
        MSG.put(ACT_ALL_DAY_MAX, "达到活动全天累计发放量限制");
        MSG.put(SCRM_CUSTOMER_ERROR, "查询会员异常");
        MSG.put(UNKNOWN_SERVICE, "调用API服务失败");
    }

    public static String getMsg(int errcode) {
        return MSG.get(errcode);
    }

}

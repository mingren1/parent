package com.rtmap.middle.framework.model.response.util;

import java.util.HashMap;
import java.util.Map;

/**
 * CommonCodeMsg    公共返回码Code基类
 *
 * @author Muarine<maoyun@rtmap.com>
 * @date 2017 2/20/17 16:23
 * @since 2.0.0
 */
public class CommonCodeMsg{
    /**
     * 请求成功
     */
    public static final int SUCCESS         = 200;
    /**
     * 服务器异常
     */
    public static final int ERROR           = 500;
    /**
     * 接口版本号不存在
     */
    public static final int INVALID_VERSION = 82000;
    /**
     * 请求的资源找不到
     */
    public static final int NOT_FOUND       = 82001;
    /**
     * 非法的签名
     */
    public static final int INVALID_SIGN    = 82002;
    /**
     * 非法的token
     */
    public static final int INVALID_TOKEN   = 82003;
    /**
     * 参数不能为空
     */
    public static final int NULL_PARAM      = 82004;
    /**
     * 非法的参数
     */
    public static final int INVALID_PARAM   = 82005;
    /**
     * 重复数据
     */
    public static final int EXITING         = 82006;
    /**
     * 暂无匹配数据
     */
    public static final int NO_MATCHING     = 82007;
    /**
     * 非法的文件类型
     */
    public static final int INVALID_FILE    = 82008;
    /**
     * 无效的用户
     */
    public static final int INVALID_USER    = 82009;
    /**
     * 操作失败
     */
    public static final int OPERATE_FAIL    = 82010;
    /**
     * 不能操作
     */
    public static final int OPERATE_ILLEGAL = 82011;
    /**
     * 文件过大
     */
    public static final int FILE_SIZE_ERROR = 82012;
    /**
     * 文件不存在
     */
    public static final int NULL_FILE       = 82013;
    /**
     * 非法的网络地址
     */
    public static final int UNKNOWN_HOST    = 82014;


    protected static final Map<Integer, String> MSG = new HashMap<Integer, String>();

    static {
        // 系统常用
        MSG.put(SUCCESS, "请求成功.");
        MSG.put(ERROR, "服务器异常.");

        // 账户相关
        MSG.put(INVALID_VERSION, "接口版本号不存在.");
        MSG.put(NOT_FOUND, "请求资源未找到.");
        MSG.put(INVALID_SIGN, "签名非法.");
        MSG.put(INVALID_TOKEN, "token失效,请重新登录.");
        MSG.put(NULL_PARAM, "请求参数不能为空.");
        MSG.put(INVALID_PARAM, "非法的请求参数.");
        MSG.put(EXITING, "重复的数据请求.");

        MSG.put(NO_MATCHING, "暂无匹配数据.");
        MSG.put(INVALID_FILE, "非法的文件类型.");
        MSG.put(INVALID_USER, "非法的用户.");
        MSG.put(OPERATE_FAIL, "操作失败.");
        MSG.put(OPERATE_ILLEGAL, "非法操作.");

        MSG.put(FILE_SIZE_ERROR, "上传文件过大.");
        MSG.put(NULL_FILE, "文件不存在.");

        // 系统通用
        MSG.put(UNKNOWN_HOST, "非法的网络地址");

    }


    public static String getMsg(int errCode) {
        return MSG.get(errCode);
    }

}

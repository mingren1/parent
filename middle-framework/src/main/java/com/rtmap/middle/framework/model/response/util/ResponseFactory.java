/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.model.response.util;

import com.rtmap.middle.framework.model.Result;

/**
 * 单例初始化响应工具类
 *
 * 使用方法: 详见method
 *
 * @author maoyun@rtmap.com
 * @project rtmap-scenes
 * @package com.rtmap.scenes.web.util
 * @date 3/16/17
 */
public class ResponseFactory {

    /**
     * 公共私有静态函数
     * @param code
     * @return
     */
    private static Result commonBuild(int code , String errmsg) {
        Result result = new Result();
        result.setStatus(code);
        if(errmsg == null || errmsg.trim().length() == 0){
            result.setMessage(CodeMsg.getMsg(code));
        }else{
            result.setMessage(errmsg);
        }
        return result;
    }

    /**
     * 指定响应码-需预先在 @ CodeMsg 里定义响应码
     * <pre>
     *     {
     *         "status":{code}
     *         "message":{message}
     *     }
     * </pre>
     * @param code
     * @see CodeMsg
     * @return
     */
    public static Result build(int code){
        Result json = commonBuild(code , CodeMsg.getMsg(code));
        return json;
    }

    /**
     * 成功响应
     * <p>
     * <pre>
     * {
     *     "status":0,
     *     "message":"success."
     * }
     * </pre>
     * @return
     */
    public static Result build(){
        Result json = commonBuild(CodeMsg.SUCCESS , null);
        return json;
    }

    /**
     * 成功响应
     * <pre>
     *     {
     *         "status":{code}
     *         "message":{message}
     *     }
     * </pre>
     * @param data      需要返回的数据对象
     * @see CodeMsg
     * @return
     */
    public static Result build(Object data){
        Result json = commonBuild(CodeMsg.SUCCESS , null);
        json.setData(data);
        return json;
    }

    /**
     * 自定义返回码code，构建返回数据
     * @param code
     * @return
     */
    public static Result build(int code , Object data){
        Result result = commonBuild(code , null);
        result.setData(data);
        return result;
    }
    /**
     * 自定义返回码code，构建返回数据
     * @param code
     * @return
     */
    public static Result build(int code , String msg){
        Result result = commonBuild(code , msg);
        result.setData(null);
        return result;
    }

    public static Result buildMessage(int code, String msg){
        return commonBuild(code, msg);
    }

    /**
     * 自定义返回码code，构建返回数据
     * @param code
     * @return
     */
    public static Result build(int code , String msg , Object data){
        Result result = commonBuild(code , msg);
        result.setData(data);
        return result;
    }
}

package com.rtmap.middle.framework.model;

import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.consts.CodeMsg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Result.  公共响应包装
 *
 * @author
 */
@Setter
@Getter
@ToString
public class Result<T> {

    private int status;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return success(null, null);
    }

    public static <T> Result<T> success(T data) {
        return success(data, "成功");
    }

    public static <T> Result<T> success(T data, String msg) {
        Result<T> result = new Result<T>();
        result.setStatus(CodeMsg.SUCCESS);
        if (msg != null) {
            result.setMessage(CodeMsg.getMsg(CodeMsg.SUCCESS));
        } else {
            result.setMessage(msg);
        }
        result.setData(data);
        return result;
    }

    /**
     * 断言count大于0，成功否则失败
     * @param count
     * @return
     */
    public static Result countAssert(int count) {
        return countAssert(count, "操作成功", "操作失败");
    }

    public static Result countAssert(int count, String errMsg) {
        return countAssert(count, "操作成功", errMsg);
    }

    public static Result countAssert(int count, String okMsg, String errMsg) {
        Result result = new Result();
        result.setStatus(count > 0 ? CodeMsg.SUCCESS : CodeMsg.ALERT_MSG);
        result.setMessage(count > 0 ? okMsg : errMsg);
        result.setData(count);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.setStatus(CodeMsg.ALERT_MSG);
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> error(int code) {
        return error(code, CodeMsg.getMsg(code));
    }

    public static <T> Result<T> error(int code, String errMsg) {
        Result<T> result = new Result<T>();
        result.setStatus(code);
        result.setMessage(errMsg);
        return result;
    }

    public static <T> Result<PageList<T>> pageList(List<T> list) {
        return success(new PageList<T>(list));
    }
}

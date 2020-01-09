package com.yisu.gateways.gateway.result;


import lombok.Data;

import java.io.Serializable;

/**
 * @description 统一返回
 * @author xuyisu
 * @date 2019/9/20
 */
@Data
public class FwResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final int SUCCESS=200;

    private static String MSG_SUCCESS="操作成功";

    private static int FAIL=500;

    private static String MSG_FAIL="操作失败";

    private int code;

    private String msg;

    private T data;

    //分页信息
    private Object meta;

    public static <T> FwResult<T> ok() {
        return restResult(null, SUCCESS, MSG_SUCCESS, null);
    }
    public static <T> FwResult<T> okMsg(String msg) {
        return restResult(null, SUCCESS, msg, null);
    }
    public static <T> FwResult<T> ok(T data) {
        return restResult(data, SUCCESS, MSG_SUCCESS, null);
    }

    public static <T> FwResult<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg, null);
    }
    public static <T> FwResult<T> okMeta(T data) {
        return restResult(data, SUCCESS, null, data);
    }
    public static <T> FwResult<T> ok(T data, String msg, Object meta) {
        return restResult(data, SUCCESS, msg, meta);
    }

    public static <T> FwResult<T> failed() {
        return restResult(null, FAIL, MSG_FAIL, null);
    }

    public static <T> FwResult<T> failedMsg(String msg) {
        return restResult(null, FAIL, msg, null);
    }

    public static <T> FwResult<T> failed(T data) {
        return restResult(data, FAIL, MSG_FAIL, null);
    }

    public static <T> FwResult<T> failed(T data, String msg) {
        return restResult(data, FAIL, msg, null);
    }

    private static <T> FwResult<T> restResult(T data, int code, String msg, Object meta) {
        FwResult fwcloudResult = new FwResult();
        fwcloudResult.setCode(code);
        fwcloudResult.setData(data);
        fwcloudResult.setMsg(msg);
        fwcloudResult.setMeta(meta);
        return fwcloudResult;
    }




}

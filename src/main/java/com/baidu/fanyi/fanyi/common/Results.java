package com.baidu.fanyi.fanyi.common;

public final class Results<T> {
    private Integer code=0;
    private String errorCode="成功";
    private String msg="成功";
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Results() {
    }

    public Results(T data) {
        this.data = data;
    }

    public Results(Integer code, String errorCode, String msg, T data) {
        this.code = code;
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }
}

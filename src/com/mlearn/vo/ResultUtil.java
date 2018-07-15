package com.mlearn.vo;

public class ResultUtil {

    private Integer code;

    private Object msg;

    public ResultUtil() {
    }

    public ResultUtil(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultUtil{" +
                "code1=" + code +
                ", msg=" + msg +
                '}';
    }
}

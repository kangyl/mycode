package com.kangyl.springboot.web.common;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/30
 */
public class CommonResponse {

    private int code;

    private String msg;

    public CommonResponse() {
    }

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonResponse success() {
        return new CommonResponse(0, "success");
    }

    public static CommonResponse failure() {
        return new CommonResponse(1, "系统内部异常");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

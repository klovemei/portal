package com.jyanedu.app.module;

/**
 * Created by liu_kai on 2018/2/2.
 */
public class BaseResp {
    private int code = 0;
    private String msg;

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

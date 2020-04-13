package com.jamel.adminpage.dto;

import lombok.Data;

public class Resp<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private T data;

    public static <T> Resp success(Integer count,T data){
        Resp<T> resp = new Resp<>();
        resp.setCode(0);
        resp.setMsg("");
        resp.setCount(count);
        resp.setData(data);
        return resp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

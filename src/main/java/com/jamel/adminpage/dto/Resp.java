package com.jamel.adminpage.dto;

import lombok.Data;

@Data
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
}

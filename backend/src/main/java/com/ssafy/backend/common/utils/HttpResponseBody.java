package com.ssafy.backend.common.utils;

public class HttpResponseBody<T> {
    private T data;
    private String msg;

    public HttpResponseBody() {}

    public HttpResponseBody(String msg, T data) {
        this.data = data;
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData(){ return data;}

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() { return msg;}
}

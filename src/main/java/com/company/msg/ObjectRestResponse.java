package com.company.msg;

/**
 * Created by Ace on 2018/8/11.
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    boolean rel;

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }


    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public ObjectRestResponse setData(T data) {
        this.data = data;
        return null;
    }

    @Override
    public String toString() {
        return "ObjectRestResponse{" +
                "data=" + data +
                ", rel=" + rel +
                '}';
    }
}

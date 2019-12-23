package com.lsh.common.http;

public interface HttpCallBack<T> {
    void onSuccess(T t);

    void onFailure(int code, String msg, T t);
}

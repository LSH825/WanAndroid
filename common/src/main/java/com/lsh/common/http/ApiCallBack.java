package com.lsh.common.http;

import java.lang.reflect.Type;

public abstract class ApiCallBack<T> implements HttpCallBack<T> {
    protected Type type;

    public Type getType() {
        return type;
    }

    public ApiCallBack() {
        this.type = ClassTypeReflect.getModelClazz(getClass());
    }
}

package com.lsh.common.http;

import retrofit2.Retrofit;

public class HttpUtils {

    public HttpUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
        HttpService service = retrofit.create(HttpService.class);
    }
}

package com.lsh.common.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HttpUtils {
    private Retrofit retrofit;

    private HttpUtils() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)//
                .connectTimeout(10, TimeUnit.SECONDS)//
                //log
                .addInterceptor(logging)
                //cache
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new SaveCookiesInterceptor())
                //ssl
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_HOST)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private static class Holder {
        private static HttpUtils INSTANCE = new HttpUtils();
    }

    public static HttpUtils getInstance() {
        return Holder.INSTANCE;
    }

    public ApiService getService() {
        return retrofit.create(ApiService.class);
    }
}

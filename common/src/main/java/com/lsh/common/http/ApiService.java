package com.lsh.common.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    /*-------------------------------------------------------------------------------------------------*/
    int ERROR_CODE_NET_FAUILE = 111;//网络错误
    String KEY_ERROR_CODE_NET_FAUILE = "网络错误";
    int ERROR_CODE_NO_DATA = 112;//
    String KEY_ERROR_CODE_NO_DATA = "数据为空";
    /*------------------------------------------------------------------------------------------------*/
    String API_HOST = "https://www.wanandroid.com/";
    /*------------------------------------------------------------------------------------------------*/
    @GET("article/list/{num}/json")
    Call<String> getArticle2(@Path("num") String num);

    @GET("article/listproject/{num}/json")
    Call<TestBean> listproject(@Path("num") String num);



}

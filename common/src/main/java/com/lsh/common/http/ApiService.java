package com.lsh.common.http;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {


    @Headers({"domain:change"})
    @GET("{url}")
    Call<String> get(@Path("url") String url);

    @Headers({"Content-Type: application/json", "Accept: application/json", "domain:change"})
    @POST("{url}")
    Call<String> post(@Path("url") String url, @Body RequestBody info);

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);
    /*------------------------------------------*/
    String API_HOST = "API_HOST";
    /*------------------------------------------*/
    int ERROR_CODE_NET_FAUILE = 111;//网络错误
    String KEY_ERROR_CODE_NET_FAUILE = "网络错误";
    int ERROR_CODE_NO_DATA = 112;//
    String KEY_ERROR_CODE_NO_DATA = "数据为空";
}

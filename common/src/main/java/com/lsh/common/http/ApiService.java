package com.lsh.common.http;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    /*-------------------------------------------------------------------------------------------------*/
    int ERROR_CODE_NET_FAUILE = 111;//网络错误
    String KEY_ERROR_CODE_NET_FAUILE = "网络错误";
    int ERROR_CODE_NO_DATA = 112;//
    String KEY_ERROR_CODE_NO_DATA = "数据为空";
    /*------------------------------------------------------------------------------------------------*/
    String API_HOST = "https://www.wanandroid.com/";
    /*-------------------------------------接口-----------------------------------------------------------*/

    /**
     * 首页banner
     */
    @GET("banner/json")
    Call<String> getBanner();

    /**
     * 文章列表
     */
    @GET("article/list/{page}/json")
    Call<String> getArticle(@Path("page") int page);

    /**
     * 常用网站
     */
    @GET("friend/json")
    Call<String> getFriendSite();

    /**
     * 热搜词
     */
    @GET("hotkey/json")
    Call<String> getHotKey();

    /**
     * 置顶文章
     */
    @GET("article/top/json")
    Call<String> getTopArticle();


    /**
     * 体系
     */
    @GET("tree/json")
    Call<String> getTree();

    /**
     * 知识体系下的文章
     */
    @GET("article/list/{page}/json")
    Call<String> getTreeArticle(@Path("page") int page, @Query("cid") String cid);


    /**
     * 按照作者昵称搜索文章
     */
    @GET("article/list/{page}/json?author={author}")
    Call<String> getTreeArticleByAuthor(@Path("page") int page, @Path("author") String author);

    @GET("article/listproject/{num}/json")
    Call<String> listproject(@Path("num") String num);

    @FormUrlEncoded
    @POST("user/login")
    Call<String> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/register")
    Call<String> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    @GET("user/logout/json")
    Call<String> logout();

}

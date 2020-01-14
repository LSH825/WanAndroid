package com.lsh.common.http;

import android.text.TextUtils;

import com.lsh.common.utils.hutils.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {
    private static final String COOKIE_PREF = "cookies_prefs";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        String cookie = getCookie(request.url().toString(), request.url().host());
        if (!TextUtils.isEmpty(cookie)) {
            builder.addHeader("Cookie", cookie);
        }

        return chain.proceed(builder.build());
    }

    private String getCookie(String url, String domain) {
        String cookie = SPUtils.getString(url, "");
        String domainStr = SPUtils.getString(domain, "");
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(cookie)) {
            return cookie;
        }
        if (!TextUtils.isEmpty(domain) && !TextUtils.isEmpty(domainStr)) {
            return domainStr;
        }

        return null;
    }
}

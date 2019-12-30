package com.lsh.wanandroid.base.web;

import android.graphics.Bitmap;

import com.lsh.common.utils.TextUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.base.web.JsApi;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import wendu.dsbridge.DWebView;

public class BaseWebViewActivity extends BaseActivity {
    public static final String KEY_INTENT_LINK = "INTENT_LINK";
    @BindView(R.id.web_view)
    DWebView webView;

    @Override
    public int getContentLayout() {
        return R.layout.base_webview;
    }

    @Override
    public void initView() {
        WebSettings settings = webView.getSettings();
//        settings.setJavaScriptCanOpenWindowsAutomatically(true);
//        settings.setDomStorageEnabled(true);
//        settings.setGeolocationEnabled(true);
//        settings.setDatabaseEnabled(true);
//        settings.setAppCacheEnabled(true);
//        settings.setAppCacheMaxSize(40 * 1024 * 1024);
//        settings.setAllowFileAccess(true);
//        settings.setLoadsImagesAutomatically(true);
//        settings.setUseWideViewPort(true);
//        settings.setLoadWithOverviewMode(true);
//        settings.setAllowUniversalAccessFromFileURLs(true);
//        settings.setMixedContentMode(android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        webView.addJavascriptObject(new JsApi(), null);
        DWebView.setWebContentsDebuggingEnabled(true);//debug
        String link = getIntent().getStringExtra(KEY_INTENT_LINK);
        webView.loadUrl(TextUtils.getSafeString(link));
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                return super.shouldOverrideUrlLoading(webView, s);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
            }
        });
    }

}

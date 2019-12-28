package com.lsh.wanandroid.ui.home;

import android.webkit.WebView;

import com.lsh.common.utils.TextUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseActivity;

import butterknife.BindView;

public class ArticleDetailActivity extends BaseActivity {
    public static final String KEY_INTENT_LINK = "INTENT_LINK";
    @BindView(R.id.web_view)
    WebView webView;

    @Override
    public int getContentLayout() {
        return R.layout.activity_article_detail;
    }

    @Override
    public void initView() {
        String link = getIntent().getStringExtra(KEY_INTENT_LINK);
        webView.loadUrl(TextUtils.getSafeString(link));
    }

}

package com.lsh.wanandroid.utils;

import android.content.Context;
import android.content.Intent;

import com.lsh.wanandroid.ui.home.ArticleDetailActivity;
import com.lsh.wanandroid.ui.mine.HotActivity;

public class PageManager {
    public static void openArticleDetailActivity(Context context, String link) {
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        intent.putExtra(ArticleDetailActivity.KEY_INTENT_LINK, link);
        context.startActivity(intent);
    }

    public static void openHotActivity(Context context) {
        Intent intent = new Intent(context, HotActivity.class);
        context.startActivity(intent);
    }

}

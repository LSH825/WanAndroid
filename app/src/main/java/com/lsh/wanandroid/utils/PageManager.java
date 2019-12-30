package com.lsh.wanandroid.utils;

import android.content.Context;
import android.content.Intent;

import com.lsh.wanandroid.base.web.BaseWebViewActivity;
import com.lsh.wanandroid.ui.mine.HotActivity;

public class PageManager {
    public static void openWebViewActivity(Context context, String link) {
        Intent intent = new Intent(context, BaseWebViewActivity.class);
        intent.putExtra(BaseWebViewActivity.KEY_INTENT_LINK, link);
        context.startActivity(intent);
    }

    public static void openHotActivity(Context context) {
        Intent intent = new Intent(context, HotActivity.class);
        context.startActivity(intent);
    }

}

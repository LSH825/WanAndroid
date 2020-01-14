package com.lsh.wanandroid.utils;

import android.content.Context;
import android.content.Intent;

import com.lsh.wanandroid.base.web.BaseWebViewActivity;
import com.lsh.wanandroid.ui.LoginActivity;
import com.lsh.wanandroid.ui.mine.HotActivity;
import com.lsh.wanandroid.ui.tree.TreeDetailListActivity;

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

    public static void openTreeDetailListActivity(Context context, String cid) {
        Intent intent = new Intent(context, TreeDetailListActivity.class);
        intent.putExtra(TreeDetailListActivity.KEY_INTENT_CID, cid);
        context.startActivity(intent);
    }
    public static void openLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}

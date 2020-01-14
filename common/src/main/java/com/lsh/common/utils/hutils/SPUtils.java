package com.lsh.common.utils.hutils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {
    private static final String SP_NAME = "SPUtils";

    private static SharedPreferences getSP() {
        return HUtils.getApp().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEdit() {
        return getSP().edit();
    }

    public static void putString(String key, String value) {
        getEdit().putString(key, value).apply();
    }

    public static String getString(String key, String defaultStr) {
        SharedPreferences sp = HUtils.getApp().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defaultStr);
    }
}

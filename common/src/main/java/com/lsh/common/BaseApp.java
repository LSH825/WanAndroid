package com.lsh.common;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.lsh.common.utils.hutils.HUtils;


public class BaseApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HUtils.init(this);
    }
}

package com.lsh.common.utils.hutils;

import android.app.Application;

public class HUtils {
    private static Application instance;

    public static void init(Application app) {
        instance = app;
    }

    public static Application getApp() {
        return instance;
    }
}

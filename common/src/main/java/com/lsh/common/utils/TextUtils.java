package com.lsh.common.utils;

public class TextUtils {
    public static String getSafeString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}

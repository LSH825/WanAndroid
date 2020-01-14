package com.lsh.common.utils;

public class StringUtils {
    public static String getSafeString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String... array) {
        if (array == null) {
            return true;
        }
        for (String s : array) {
            if (isEmpty(s)) {
                return true;
            }
        }
        return false;
    }
}

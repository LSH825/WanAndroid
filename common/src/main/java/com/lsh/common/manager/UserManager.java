package com.lsh.common.manager;

import com.google.gson.Gson;
import com.lsh.common.entity.UserBean;
import com.lsh.common.utils.hutils.SPUtils;

public class UserManager {
    private static final String KEY_SP_USER = "SP_USER";
    private static UserBean userBean;

    public static boolean saveUser(UserBean userBean) {
        try {
            String userStr = new Gson().toJson(userBean);
            SPUtils.putString(KEY_SP_USER, userStr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static UserBean getUser() {
        if (userBean != null) {
            return userBean;
        }
        String userStr = SPUtils.getString(KEY_SP_USER, "");
        try {
            return new Gson().fromJson(userStr, UserBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UserBean();
    }
}

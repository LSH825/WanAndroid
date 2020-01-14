package com.lsh.wanandroid.entity;

import com.lsh.common.entity.UserBean;
import com.lsh.common.http.ResultEntity;

public class UserEntity extends ResultEntity {

    /**
     * data : {"admin":false,"chapterTops":[],"collectIds":[],"email":"","icon":"","id":41875,"nickname":"812937199","password":"","publicName":"812937199","token":"","type":0,"username":"812937199"}
     */

    private UserBean data;

    public UserBean getData() {
        return data;
    }

    public void setData(UserBean data) {
        this.data = data;
    }
}

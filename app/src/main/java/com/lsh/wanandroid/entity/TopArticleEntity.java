package com.lsh.wanandroid.entity;

import com.lsh.common.http.ResultEntity;

import java.util.List;

public class TopArticleEntity extends ResultEntity {
    private List<ArticleDetailBean> data;

    public List<ArticleDetailBean> getData() {
        return data;
    }

    public void setData(List<ArticleDetailBean> data) {
        this.data = data;
    }
}

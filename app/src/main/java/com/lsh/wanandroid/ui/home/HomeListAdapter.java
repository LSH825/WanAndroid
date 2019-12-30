package com.lsh.wanandroid.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsh.common.utils.TextUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.entity.ArticleDetailBean;

import java.util.List;

public class HomeListAdapter extends BaseQuickAdapter<ArticleDetailBean, BaseViewHolder> {
    public HomeListAdapter(@Nullable List<ArticleDetailBean> data) {
        super(R.layout.item_list_home, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ArticleDetailBean item) {
        helper.setText(R.id.tv_title, item.getType() == 1 ? "【置顶】" + TextUtils.getSafeString(item.getTitle()) : TextUtils.getSafeString(item.getTitle()));
        helper.setText(R.id.tv_author, TextUtils.getSafeString(item.getAuthor()));
        helper.setText(R.id.tv_source, TextUtils.getSafeString(item.getSuperChapterName()));
        helper.setText(R.id.tv_time, TextUtils.getSafeString(item.getNiceShareDate()));

    }
}

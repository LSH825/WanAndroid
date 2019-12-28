package com.lsh.wanandroid.ui.home;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsh.common.utils.TextUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.entity.HomeEntity;

import java.util.List;

public class HomeListAdapter extends BaseQuickAdapter<HomeEntity.DataBean.DatasBean, BaseViewHolder> {
    public HomeListAdapter(@Nullable List<HomeEntity.DataBean.DatasBean> data) {
        super(R.layout.item_list_home, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomeEntity.DataBean.DatasBean item) {
        helper.setText(R.id.tv_title, TextUtils.getSafeString(item.getTitle()));
        helper.setText(R.id.tv_author, TextUtils.getSafeString(item.getAuthor()));
        helper.setText(R.id.tv_source, TextUtils.getSafeString(item.getSuperChapterName()));
        helper.setText(R.id.tv_time, TextUtils.getSafeString(item.getNiceShareDate()));

    }
}

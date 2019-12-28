package com.lsh.wanandroid.ui.mine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsh.common.utils.TextUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.entity.FriendSiteEntity;

import java.util.List;

public class FriendSiteAdapter extends BaseQuickAdapter<FriendSiteEntity.DataBean, BaseViewHolder> {
    public FriendSiteAdapter(@Nullable List<FriendSiteEntity.DataBean> data) {
        super(R.layout.item_hot_flex, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, FriendSiteEntity.DataBean item) {
        helper.setText(R.id.tv_title, TextUtils.getSafeString(item.getName()));
    }
}

package com.lsh.wanandroid.ui.tree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsh.common.utils.StringUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.entity.TreeEntity;

import java.util.List;

public class TreeFlexAdapter extends BaseQuickAdapter<TreeEntity.DataBean.ChildrenBean, BaseViewHolder> {
    public TreeFlexAdapter(@Nullable List<TreeEntity.DataBean.ChildrenBean> data) {
        super(R.layout.item_hot_flex, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TreeEntity.DataBean.ChildrenBean item) {
        helper.setText(R.id.tv_title, StringUtils.getSafeString(item.getName()));
    }
}
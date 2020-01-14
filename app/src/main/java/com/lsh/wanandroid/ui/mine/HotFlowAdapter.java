package com.lsh.wanandroid.ui.mine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsh.common.utils.StringUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.entity.HotKeyEntity;

import java.util.List;

public class HotFlowAdapter extends BaseQuickAdapter<HotKeyEntity.DataBean, BaseViewHolder> {
    public HotFlowAdapter(@Nullable List<HotKeyEntity.DataBean> data) {
        super(R.layout.item_hot_flex, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HotKeyEntity.DataBean item) {
        helper.setText(R.id.tv_title, StringUtils.getSafeString(item.getName()));
    }
}

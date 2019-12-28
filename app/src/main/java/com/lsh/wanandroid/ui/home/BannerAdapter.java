package com.lsh.wanandroid.ui.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.GlideApp;
import com.lsh.wanandroid.entity.BannerEntity;

import java.util.List;

public class BannerAdapter extends BaseQuickAdapter<BannerEntity.DataBean, BaseViewHolder> {
    public BannerAdapter(@Nullable List<BannerEntity.DataBean> data) {
        super(R.layout.item_banner, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, BannerEntity.DataBean item) {
        GlideApp.with(mContext)
                .load(item.getImagePath())//
                .placeholder(new ColorDrawable(Color.GRAY))
                .error(new ColorDrawable(Color.RED))
                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_banner));
    }
}

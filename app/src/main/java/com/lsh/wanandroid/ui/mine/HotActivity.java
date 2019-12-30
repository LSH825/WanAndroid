package com.lsh.wanandroid.ui.mine;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.entity.BannerEntity;
import com.lsh.wanandroid.entity.FriendSiteEntity;
import com.lsh.wanandroid.entity.HotKeyEntity;
import com.lsh.wanandroid.ui.home.BannerAdapter;
import com.lsh.wanandroid.utils.PageManager;

import butterknife.BindView;

public class HotActivity extends BaseActivity {
    @BindView(R.id.recycler_view_hot)
    RecyclerView recyclerViewHot;
    @BindView(R.id.recycler_view_site)
    RecyclerView recyclerViewSite;

    @Override
    public int getContentLayout() {
        return R.layout.activity_hot;
    }

    @Override
    public void initView() {
        recyclerViewHot.setLayoutManager(getFlexLayoutManager());
        recyclerViewSite.setLayoutManager(getFlexLayoutManager());
        getHotKey();
        getFriendSite();
    }

    private void getHotKey() {
        HttpManager.getHotKey(new ApiCallBack<HotKeyEntity>() {
            @Override
            public void onSuccess(HotKeyEntity resultEntity) {
                HotFlowAdapter adapter = new HotFlowAdapter(resultEntity.getData());
                recyclerViewHot.setAdapter(adapter);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HotKeyEntity.DataBean entity = (HotKeyEntity.DataBean) adapter.getItem(position);
                        if (entity != null) {
                            PageManager.openWebViewActivity(mContext, entity.getLink());
                        }
                    }

                });
            }
        });
    }

    private void getFriendSite() {
        HttpManager.getFriendSite(new ApiCallBack<FriendSiteEntity>() {
            @Override
            public void onSuccess(FriendSiteEntity resultEntity) {
                FriendSiteAdapter adapter = new FriendSiteAdapter(resultEntity.getData());
                recyclerViewSite.setAdapter(adapter);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        FriendSiteEntity.DataBean entity = (FriendSiteEntity.DataBean) adapter.getItem(position);
                        if (entity != null) {
                            PageManager.openWebViewActivity(mContext, entity.getLink());
                        }
                    }
                });
            }
        });
    }

    private FlexboxLayoutManager getFlexLayoutManager() {
        return new FlexboxLayoutManager(mContext);
    }
}

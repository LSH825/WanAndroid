package com.lsh.wanandroid.ui.mine;

import androidx.recyclerview.widget.RecyclerView;

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
                recyclerViewHot.setAdapter(new HotFlowAdapter(resultEntity.getData()));
            }
        });
    }

    private void getFriendSite() {
        HttpManager.getFriendSite(new ApiCallBack<FriendSiteEntity>() {
            @Override
            public void onSuccess(FriendSiteEntity resultEntity) {
                recyclerViewSite.setAdapter(new FriendSiteAdapter(resultEntity.getData()));
            }
        });
    }

    private FlexboxLayoutManager getFlexLayoutManager() {
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(mContext);
        return layoutManager;
    }
}

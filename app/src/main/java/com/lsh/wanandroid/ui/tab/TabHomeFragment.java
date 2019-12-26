package com.lsh.wanandroid.ui.tab;


import androidx.viewpager2.widget.ViewPager2;

import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.entity.BannerEntity;

import butterknife.BindView;

/**
 *
 */
public class TabHomeFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager2 viewPager;

    private TabHomeFragment() {
    }

    public static TabHomeFragment newInstance() {
        return new TabHomeFragment();
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        getBanner();
    }

    private void getBanner() {
        HttpManager.getBanner(new ApiCallBack<BannerEntity>() {
            @Override
            public void onSuccess(BannerEntity resultEntity) {

            }

            @Override
            public void onFailure(int code, String msg, BannerEntity resultEntity) {

            }
        });
    }

}

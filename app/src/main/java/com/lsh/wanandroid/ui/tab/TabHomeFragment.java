package com.lsh.wanandroid.ui.tab;


import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.common.http.ResultEntity;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;

/**
 *
 */
public class TabHomeFragment extends BaseFragment {

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

    }

    private void getBanner() {
        HttpManager.getBanner(new ApiCallBack<ResultEntity>() {
            @Override
            public void onSuccess(ResultEntity resultEntity) {

            }

            @Override
            public void onFailure(int code, String msg, ResultEntity resultEntity) {

            }
        });
    }

}

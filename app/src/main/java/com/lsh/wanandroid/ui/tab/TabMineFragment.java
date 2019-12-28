package com.lsh.wanandroid.ui.tab;


import android.view.View;

import androidx.fragment.app.Fragment;

import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.utils.PageManager;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMineFragment extends BaseFragment {

    public TabMineFragment() {
    }

    public static TabMineFragment newInstance() {
        return new TabMineFragment();
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.tv_tools_site, R.id.tv_tools_like})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tools_site:
                PageManager.openHotActivity(mContext);
                break;
            case R.id.tv_tools_like:
                break;
        }
    }
}

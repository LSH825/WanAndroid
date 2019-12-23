package com.lsh.wanandroid.ui;


import androidx.fragment.app.Fragment;

import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;

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
}

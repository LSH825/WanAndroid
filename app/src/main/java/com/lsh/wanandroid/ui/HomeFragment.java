package com.lsh.wanandroid.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;

/**
 *
 */
public class HomeFragment extends BaseFragment {
    private HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {

    }
}

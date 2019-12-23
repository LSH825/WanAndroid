package com.lsh.wanandroid.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;


public class HomePageFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public HomePageFragment() {
        // Required empty public constructor
    }

    public static HomePageFragment newInstance(String param1) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView() {

    }
}

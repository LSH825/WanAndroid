package com.lsh.wanandroid.ui;

import android.os.Bundle;

import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;


public class ProjectFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public ProjectFragment() {

    }

    public static ProjectFragment newInstance(String param1) {
        ProjectFragment fragment = new ProjectFragment();
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
        return R.layout.fragment_project;
    }

    @Override
    public void initView() {

    }
}

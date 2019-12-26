package com.lsh.wanandroid.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.common.http.HttpUtils;
import com.lsh.common.http.ResultEntity;
import com.lsh.common.http.TestBean;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomePageFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.btn_click)
    Button btnClick;
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
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpManager.getArticle(0, new ApiCallBack<TestBean>() {
                    @Override
                    public void onSuccess(TestBean resultEntity) {

                    }

                    @Override
                    public void onFailure(int code, String msg, TestBean resultEntity) {

                    }
                });
            }
        });
    }
}

package com.lsh.wanandroid.base;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        beforeInit();
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initView();
    }

    protected void beforeInit() {

    }

}

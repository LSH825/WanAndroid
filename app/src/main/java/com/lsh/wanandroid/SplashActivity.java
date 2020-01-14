package com.lsh.wanandroid;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.ui.MainActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_ad)
    ImageView ivAd;

    @Override
    public int getContentLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        }, 2000);

    }

}

package com.lsh.wanandroid;

import android.widget.ImageView;

import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.base.GlideApp;

import butterknife.BindView;

public class ADActivity extends BaseActivity {


    @BindView(R.id.iv_ad)
    ImageView ivAd;

    @Override
    public int getContentLayout() {
        return R.layout.activity_ad;
    }

    @Override
    public void initView() {
        GlideApp.with(mContext).load("https://wanandroid.com/blogimgs/fa432a45-66af-4c9f-b0ea-c824be3f37c9.png").centerCrop().into(ivAd);
    }

}

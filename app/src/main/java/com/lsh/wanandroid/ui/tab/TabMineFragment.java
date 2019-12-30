package com.lsh.wanandroid.ui.tab;


import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.base.GlideApp;
import com.lsh.wanandroid.utils.PageManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMineFragment extends BaseFragment {

    @BindView(R.id.iv_head)
    ImageView ivHead;

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
        GlideApp.with(this).load("http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20171116143737-1895154083_gif_398_305_3740344/0").centerCrop().into(ivHead);
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

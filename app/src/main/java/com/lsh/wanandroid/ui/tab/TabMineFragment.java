package com.lsh.wanandroid.ui.tab;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lsh.common.entity.UserBean;
import com.lsh.common.manager.EventBusManager;
import com.lsh.common.manager.MessageEvent;
import com.lsh.common.manager.UserManager;
import com.lsh.common.utils.StringUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseFragment;
import com.lsh.wanandroid.base.GlideApp;
import com.lsh.wanandroid.utils.PageManager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMineFragment extends BaseFragment {

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.ll_to_login)
    LinearLayout llToLogin;
    @BindView(R.id.tv_tools_site)
    TextView tvToolsSite;
    @BindView(R.id.tv_tools_like)
    TextView tvToolsLike;

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
        EventBusManager.register(this);
    }

    @OnClick({R.id.tv_tools_site, R.id.tv_tools_like, R.id.ll_to_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tools_site:
                PageManager.openHotActivity(mContext);
                break;
            case R.id.tv_tools_like:
                break;
            case R.id.ll_to_login:
                PageManager.openLoginActivity(mContext);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getType()) {
            case EventBusManager.EVENT_LOGIN:
                UserBean userBean = UserManager.getUser();
                GlideApp.with(mContext).load(userBean.getIcon()).into(ivAvatar);
                tvUsername.setText(StringUtils.getSafeString(userBean.getNickname()));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusManager.unregister(this);
    }

    ;
}

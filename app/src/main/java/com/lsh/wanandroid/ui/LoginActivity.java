package com.lsh.wanandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lsh.common.entity.UserBean;
import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.common.manager.EventBusManager;
import com.lsh.common.manager.MessageEvent;
import com.lsh.common.manager.UserManager;
import com.lsh.common.utils.StringUtils;
import com.lsh.common.utils.ToastUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.entity.UserEntity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.btn_logon, R.id.btn_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_logon:
                login();
                break;
            case R.id.btn_reg:
                startActivity(new Intent(mContext, RegisterActivity.class));
                break;
        }
    }

    private void login() {
        String account = etAccount.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if (StringUtils.isEmpty(account, pwd)) {
            Toast.makeText(mContext, "请填写内容", Toast.LENGTH_SHORT).show();
            return;
        }

        HttpManager.login(account, pwd, new ApiCallBack<UserEntity>() {
            @Override
            public void onSuccess(UserEntity resultEntity) {
                super.onSuccess(resultEntity);
                UserBean userBean = resultEntity.getData();
                if (userBean != null) {
                    if (UserManager.saveUser(userBean)) {
                        EventBusManager.post(EventBusManager.EVENT_LOGIN);
                        finish();
                    } else {
                        ToastUtils.show(mContext, "登录失败");
                    }
                }
            }

            @Override
            public void onFailure(int code, String msg, UserEntity resultEntity) {
                super.onFailure(code, msg, resultEntity);
                ToastUtils.show(mContext, msg);
            }
        });
    }
}

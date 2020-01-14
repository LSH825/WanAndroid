package com.lsh.wanandroid.ui;

import android.widget.EditText;
import android.widget.Toast;

import com.lsh.common.http.ApiCallBack;
import com.lsh.common.http.HttpManager;
import com.lsh.common.utils.StringUtils;
import com.lsh.common.utils.ToastUtils;
import com.lsh.wanandroid.R;
import com.lsh.wanandroid.base.BaseActivity;
import com.lsh.wanandroid.entity.UserEntity;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_pwd_re)
    EditText etPwdRe;

    @Override
    public int getContentLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {

    }


    @OnClick(R.id.btn_reg)
    public void onViewClicked() {
        String account = etAccount.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        String repwd = etPwdRe.getText().toString().trim();
        if (StringUtils.isEmpty(account, pwd, repwd)) {
            Toast.makeText(mContext, "请填写内容", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.text.TextUtils.equals(pwd, repwd)) {
            Toast.makeText(mContext, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        HttpManager.register(account, pwd, repwd, new ApiCallBack<UserEntity>() {
            @Override
            public void onSuccess(UserEntity resultEntity) {
                super.onSuccess(resultEntity);

            }

            @Override
            public void onFailure(int code, String msg, UserEntity resultEntity) {
                super.onFailure(code, msg, resultEntity);
                ToastUtils.show(mContext, msg);
            }
        });
    }
}

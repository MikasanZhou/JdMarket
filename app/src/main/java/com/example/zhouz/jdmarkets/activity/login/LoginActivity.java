package com.example.zhouz.jdmarkets.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.commonlib.BaseActivity;
import com.example.zhouz.jdmarkets.R;

import org.apache.log4j.*;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    private final Logger mLogger = Logger.getLogger(LoginActivity.class);

    @BindView(R.id.btn_login_by_phone)
    Button mBtnLoginByPhone;
    @BindView(R.id.btn_register)
    Button mBtnRegister;
    @BindView(R.id.tv_user_first)
    TextView mTvUserFirst;


    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        mBtnLoginByPhone.setOnClickListener(this::onClick);
        mBtnRegister.setOnClickListener(this::onClick);
        mTvUserFirst.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_by_phone:
                //手机号登录
                mLogger.debug("btn_login_by_phone");
                startActivity(new Intent(mContext,PhoneLoginActivity.class));
                break;
            case R.id.btn_register:
                break;
            case R.id.tv_user_first:
                break;
            default:
                break;
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);

    }
}

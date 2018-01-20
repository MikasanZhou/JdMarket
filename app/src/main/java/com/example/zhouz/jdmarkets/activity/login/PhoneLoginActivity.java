package com.example.zhouz.jdmarkets.activity.login;

import android.os.Bundle;

import com.example.commonlib.BaseActivity;
import com.example.zhouz.jdmarkets.R;

public class PhoneLoginActivity extends BaseActivity {


    @Override
    protected void initData() {
        
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_phone_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        
        mToolbar = findViewById(R.id.tb_common_toolbar);
    }


}

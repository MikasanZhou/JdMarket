package com.example.zhouz.jdmarkets.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.commonlib.BaseActivity;
import com.example.zhouz.jdmarkets.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_splash)
    ImageView mIvSplash;

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {
        mIvSplash.postDelayed(() -> {
            startActivity(new Intent(mContext, GuideActivity.class));
            SplashActivity.this.finish();
        }, 1500);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);

    }
}

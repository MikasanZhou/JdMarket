package com.example.zhouz.jdmarket.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.example.commonlib.BaseActivity;
import com.example.zhouz.jdmarket.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_splash)
    ImageView mIvSplash;

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        mIvSplash.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, GuideActivity.class));
                SplashActivity.this.finish();
            }
        }, 1500);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }
}

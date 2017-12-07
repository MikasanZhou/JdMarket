package com.example.zhouz.jdmarkets;

import android.app.Application;
import android.content.Context;

import com.example.commonlib.utils.SharePrefUtils;
import com.example.loglib.LogHelper;
import com.example.retrofit.manager.NetWorkManager;
import com.tencent.bugly.Bugly;

/**
 * @author
 * @version 1.0
 * @date 2017/11/30
 */

public class JDApp extends Application {

    private static Context mContext;

    private static final String SP_NAME = "sp_market";

    public static Context getContext() {
        return mContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = base;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        LogHelper.config("/debug.log",true);

        //初始化网络请求 retrofit
        NetWorkManager.get().init();
        //初始化sp
        SharePrefUtils.get().init(getApplicationContext(), SP_NAME);
        //初始化bugly
        Bugly.init(getApplicationContext(), "6a0a2564b7", true);


    }
}

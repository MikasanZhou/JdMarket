package com.example.commonlib;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {
    
    public Context mContext;
    
    public Handler mProHandler;
    
    public Handler mUiHandler;
    
    private HandlerThread mHandlerThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mContext = this;

        initView();
        initData();
        initEvent();
        initHandler();
    }

    /**
     * 主线程 回调
     */
    private Handler.Callback mUiCallBack = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return handlerUiMessage(message);
        }
    };

    

    /**
     * 子线程回调
     */
    private Handler.Callback mProCallBack= new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            
            return handlerProMessage(message);
        }
    };


    /**
     * 初始化handler
     */
    protected  void initHandler(){
        mUiHandler = new Handler(getMainLooper(),mUiCallBack);
        mHandlerThread = new HandlerThread("son");
        mHandlerThread.start();
        mProHandler = new Handler(mHandlerThread.getLooper(),mProCallBack);
    }

    /**
     * 初始数据
     */
    protected abstract void initData();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /**
     * 获取布局id
     * @return layoutId
     */
    protected abstract int getContentView();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 主线程回调
     */
    protected  boolean handlerUiMessage(Message message){
        return false;
    }

    /**
     * 子线程回调
     */
    protected  boolean handlerProMessage(Message message){
        return false;
    }
}

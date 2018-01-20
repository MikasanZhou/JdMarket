package com.example.retrofit.rxjava;

import android.content.Context;

import com.example.retrofit.manager.NetWorkManager;

import rx.Observable;
import rx.Subscriber;

/**
 * @author
 * @version 1.0
 * @date 2017/12/10
 */

public class HttpHelper {

    private static HttpHelper mInstance;

    private Context mContext;
    /**
     * 被监听
     */
    private Observable<String> mObservable;
    private Subscriber<String> mSubscriber;

    private HttpHelper(Context context) {
        mContext = context;
    }

    public static HttpHelper getmInstance(Context context) {
        if (mInstance == null) {
            synchronized (HttpHelper.class) {
                if (mInstance == null) {
                    mInstance = new HttpHelper(context);
                }
            }
        }
        return mInstance;
    }
    
    public void init(){
        mObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                
            }
        });
        
        mSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
    }
    
    
    public void subscribe(){
        mObservable.subscribe(mSubscriber);
    }
    

}
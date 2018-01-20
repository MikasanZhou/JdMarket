package com.example.retrofit.manager;

import com.example.retrofit.ApiConstants;
import com.example.retrofit.LoginService;
import com.example.retrofit.model.UserInfo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * @author
 * @version 1.0
 * @date 2017/12/4
 */

public class NetWorkManager {
//    final Logger mLogger = Logger.getLogger(NetWorkManager.class);

    private static NetWorkManager mInstance;

    private LoginService mLoginService;
    private Interceptor mIntercept = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            return null;
        }
    };

    public static NetWorkManager get() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }


    public void init() {
        Retrofit retrofit = new Retrofit.Builder()
                //ip+端口
                .baseUrl(ApiConstants.BASE_URL)
                //fastjson解析
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .addInterceptor(mIntercept)
                        .build())
                .build();

        mLoginService = retrofit.create(LoginService.class);
    }

    /**
     * 用户登录
     *
     * @param userInfo
     * @param callback
     */
    public void login(UserInfo userInfo, Callback<ResponseBody> callback) {
        Call<ResponseBody> call = mLoginService.login(userInfo);
        call.enqueue(callback);
    }

    /**
     * 获取用户信息
     *
     * @param id
     * @param callback
     */
    public void getUserInfo(int id, Callback<ResponseBody> callback) {
        Call<ResponseBody> call = mLoginService.getUserInfo(id);
        call.enqueue(callback);
    }


    private class LogInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url();
//            mLogger.debug("request url:" + url);
            return chain.proceed(request);
        }
    }
    
}

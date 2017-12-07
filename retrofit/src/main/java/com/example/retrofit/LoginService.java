package com.example.retrofit;

import com.example.retrofit.model.UserInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author
 * @version 1.0
 * @date 2017/12/4
 */

public interface LoginService {
    /**
     * 用户登录
     * @param userInfo 用户登录信息  用户名  密码
     */
    @POST(ApiConstants.USER_LOGIN)
    Call<ResponseBody> login(@Body UserInfo userInfo);

    /**
     * 更具用户id获取用户信息
     * @param id  userId
     */
    @GET(ApiConstants.GET_USER_INFO)
    Call<ResponseBody> getUserInfo(@Path("userId") int id); 
}

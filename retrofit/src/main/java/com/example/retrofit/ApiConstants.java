package com.example.retrofit;

/**
 * 用于存放网络请求地址字段
 * @author zyl
 * @version 1.0
 * @date 2017/12/4
 */

public interface ApiConstants {
    /**
     * base url ip+port
     */
    String BASE_URL = "http://39.108.83.74:9999/";
    /**
     * 登录url
     */
    String USER_LOGIN = "user/login";
    /**
     * 获取用户信息
     */
    String GET_USER_INFO = "user/{userId}";
}

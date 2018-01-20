package com.example.retrofit.`interface`

import com.example.retrofit.ApiConstants
import com.example.retrofit.model.UserInfo
import retrofit2.http.Body
import retrofit2.http.GET

/**
 *
 *
 * @author
 * @date    2017/12/11
 * @version 1.0
 */
interface SSOService {
    @GET(ApiConstants.USER_LOGIN)
    fun login(@Body loginInfo :UserInfo)
}
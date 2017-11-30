package com.example.commonlib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author  
 * @version 1.0
 * @date 2017/11/26
 */

public class SharePrefUtils {

    private static final String SP_MARKET = "sp_market";
    
    private static SharePrefUtils mInstance;
    
    private  SharedPreferences sharedPreferences;

    public  void init(Context context,String spName) {
         sharedPreferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }
    
    public static SharePrefUtils get(){
        if(mInstance == null){
            synchronized (SharePrefUtils.class){
                if(mInstance ==null){
                    mInstance = new SharePrefUtils();
                }
            }
        }
        return mInstance;
    }
    
    public void put(String key,String value){
       sharedPreferences.edit().putString(key, value).apply();
    }
    
    public String get(String key){
        return sharedPreferences.getString(key, "");
    }
}
    

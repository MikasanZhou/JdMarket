package com.example.retrofit.fastjson;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * @author
 * @version 1.0
 * @date 2017/12/4
 */

public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    
    private final Type mType;

    public FastJsonResponseBodyConverter(Type type) {
        mType = type;
    }

    /*
  * 转换方法
  */
    @Override
    public T convert(ResponseBody value) throws IOException  {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String tempStr = bufferedSource.readUtf8();
        bufferedSource.close();
        return JSON.parseObject(tempStr, mType);

    }
}

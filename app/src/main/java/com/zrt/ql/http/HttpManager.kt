package com.zrt.ql.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2019/6/3.
 */
class HttpManager private constructor(){
    private val BASE_URL :String = ""
    private lateinit var retrofit :Retrofit
    private lateinit var client :OkHttpClient

    companion object{
        val instance = SingletonHolder.holder
    }
    private object SingletonHolder{
        val holder = HttpManager()
    }

    init {
        val interceptor = HttpLoggingInterceptor(Logger { message ->
            Log.e("请求", message)
            if (message.contains("Set-Cookie")) {

            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10000L,TimeUnit.MILLISECONDS)
                .readTimeout(10000L,TimeUnit.MILLISECONDS)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(NoBodyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    fun <T> create(service: Class<T>): T{
        return retrofit.create(service)
    }
}
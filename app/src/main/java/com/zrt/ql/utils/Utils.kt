package com.zrt.ql.utils

import android.annotation.SuppressLint
import android.content.Context

/**
 * Created by Administrator on 2019/5/30.
 */
class Utils {
    companion object{
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        /**
         * 初始化工具类

         * @param context 上下文
         */
        fun init(context: Context) {
            Utils.context = context.applicationContext
        }

    }


    private fun Utils(){
        throw UnsupportedOperationException("u can't instantiate me...")
    }



}
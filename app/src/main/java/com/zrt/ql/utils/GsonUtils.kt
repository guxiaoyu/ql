package com.zrt.ql.utils

import com.google.gson.Gson

/**
 * Created by Administrator on 2019/5/31.
 */
object GsonUtils {
    private var gson: Gson? = null
    init {
        if (gson == null) {
            gson = Gson ()
        }
    }



    fun beanToJson(any: Any):String?{
        var gsonStr : String ?=null
        gsonStr = gson?.toJson(any)
        return gsonStr
    }

}
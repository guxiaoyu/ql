package com.zrt.ql.http

import retrofit2.Converter
import retrofit2.Retrofit
import okhttp3.RequestBody
import okhttp3.ResponseBody
import java.lang.reflect.Type


/**
 * Created by Administrator on 2019/6/3.
 */


class NoBodyConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        return super.responseBodyConverter(type, annotations, retrofit)
    }

    override fun requestBodyConverter(type: Type, parameterAnnotations: Array<Annotation>, methodAnnotations: Array<Annotation>, retrofit: Retrofit): Converter<*, RequestBody>? {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    override fun stringConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<*, String>? {
        return super.stringConverter(type, annotations, retrofit)
    }

    companion object {

        fun creat(): NoBodyConverterFactory {
            return NoBodyConverterFactory()
        }
    }
}

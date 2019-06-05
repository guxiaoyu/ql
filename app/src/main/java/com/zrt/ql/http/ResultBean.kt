package com.zrt.ql.http

/**
 * Created by Administrator on 2019/6/3.
 */
class ResultBean<T> {
    var code :Int =0
    var msg :String ?=null
    var result :T ?=null
}


package com.zrt.ql

import android.support.multidex.MultiDex
import com.zrt.ql.base.BaseApplication

/**
 * Created by Administrator on 2019/6/4.
 */
class MyApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }
}
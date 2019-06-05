package com.zrt.ql.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.zrt.ql.utils.Utils

/**
 * Created by Administrator on 2019/5/30.
 */
open class BaseApplication : Application() {
    companion object{
        open lateinit var sInstance:Application

        @Synchronized
        fun setApplication(application: Application){
            sInstance = application
            //初始化工具类
            Utils.init(application)
            //注册监听每个activity生命周期，便于堆栈式管理
            application.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{
                override fun onActivityPaused(p0: Activity?) {

                }

                override fun onActivityResumed(p0: Activity?) {
                }

                override fun onActivityStarted(p0: Activity?) {
                }

                override fun onActivityDestroyed(p0: Activity?) {
                    AppManager.get().removeActivity(p0)
                }

                override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
                }

                override fun onActivityStopped(p0: Activity?) {
                }

                override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
                    AppManager.get().addActivity(p0)
                }

            })
        }
    }

    override fun onCreate() {
        super.onCreate()
        setApplication(this)
    }




}
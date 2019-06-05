package com.zrt.ql.base

import android.app.Activity
import android.support.v4.app.Fragment
import java.util.*

/**
 * Created by Administrator on 2019/5/30.
 */
class AppManager private constructor(){
    companion object{
        private var activityStack : Stack<Activity> ? =null
        private var fragmentStack : Stack<Fragment> ?=null
        private var instance:AppManager ?=null
            get(){
                if (field == null){
                    field = AppManager()
                }
                return field
            }
        fun get():AppManager{
            return instance!!
        }

        fun getActivityStackMethod():Stack<Activity>{
            return activityStack!!
        }

        fun getFragmentStackMethod():Stack<Fragment>{
            return fragmentStack!!
        }
    }

    /**
     * 添加activity到堆栈
     */
    fun addActivity(activity: Activity?){
        if (activityStack ==null){
            activityStack = Stack<Activity>()
        }
        activityStack?.add(activity)
    }

    /**
     * 移除指定activity
     */
    fun removeActivity(activity: Activity?){
        if (activity!=null){
            activityStack?.remove(activity)
        }
    }

    /**
     * 结束当前activity
     */
    fun finishActivity(){
        var activity : Activity = activityStack?.lastElement()!!
        finishActivity(activity)
    }
    /**
     * 结束指定activity
     */
    fun finishActivity(activity: Activity?){
        if (activity!=null){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
    }

    /**
     * 结束指定类名的activity
     */
    fun finishActivity(clz:Class<*>){
        if (activityStack == null)
            return
        activityStack!!
                .filter { it.javaClass==clz  }
                .forEach { finishActivity(it) }
    }

    /**
     * 结束所有activity
     */
    fun finishAllActivity(){
        if (activityStack == null)
            return
        activityStack!!.indices
                .filter { null !=activityStack!![it] }
                .forEach { finishActivity(activityStack!![it]) }
        activityStack!!.clear()
    }

    /**
     * 添加Fragment到堆栈
     */
    fun addFragment(fragment: Fragment) {
        if (fragmentStack == null) {
            fragmentStack = Stack<Fragment>()
        }
        fragmentStack?.add(fragment)
    }

    /**
     * 移除指定的Fragment
     */
    fun removeFragment(fragment: Fragment?) {
        if (fragment != null) {
            fragmentStack?.remove(fragment)
        }
    }


    /**
     * 是否有Fragment
     */
    fun isFragment(): Boolean {
        if (fragmentStack != null) {
            return !fragmentStack!!.isEmpty()
        }
        return false
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentFragment(): Fragment? {
        if (fragmentStack != null) {
            val fragment = fragmentStack!!.lastElement()
            return fragment
        }
        return null
    }

}
package com.zrt.ql.base

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.zrt.ql.http.HttpManager
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.zrt.ql.ui.home.apiservice.HomeApiService


/**
 * Created by Administrator on 2019/6/4.
 */
abstract class BaseRepository<T>(protected var context: Context) {
    protected  var liveData : MutableLiveData<T>

    init {
        liveData = MutableLiveData()
    }
    fun loadData(){
        HttpManager.instance.create(getApiService())
    }

    /**
     * 获取数据
     */
    fun getData(): MutableLiveData<T> {
        return liveData
    }

    abstract fun getApiService():Class<T>
}
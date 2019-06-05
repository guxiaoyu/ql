package com.zrt.ql.base

import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.app.Application
import android.support.annotation.NonNull

/**
 * Created by Administrator on 2019/6/4.
 */
@Suppress("LeakingThis")
abstract class BaseViewModel<T : BaseRepository<*>>(@NonNull application: Application) : AndroidViewModel(application) {

    protected var context: Context = application

    protected var repository: T

    init {
        repository = getRepositoryMethod()
    }

    protected abstract fun getRepositoryMethod(): T
}
package com.zrt.ql.base

import android.content.Context
import android.support.v4.app.Fragment
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LifecycleRegistryOwner

/**
 * Created by Administrator on 2019/6/4.
 */
abstract class BaseFragment<T : BaseViewModel<*>> : Fragment() {

    protected var viewModel: T? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (viewModel == null) {
            viewModel = getViewModelMethod()
        }
    }

    protected abstract fun getViewModelMethod(): T
}
package com.zrt.ql.ui.home.viewmodel

import com.zrt.ql.base.BaseApplication
import com.zrt.ql.base.BaseViewModel
import com.zrt.ql.ui.home.repository.HomeFragRepository

/**
 * Created by Administrator on 2019/6/4.
 */
class HomeFragViewModel : BaseViewModel<HomeFragRepository>(application = BaseApplication.sInstance) {
    override fun getRepositoryMethod(): HomeFragRepository {
        return HomeFragRepository()
    }
}
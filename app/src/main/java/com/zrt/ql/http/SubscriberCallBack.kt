package com.zrt.ql.http

import android.content.Context
import rx.Subscriber
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



/**
 * Created by Administrator on 2019/6/3.
 */
class SubscriberCallBack<T> constructor(context: Context): Subscriber<T>() {

    override fun onError(e: Throwable?) {
    }

    override fun onCompleted() {
    }

    override fun onNext(t: T) {
    }
}
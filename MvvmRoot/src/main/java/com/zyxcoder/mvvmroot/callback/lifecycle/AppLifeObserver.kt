package com.zyxcoder.mvvmroot.callback.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.zyxcoder.mvvmroot.callback.livedata.data.BooleanLiveData

/**
 * Create by zyx_coder on 2022/11/17
 */
object AppLifeObserver : LifecycleObserver {
    var isForeground = BooleanLiveData()

    //app在前台
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onForeground() {
        isForeground.value = true
    }

    //app在后台
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onBackground() {
        isForeground.value = false
    }
}
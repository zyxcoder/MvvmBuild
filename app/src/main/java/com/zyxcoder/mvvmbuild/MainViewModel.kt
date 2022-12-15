package com.zyxcoder.mvvmbuild

import androidx.lifecycle.MutableLiveData
import com.zyxcoder.mvvmbuild.data.BannerData
import com.zyxcoder.mvvmroot.base.viewmodel.BaseViewModel
import com.zyxcoder.mvvmroot.ext.request
import kotlinx.coroutines.Job

/**
 * Create by zyx_coder on 2022/12/8
 */
class MainViewModel : BaseViewModel() {


    val testData = MutableLiveData<BannerData>()
    fun fetchBanner() {
        request<Job>(
            block = {
                testData.value = apiService.getBanner()
            }
        )
    }
}
package com.zyxcoder.mvvmbuild

import com.zyxcoder.mvvmbuild.data.BannerData
import retrofit2.http.GET

/**
 * Create by zyx_coder on 2022/12/8
 */
interface ApiService {

    companion object {
        const val SERVER_URL = "https://wanandroid.com/"
    }


    @GET("banner/json")
    suspend fun getBanner(): BannerData
}
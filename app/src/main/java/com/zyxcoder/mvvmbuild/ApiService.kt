package com.zyxcoder.mvvmbuild

import retrofit2.http.GET

/**
 * Create by zyx_coder on 2022/12/8
 */
interface ApiService {

    companion object {
        const val SERVER_URL = "http://data.live.126.net/"
    }


    @GET("livechannel/previewlist.json")
    suspend fun getApiData(): Any
}
package com.zyxcoder.mvvmbuild.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * Create by zyx_coder on 2022/12/8
 */
@Keep
data class BannerData(
    @SerializedName("data")
    val bannerList: List<Data>?,
    @SerializedName("errorCode")
    val errorCode: Int?,
    @SerializedName("errorMsg")
    val errorMsg: String?
)

@Keep
data class Data(
    @SerializedName("desc")
    val bannerDesc: String?,
    @SerializedName("id")
    val bannerId: Int?,
    @SerializedName("imagePath")
    val bannerImageUrl: String?,
    @SerializedName("isVisible")
    val bannerIsVisible: Int?,
    @SerializedName("order")
    val bannerOrder: Int?,
    @SerializedName("title")
    val bannerTitle: String?,
    @SerializedName("type")
    val bannerType: Int?,
    @SerializedName("url")
    val bannerUrl: String?
)
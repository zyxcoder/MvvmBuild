package com.zyxcoder.mvvmroot.ext

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import androidx.annotation.StringRes
import com.zyxcoder.mvvmroot.utils.ToastUtils

/**
 * Create by zyx_coder on 2022/11/18
 */
/**
 * showToast
 * @param stringRes toast string资源id
 * @param gravity toast位置
 */
@JvmOverloads
fun Context?.showToast(@StringRes stringRes: Int, gravity: Int = Gravity.CENTER) {
    showToast(
        try {
            this?.resources?.getString(stringRes) ?: "unknown toast string"
        } catch (e: Resources.NotFoundException) {
            "unknown resource string id"
        }, gravity
    )
}

/**
 * showToast
 * @param message toast字符串
 * @param gravity toast位置
 */
@JvmOverloads
fun Context?.showToast(message: String, gravity: Int = Gravity.CENTER) {
    ToastUtils.showMvvmToast(this, message, gravity)
}

package com.zyxcoder.mvvmbuild

import android.os.Bundle
import androidx.lifecycle.Observer
import com.zyxcoder.mvvmbuild.databinding.ActivityMainBinding
import com.zyxcoder.mvvmroot.base.activity.BaseVmVbActivity
import com.zyxcoder.mvvmroot.utils.PicSelectUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVmVbActivity<MainViewModel, ActivityMainBinding>() {
    override fun initView(savedInstanceState: Bundle?) {

        btClick.setOnClickListener {
            PicSelectUtils.checkPermission(this,PicSelectUtils.CHOOSE_PIC_TYPE_IS_GALLERY)
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.fetchBanner()
    }

    override fun showLoading(message: String) {
    }

    override fun dismissLoading() {
    }

    override fun createObserver() {
        mViewModel.apply {
            testData.observe(this@MainActivity, Observer {
                mViewBind.tvContent.text = it.toString()
            })
        }
    }

    override fun initData() {
    }

}
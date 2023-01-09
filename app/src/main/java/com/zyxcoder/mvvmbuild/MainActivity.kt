package com.zyxcoder.mvvmbuild

import android.os.Bundle
import androidx.lifecycle.Observer
import com.zyxcoder.mvvmbuild.databinding.ActivityMainBinding
import com.zyxcoder.mvvmroot.base.activity.BaseVmVbActivity

class MainActivity : BaseVmVbActivity<MainViewModel, ActivityMainBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
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
package com.zyxcoder.mvvmbuild

import android.os.Bundle
import androidx.lifecycle.Observer
import com.zyxcoder.mvvmbuild.databinding.ActivityMainBinding
import com.zyxcoder.mvvmroot.base.activity.BaseVmVbActivity
import com.zyxcoder.mvvmroot.common.bus.Bus
import com.zyxcoder.mvvmroot.ext.showToast
import com.zyxcoder.mvvmroot.utils.PicSelectUtils

class MainActivity : BaseVmVbActivity<MainViewModel, ActivityMainBinding>() {
    override fun initView(savedInstanceState: Bundle?) {

        mViewBind.btClick.setOnClickListener {
//            PicSelectUtils.checkPermission(this, PicSelectUtils.CHOOSE_PIC_TYPE_IS_GALLERY)
            Bus.post("hhh","")
        }

        Bus.observe<String>("hhh",this){
            showToast("萨卡刷卡看")
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.fetchApi()
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
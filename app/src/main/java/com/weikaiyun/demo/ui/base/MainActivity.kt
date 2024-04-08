package com.weikaiyun.demo.ui.base

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.weikaiyun.fragmentation.R
import lib.dc.fragmentation.SupportHelper
import com.weikaiyun.fragmentation.databinding.ActivityDemoMainBinding

class MainActivity : BaseBindingActivity<ActivityDemoMainBinding>() {

    val vm by lazy { ViewModelProvider(this)[MainVM::class.java] }

    override fun getContentLayoutId(): Int = R.layout.activity_demo_main

    override fun stateChangeLogic(event: Lifecycle.Event) {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initView(savedInstanceState: Bundle?) {
        var mainFragment = SupportHelper.findFragment(supportFragmentManager, DemoMainFragment::class.java)
        if (mainFragment == null) {
            mainFragment = DemoMainFragment.newInstance()
            loadRootFragment(R.id.container, mainFragment)
        }
    }
}

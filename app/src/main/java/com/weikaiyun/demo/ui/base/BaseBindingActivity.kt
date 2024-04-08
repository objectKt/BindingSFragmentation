package com.weikaiyun.demo.ui.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import lib.dc.fragmentation.SupportActivity

abstract class BaseBindingActivity<B : ViewBinding> : SupportActivity() {

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContentLayoutId())
        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                stateChangeLogic(event)
            }
        })
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    protected abstract fun stateChangeLogic(event: Lifecycle.Event)

    protected abstract fun initData(savedInstanceState: Bundle?)

    protected abstract fun initView(savedInstanceState: Bundle?)

    protected abstract fun getContentLayoutId(): Int
}

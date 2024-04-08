package com.weikaiyun.demo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import lib.dc.fragmentation.Fragmentation

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = this

        Fragmentation.builder() // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
            .stackViewMode(Fragmentation.BUBBLE)
            .debug(true) // 实际场景建议.debug(BuildConfig.DEBUG)
            .animation(
                lib.dc.R.anim.v_fragment_enter,
                lib.dc.R.anim.v_fragment_pop_exit,
                lib.dc.R.anim.v_fragment_pop_enter,
                lib.dc.R.anim.v_fragment_exit
            )
            .install()
    }

    @SuppressLint("StaticFieldLeak")
    companion object {
        @JvmStatic
        lateinit var context: Context

        @JvmStatic
        lateinit var instance: DemoApplication
    }
}
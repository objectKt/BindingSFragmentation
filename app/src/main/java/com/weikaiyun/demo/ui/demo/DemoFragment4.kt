package com.weikaiyun.demo.ui.demo

import android.os.Bundle
import android.view.View
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import lib.dc.fragmentation.fragmentargument.argument
import com.weikaiyun.fragmentation.R
import com.weikaiyun.fragmentation.databinding.FragmentDemo4Binding
import com.weikaiyun.util.trigger

class DemoFragment4: BaseBindingFragment<FragmentDemo4Binding>() {

    override fun getLayoutId(): Int = R.layout.fragment_demo4

    private var param1: Int by argument()
    private var param2: String by argument()
    private var param3: String by argument()
    private var param4: String by argument()

    companion object {
        fun newInstance(param1: Int, param2: String, param3: String, param4: String): DemoFragment4 =
            DemoFragment4().apply {
                this.param1 = param1
                this.param2 = param2
                this.param3 = param3
                this.param4 = param4
            }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "DemoFragment$param1"
        binding.button1.text = param2
        binding.button1.setOnClickListener {
            it.trigger(400) {
                // 参数 1 = 从这个页面干掉栈上所有页面，且回到这个页面的上一页
                // 页面栈 DemoFragment3 1 2 3 4 => 1 2
                // 页面栈 DemoFragment2 1 2 3 4 => 1
                // 页面栈 DemoFragment1 1 2 3 4 => main
                popTo(DemoFragment1::class.java, true)
            }
        }

        binding.button2.text = param3

        binding.button2.setOnClickListener {
            it.trigger(1000) {
                startWithPopTo(
                    // 干掉 1 页面栈上所有页面，保留 1 页面且前往 5 页面
                    // 页面栈 1 2 3 4 => 1 5
                    DemoFragment5.newInstance(5, "testStartWithPopTo"),
                    DemoFragment1::class.java, false)
            }
        }

        binding.button3.text = param4
        binding.button3.setOnClickListener {
            it.trigger(1000) {
                // 干掉当前页面 4 然后前往 5 页面
                // 页面栈 1 2 3 4 => 1 2 3 5
                startWithPop(DemoFragment5.newInstance(5, "testStartWithPop"))
            }
        }
    }

}
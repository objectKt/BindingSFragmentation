package com.weikaiyun.demo.ui.demo

import android.os.Bundle
import android.view.View
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import com.weikaiyun.fragmentargument.argument
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
//                extraTransaction()
//                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_pop_exit,
//                        R.anim.h_fragment_pop_enter, R.anim.h_fragment_exit)
//                    .popTo(DemoFragment1::class.java.name, false)
                popTo(DemoFragment1::class.java, true)
            }
        }

        binding.button2.text = param3

        binding.button2.setOnClickListener {
            it.trigger(1000) {
//                extraTransaction()
//                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_pop_exit,
//                        R.anim.h_fragment_pop_enter, R.anim.h_fragment_exit)
//                    .startWithPopTo(DemoFragment5.newInstance(5, "testStartWithPopTo"),
//                    DemoFragment1::class.java.name, false)
                startWithPopTo(
                    DemoFragment5.newInstance(5, "testStartWithPopTo"),
                    DemoFragment1::class.java, false)
            }
        }

        binding.button3.text = param4
        binding.button3.setOnClickListener {
            it.trigger(1000) {
//                extraTransaction()
//                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_pop_exit,
//                        R.anim.h_fragment_pop_enter, R.anim.h_fragment_exit)
//                    .startWithPop(DemoFragment5.newInstance(5, "testStartWithPop"))
                startWithPop(DemoFragment5.newInstance(5, "testStartWithPop"))
            }
        }
    }

}
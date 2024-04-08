package com.weikaiyun.demo.ui.demo

import android.os.Bundle
import android.view.View
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import lib.dc.fragmentation.fragmentargument.argument
import com.weikaiyun.fragmentation.R
import com.weikaiyun.fragmentation.databinding.FragmentDemoBinding
import com.weikaiyun.util.trigger

class DemoFragment3: BaseBindingFragment<FragmentDemoBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_demo

    private var param1: Int by argument()
    private var param2: String by argument()

    companion object {
        fun newInstance(param1: Int, param2: String): DemoFragment3 =
            DemoFragment3().apply {
                this.param1 = param1
                this.param2 = param2
            }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "DemoFragment$param1"
        binding.button.text = param2
        binding.button.setOnClickListener {
            it.trigger(400) {
//                extraTransaction()
//                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_pop_exit,
//                        R.anim.h_fragment_pop_enter, R.anim.h_fragment_exit)
//                    .start(DemoFragment4.newInstance(4, "popTo1", "start5WithPopTo1", "startWithPop"))
                start(DemoFragment4.newInstance(4, "popTo1", "start5WithPopTo1", "startWithPop"))
            }
        }
    }

}
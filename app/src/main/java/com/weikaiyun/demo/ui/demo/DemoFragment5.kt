package com.weikaiyun.demo.ui.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import lib.dc.fragmentation.fragmentargument.argument
import com.weikaiyun.fragmentation.R
import com.weikaiyun.fragmentation.databinding.FragmentDemoBinding

class DemoFragment5 : BaseBindingFragment<FragmentDemoBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_demo

    private var param1: Int by argument()
    private var param2: String by argument()

    companion object {
        fun newInstance(param1: Int, param2: String): DemoFragment5 =
            DemoFragment5().apply {
                this.param1 = param1
                this.param2 = param2
            }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        (view.findViewById<TextView>(R.id.title)).text = "DemoFragment$param1"
        binding.button.text = param2
    }
}
package com.weikaiyun.demo.ui.demo

import android.os.Bundle
import android.view.View
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import lib.dc.fragmentation.fragmentargument.argument
import com.weikaiyun.fragmentation.R
import com.weikaiyun.fragmentation.databinding.FragmentDemoBinding
import com.weikaiyun.util.trigger

class DemoFragment1 : BaseBindingFragment<FragmentDemoBinding>() {

    private var param1: Int by argument()
    private var param2: String by argument()

    override fun getLayoutId(): Int = R.layout.fragment_demo

    companion object {
        const val REQUEST_CODE = 100

        fun newInstance(param1: Int, param2: String): DemoFragment1 =
            DemoFragment1().apply {
                this.param1 = param1
                this.param2 = param2
            }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "DemoFragment$param1"
        binding.button.text = param2
        binding.button.setOnClickListener {
            // 带返回结果的start
            it.trigger(400) {
                startForResult(DemoFragment2.newInstance(2, "start3"), REQUEST_CODE)
            }
        }
    }

    //可见性判断
    override fun onInvisible() {

    }

    override fun onVisible() {

    }

    //懒加载
    override fun lazyInit() {

    }

    //返回处理结果
    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle?) {
        if (requestCode == REQUEST_CODE && resultCode == DemoFragment2.RESULT_CODE) {
            //处理返回结果
        }
    }
}
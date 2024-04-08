package com.weikaiyun.demo.ui.main

import android.os.Bundle
import android.view.View
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import com.weikaiyun.demo.ui.demo.DemoFragment1
import com.weikaiyun.fragmentation.R
import com.weikaiyun.fragmentation.databinding.FragmentHomeBinding

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.jump.setOnClickListener {
            //此处使用_mActivity.start, 则DemoFragment1与DemoMainFragment平级
            activity?.start(DemoFragment1.newInstance(1, "start2"))
        }
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}
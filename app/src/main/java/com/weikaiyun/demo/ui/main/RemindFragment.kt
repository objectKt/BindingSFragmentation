package com.weikaiyun.demo.ui.main

import com.weikaiyun.fragmentation.R
import com.weikaiyun.demo.ui.base.BaseSimpleFragment

class RemindFragment: BaseSimpleFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_remind

    companion object {
        fun newInstance(): RemindFragment = RemindFragment()
    }
}
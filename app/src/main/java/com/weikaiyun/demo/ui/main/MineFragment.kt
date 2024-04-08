package com.weikaiyun.demo.ui.main

import com.weikaiyun.fragmentation.R
import com.weikaiyun.demo.ui.base.BaseSimpleFragment

class MineFragment: BaseSimpleFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_mine

    companion object {
        fun newInstance(): MineFragment = MineFragment()
    }
}
package com.weikaiyun.demo.ui.main

import com.weikaiyun.fragmentation.R
import com.weikaiyun.demo.ui.base.BaseSimpleFragment

class CommunityFragment : BaseSimpleFragment() {

    override fun getLayoutId(): Int = R.layout.fragment_community

    companion object {
        fun newInstance(): CommunityFragment = CommunityFragment()
    }
}
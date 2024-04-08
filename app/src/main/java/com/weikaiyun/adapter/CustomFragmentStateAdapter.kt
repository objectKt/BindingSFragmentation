package com.weikaiyun.adapter

import androidx.viewpager2.adapter.FragmentStateAdapter
import lib.dc.fragmentation.SupportActivity
import lib.dc.fragmentation.SupportFragment

//适用viewpager2

class CustomFragmentStateAdapter(
    activity: SupportActivity,
    private val fragments: MutableList<SupportFragment>
) :
    FragmentStateAdapter(activity) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}
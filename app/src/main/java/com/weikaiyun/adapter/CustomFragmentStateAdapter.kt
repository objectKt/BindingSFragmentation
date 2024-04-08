package com.weikaiyun.adapter

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.weikaiyun.fragmentation.SupportActivity
import com.weikaiyun.fragmentation.SupportFragment

//适用viewpager2

class CustomFragmentStateAdapter(
    activity: SupportActivity,
    private val fragments: MutableList<SupportFragment>
) :
    FragmentStateAdapter(activity) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}
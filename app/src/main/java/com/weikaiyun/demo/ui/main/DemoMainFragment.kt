package com.weikaiyun.demo.ui.main

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import com.weikaiyun.demo.ui.base.BaseBindingFragment
import com.weikaiyun.fragmentation.R
import com.weikaiyun.fragmentation.SupportHelper
import com.weikaiyun.fragmentation.databinding.FragmentDemoMainBinding
import com.weikaiyun.util.ResUtils

class DemoMainFragment : BaseBindingFragment<FragmentDemoMainBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_demo_main

    private lateinit var homeFragment: HomeFragment
    private lateinit var remindFragment: RemindFragment
    private lateinit var communityFragment: CommunityFragment
    private lateinit var mineFragment: MineFragment

    private var currentTab = HOME

    private val iconArr = arrayListOf<Drawable>(
        ResUtils.getDrawable(R.drawable.icon_bottom_homepage),
        ResUtils.getDrawable(R.drawable.icon_bottom_remind),
        ResUtils.getDrawable(R.drawable.icon_bottom_community),
        ResUtils.getDrawable(R.drawable.icon_bottom_mine)
    )
    private val selectedIconArr = arrayListOf<Drawable>(
        ResUtils.getDrawable(R.drawable.icon_bottom_homepage_selected),
        ResUtils.getDrawable(R.drawable.icon_bottom_remind_selected),
        ResUtils.getDrawable(R.drawable.icon_bottom_community_selected),
        ResUtils.getDrawable(R.drawable.icon_bottom_mine_selected)
    )

    private val textColor = ResUtils.getColor(R.color.color_normal)

    private val selectedTextColor = ResUtils.getColor(R.color.color_selected)

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.flContainer.setOnClickListener {
            _mActivity.finish()
        }
        val homeFragmentInStack: HomeFragment? =
            SupportHelper.findFragment(childFragmentManager, HomeFragment::class.java)
        if (homeFragmentInStack != null) {
            homeFragment = homeFragmentInStack
            remindFragment =
                SupportHelper.findFragment(childFragmentManager, RemindFragment::class.java)
            communityFragment =
                SupportHelper.findFragment(childFragmentManager, CommunityFragment::class.java)
            mineFragment =
                SupportHelper.findFragment(childFragmentManager, MineFragment::class.java)
        } else {
            homeFragment = HomeFragment()
            remindFragment = RemindFragment()
            communityFragment = CommunityFragment()
            mineFragment = MineFragment()
            loadMultipleRootFragment(
                R.id.fl_container,
                currentTab,
                homeFragment,
                remindFragment,
                communityFragment,
                mineFragment
            )
        }

        binding.clHome.setOnClickListener {
            if (currentTab != HOME) {
                showHideFragment(homeFragment)
                checkTab(HOME)
            }
        }

        binding.clRemind.setOnClickListener {
            if (currentTab != REMIND) {
                showHideFragment(remindFragment)
                checkTab(REMIND)
            }
        }

        binding.clCommunity.setOnClickListener {
            if (currentTab != COMMUNITY) {
                showHideFragment(communityFragment)
                checkTab(COMMUNITY)
            }
        }

        binding.clMine.setOnClickListener {
            if (currentTab != MINE) {
                showHideFragment(mineFragment)
                checkTab(MINE)
            }
        }

        checkTab(HOME)
    }

    private fun checkTab(tab: Int) {
        currentTab = tab
        with(binding) {
            when (currentTab) {
                HOME -> {
                    imgHome.setImageDrawable(selectedIconArr[HOME])
                    tvHome.setTextColor(selectedTextColor)
                    imgRemind.setImageDrawable(iconArr[REMIND])
                    tvRemind.setTextColor(textColor)
                    imgCommunity.setImageDrawable(iconArr[COMMUNITY])
                    tvCommunity.setTextColor(textColor)
                    imgMine.setImageDrawable(iconArr[MINE])
                    tvMine.setTextColor(textColor)
                }

                REMIND -> {
                    imgHome.setImageDrawable(iconArr[HOME])
                    tvHome.setTextColor(textColor)
                    imgRemind.setImageDrawable(selectedIconArr[REMIND])
                    tvRemind.setTextColor(selectedTextColor)
                    imgCommunity.setImageDrawable(iconArr[COMMUNITY])
                    tvCommunity.setTextColor(textColor)
                    imgMine.setImageDrawable(iconArr[MINE])
                    tvMine.setTextColor(textColor)
                }

                COMMUNITY -> {
                    imgHome.setImageDrawable(iconArr[HOME])
                    tvHome.setTextColor(textColor)
                    imgRemind.setImageDrawable(iconArr[REMIND])
                    tvRemind.setTextColor(textColor)
                    imgCommunity.setImageDrawable(selectedIconArr[COMMUNITY])
                    tvCommunity.setTextColor(selectedTextColor)
                    imgMine.setImageDrawable(iconArr[MINE])
                    tvMine.setTextColor(textColor)
                }

                MINE -> {
                    imgHome.setImageDrawable(iconArr[HOME])
                    tvHome.setTextColor(textColor)
                    imgRemind.setImageDrawable(iconArr[REMIND])
                    tvRemind.setTextColor(textColor)
                    imgCommunity.setImageDrawable(iconArr[COMMUNITY])
                    tvCommunity.setTextColor(textColor)
                    imgMine.setImageDrawable(selectedIconArr[MINE])
                    tvMine.setTextColor(selectedTextColor)
                }
            }
        }
    }

    companion object {
        const val HOME = 0
        const val REMIND = 1
        const val COMMUNITY = 2
        const val MINE = 3

        @JvmStatic
        fun newInstance(): DemoMainFragment {
            return DemoMainFragment()
        }
    }
}
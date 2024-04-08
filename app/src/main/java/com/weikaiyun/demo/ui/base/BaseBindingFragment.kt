package com.weikaiyun.demo.ui.base;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import lib.dc.fragmentation.SupportFragment

abstract class BaseBindingFragment<B : ViewDataBinding> : SupportFragment(), OnClickListener {

    private val activity: MainActivity? by lazy { requireActivity() as MainActivity }
    val vm: MainVM? by lazy { activity?.vm }

    val binding: B
        get() {
            return DataBindingUtil.bind(requireView())!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    override fun onClick(v: View) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<B>(view)
        initView(view, savedInstanceState)
    }

    abstract fun initView(view: View, savedInstanceState: Bundle?)
}
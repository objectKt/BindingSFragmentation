package com.weikaiyun.demo.ui.base

import android.app.Application
import android.content.res.Resources
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel

/**
 * 逻辑操作尽量放在 ViewModel ，避免内存泄漏的过失
 */
class MainVM(application: Application) : AndroidViewModel(application) {

    val resources: Resources get() = context.resources

    private val context = application

    fun getString(resId: Int): String {
        return resources.getString(resId)
    }

    /**
     * 数据回收
     */
    fun cleanActivityThings() {
        Toast.makeText(context, "点击了屏幕", Toast.LENGTH_SHORT).show()
    }
}
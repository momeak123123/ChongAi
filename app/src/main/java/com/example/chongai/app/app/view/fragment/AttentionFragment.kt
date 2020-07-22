package com.example.chongai.app.app.view.fragment

import android.os.Bundle
import com.example.chongai.app.R
import com.example.chongai.app.app.contract.AttentionContract
import com.example.chongai.app.app.presenter.AttentionPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class AttentionFragment : BaseMvpFragment<AttentionContract.IPresenter>(), AttentionContract.IView {

    companion object {
        fun newInstance(): AttentionFragment? {
            val args = Bundle()
            val fragment = AttentionFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun registerPresenter() = AttentionPresenter::class.java

    override fun getLayoutId(): Int {
       return R.layout.home_attention
    }


}

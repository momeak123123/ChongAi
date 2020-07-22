package com.example.chongai.app.app.view.fragment

import android.os.Bundle
import com.example.chongai.app.R
import com.example.chongai.app.app.contract.InquiryContract
import com.example.chongai.app.app.presenter.InquiryPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class InquiryFragment : BaseMvpFragment<InquiryContract.IPresenter>(), InquiryContract.IView {

    companion object {
        fun newInstance(): InquiryFragment? {
            val args = Bundle()
            val fragment = InquiryFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun registerPresenter() = InquiryPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.home_inquiry
    }
}

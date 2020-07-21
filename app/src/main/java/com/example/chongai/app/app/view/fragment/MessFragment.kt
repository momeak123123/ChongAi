package com.example.chongai.app.app.view.fragment

import com.example.chongai.app.app.contract.MessContract
import com.example.chongai.app.app.presenter.MessPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MessFragment : BaseMvpFragment<MessContract.IPresenter>(), MessContract.IView {

    override fun registerPresenter() = MessPresenter::class.java

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

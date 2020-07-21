package com.example.chongai.app.app.view.fragment

import com.example.chongai.app.app.contract.HomeContract
import com.example.chongai.app.app.presenter.HomePresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class HomeFragment : BaseMvpFragment<HomeContract.IPresenter>(), HomeContract.IView {

    override fun registerPresenter() = HomePresenter::class.java

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

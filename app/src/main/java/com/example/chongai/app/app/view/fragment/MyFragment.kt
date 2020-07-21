package com.example.chongai.app.app.view.fragment

import com.example.chongai.app.app.contract.MyContract
import com.example.chongai.app.app.presenter.MyPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MyFragment : BaseMvpFragment<MyContract.IPresenter>(), MyContract.IView {

    override fun registerPresenter() = MyPresenter::class.java

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

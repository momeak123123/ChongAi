package com.example.chongai.app.app.view.fragment

import com.example.chongai.app.R
import com.example.chongai.app.app.contract.NearbyContract
import com.example.chongai.app.app.presenter.NearbyPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class NearbyFragment : BaseMvpFragment<NearbyContract.IPresenter>(), NearbyContract.IView {

    override fun registerPresenter() = NearbyPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_nearby
    }
}

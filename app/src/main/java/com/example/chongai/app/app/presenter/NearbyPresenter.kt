package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.NearbyContract
import com.example.chongai.app.app.model.NearbyModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class NearbyPresenter : BaseMvpPresenter<NearbyContract.IView, NearbyContract.IModel>(), NearbyContract.IPresenter{

    override fun registerModel() = NearbyModel::class.java

}

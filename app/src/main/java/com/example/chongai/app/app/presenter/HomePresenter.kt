package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.HomeContract
import com.example.chongai.app.app.model.HomeModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class HomePresenter : BaseMvpPresenter<HomeContract.IView, HomeContract.IModel>(), HomeContract.IPresenter{

    override fun registerModel() = HomeModel::class.java

}

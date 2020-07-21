package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.MessContract
import com.example.chongai.app.app.model.MessModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MessPresenter : BaseMvpPresenter<MessContract.IView, MessContract.IModel>(), MessContract.IPresenter{

    override fun registerModel() = MessModel::class.java

}

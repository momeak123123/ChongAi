package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.DynamicContract
import com.example.chongai.app.app.model.DynamicModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/23
 * @Description input description
 **/
class DynamicPresenter : BaseMvpPresenter<DynamicContract.IView, DynamicContract.IModel>(), DynamicContract.IPresenter{

    override fun registerModel() = DynamicModel::class.java

}

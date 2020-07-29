package com.ch.wu.app.app.presenter

import android.content.Context
import com.ch.wu.app.app.contract.DynamicContract
import com.ch.wu.app.app.model.DynamicModel
import mvp.ljb.kt.presenter.BaseMvpPresenter

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/23
 * @Description input description
 **/
class DynamicPresenter : BaseMvpPresenter<DynamicContract.IView, DynamicContract.IModel>(), DynamicContract.IPresenter{

    override fun registerModel() = DynamicModel::class.java
    override fun comment(context: Context) {
        getModel().comment(context)
    }

}

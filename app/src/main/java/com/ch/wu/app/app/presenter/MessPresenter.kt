package com.ch.wu.app.app.presenter

import android.content.Context
import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.ch.wu.app.app.contract.MessContract
import com.ch.wu.app.app.model.MessModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MessPresenter : BaseMvpPresenter<MessContract.IView, MessContract.IModel>(), MessContract.IPresenter{

    override fun registerModel() = MessModel::class.java
    override fun noticelist(context: Context) {
        getModel().noticelist(context)
    }

}

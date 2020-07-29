package com.ch.wu.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.ch.wu.app.app.contract.AttentionContract
import com.ch.wu.app.app.model.AttentionModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class AttentionPresenter : BaseMvpPresenter<AttentionContract.IView, AttentionContract.IModel>(), AttentionContract.IPresenter{

    override fun registerModel() = AttentionModel::class.java

}

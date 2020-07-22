package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.AttentionContract
import com.example.chongai.app.app.model.AttentionModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class AttentionPresenter : BaseMvpPresenter<AttentionContract.IView, AttentionContract.IModel>(), AttentionContract.IPresenter{

    override fun registerModel() = AttentionModel::class.java

}

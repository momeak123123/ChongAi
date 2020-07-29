package com.ch.wu.app.app.presenter

import android.content.Context
import com.ch.wu.app.app.contract.RecommendContract
import com.ch.wu.app.app.model.RecommendModel
import com.ch.wu.app.bean.Dynamic
import mvp.ljb.kt.presenter.BaseMvpPresenter

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendPresenter : BaseMvpPresenter<RecommendContract.IView, RecommendContract.IModel>(), RecommendContract.IPresenter{

    override fun registerModel() = RecommendModel::class.java

    override fun banner(context: Context) {
        return getModel().banner(context)
    }

    override fun list(context: Context) {
        return getModel().list(context)
    }
}

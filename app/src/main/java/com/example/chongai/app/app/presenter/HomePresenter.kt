package com.example.chongai.app.app.presenter

import android.content.Context
import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.HomeContract
import com.example.chongai.app.app.model.HomeModel
import com.example.chongai.app.bean.Nav

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class HomePresenter : BaseMvpPresenter<HomeContract.IView, HomeContract.IModel>(), HomeContract.IPresenter{

    override fun registerModel() = HomeModel::class.java
    override fun banner(context: Context): MutableList<String> {
        return getModel().banner(context)
    }

    override fun tran(context: Context): MutableList<Nav> {
        return getModel().tran(context)
    }

}

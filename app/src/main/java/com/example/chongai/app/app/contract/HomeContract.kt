package com.example.chongai.app.app.contract

import android.content.Context
import com.example.chongai.app.bean.Nav
import mvp.ljb.kt.contract.IModelContract
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
interface HomeContract {

    interface IView : IViewContract {

    }

    interface IPresenter : IPresenterContract {
        fun banner(context: Context): MutableList<String>
        fun tran(context: Context): MutableList<Nav>
    }

    interface IModel : IModelContract{
        fun banner(context: Context): MutableList<String>
        fun tran(context: Context): MutableList<Nav>
    }
}

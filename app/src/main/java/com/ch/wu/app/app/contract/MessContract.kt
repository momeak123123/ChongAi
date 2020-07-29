package com.ch.wu.app.app.contract

import android.content.Context
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract
import mvp.ljb.kt.contract.IModelContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
interface MessContract {

    interface IView : IViewContract

    interface IPresenter : IPresenterContract {
        fun noticelist(context: Context)
    }

    interface IModel : IModelContract{
        fun noticelist(context: Context)
    }

}

package com.ch.wu.app.app.contract

import android.content.Context
import mvp.ljb.kt.contract.IModelContract
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/23
 * @Description input description
 **/
interface DynamicContract {

    interface IView : IViewContract {

    }

    interface IPresenter : IPresenterContract {
        fun comment(context: Context)
    }

    interface IModel : IModelContract{
        fun comment(context: Context)
    }
}

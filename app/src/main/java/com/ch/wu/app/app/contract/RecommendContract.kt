package com.ch.wu.app.app.contract

import android.content.Context
import com.ch.wu.app.bean.Dynamic
import mvp.ljb.kt.contract.IModelContract
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
interface RecommendContract {

    interface IView : IViewContract

    interface IPresenter : IPresenterContract {
        fun banner(context: Context)
        fun list(context: Context)
    }

    interface IModel : IModelContract{
        fun banner(context: Context)
        fun list(context: Context)
    }
}

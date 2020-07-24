package com.example.chongai.app.app.contract

import android.content.Context
import com.example.chongai.app.bean.CustomBean
import com.example.chongai.app.bean.Dynamic
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
        fun banner(context: Context): MutableList<String>
        fun list(context: Context): MutableList<Dynamic>
    }

    interface IModel : IModelContract{
        fun banner(context: Context): MutableList<String>
        fun list(context: Context): MutableList<Dynamic>
    }
}

package com.example.chongai.app.app.contract

import android.content.Context
import com.example.chongai.app.bean.Recommend
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract
import mvp.ljb.kt.contract.IModelContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
interface RecommendContract {

    interface IView : IViewContract

    interface IPresenter : IPresenterContract {
        fun banner(context: Context): MutableList<BannerItem>
        fun list(context: Context): MutableList<Recommend>
    }

    interface IModel : IModelContract{
        fun banner(context: Context): MutableList<BannerItem>
        fun list(context: Context): MutableList<Recommend>
    }
}

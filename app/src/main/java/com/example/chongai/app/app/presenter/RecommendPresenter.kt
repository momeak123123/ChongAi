package com.example.chongai.app.app.presenter

import android.content.Context
import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.RecommendContract
import com.example.chongai.app.app.model.RecommendModel
import com.example.chongai.app.bean.Recommend
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendPresenter : BaseMvpPresenter<RecommendContract.IView, RecommendContract.IModel>(), RecommendContract.IPresenter{

    override fun registerModel() = RecommendModel::class.java

    override fun banner(context: Context): MutableList<BannerItem> {
        return getModel().banner(context)
    }

    override fun list(context: Context): MutableList<Recommend> {
        return getModel().list(context)
    }
}

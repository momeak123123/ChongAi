package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.StoryContract
import com.example.chongai.app.app.model.StoryModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class StoryPresenter : BaseMvpPresenter<StoryContract.IView, StoryContract.IModel>(), StoryContract.IPresenter{

    override fun registerModel() = StoryModel::class.java

}

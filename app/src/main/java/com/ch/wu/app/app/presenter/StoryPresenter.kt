package com.ch.wu.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.ch.wu.app.app.contract.StoryContract
import com.ch.wu.app.app.model.StoryModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class StoryPresenter : BaseMvpPresenter<StoryContract.IView, StoryContract.IModel>(), StoryContract.IPresenter{

    override fun registerModel() = StoryModel::class.java

}

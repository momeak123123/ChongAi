package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.MyContract
import com.example.chongai.app.app.model.MyModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MyPresenter : BaseMvpPresenter<MyContract.IView, MyContract.IModel>(), MyContract.IPresenter{

    override fun registerModel() = MyModel::class.java

}

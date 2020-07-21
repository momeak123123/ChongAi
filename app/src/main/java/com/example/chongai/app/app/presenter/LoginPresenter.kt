package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.LoginContract
import com.example.chongai.app.app.model.LoginModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class LoginPresenter : BaseMvpPresenter<LoginContract.IView, LoginContract.IModel>(), LoginContract.IPresenter{

    override fun registerModel() = LoginModel::class.java

}

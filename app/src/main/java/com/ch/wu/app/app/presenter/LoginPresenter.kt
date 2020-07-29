package com.ch.wu.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.ch.wu.app.app.contract.LoginContract
import com.ch.wu.app.app.model.LoginModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class LoginPresenter : BaseMvpPresenter<LoginContract.IView, LoginContract.IModel>(), LoginContract.IPresenter{

    override fun registerModel() = LoginModel::class.java

}

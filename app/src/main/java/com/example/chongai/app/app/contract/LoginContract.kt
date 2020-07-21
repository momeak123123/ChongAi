package com.example.chongai.app.app.contract

import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract
import mvp.ljb.kt.contract.IModelContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
interface LoginContract {

    interface IView : IViewContract

    interface IPresenter : IPresenterContract

    interface IModel : IModelContract
}

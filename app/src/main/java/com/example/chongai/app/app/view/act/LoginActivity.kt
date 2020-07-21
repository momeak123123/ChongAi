package com.example.chongai.app.app.view.act

import com.example.chongai.app.app.contract.LoginContract
import com.example.chongai.app.app.presenter.LoginPresenter
import mvp.ljb.kt.act.BaseMvpActivity

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class LoginActivity : BaseMvpActivity<LoginContract.IPresenter>() , LoginContract.IView {

    override fun registerPresenter() = LoginPresenter::class.java

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

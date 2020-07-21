package com.example.chongai.app.app.view.act

import android.content.Context
import android.os.Bundle
import com.example.chongai.app.R
import com.example.chongai.app.app.contract.LoginContract
import com.example.chongai.app.app.presenter.LoginPresenter
import mvp.ljb.kt.act.BaseMvpActivity


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class LoginActivity() : BaseMvpActivity<LoginContract.IPresenter>() , LoginContract.IView {

    private lateinit var context: Context

    override fun registerPresenter() = LoginPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        context = this
    }

    override fun initData() {
        super.initData()

    }

    override fun initView() {
        super.initView()
    }

    override fun onResume() {
        super.onResume()


    }

}

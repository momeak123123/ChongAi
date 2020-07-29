package com.ch.wu.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.ch.wu.app.app.contract.InquiryContract
import com.ch.wu.app.app.model.InquiryModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class InquiryPresenter : BaseMvpPresenter<InquiryContract.IView, InquiryContract.IModel>(), InquiryContract.IPresenter{

    override fun registerModel() = InquiryModel::class.java

}

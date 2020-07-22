package com.example.chongai.app.app.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.chongai.app.app.contract.InquiryContract
import com.example.chongai.app.app.model.InquiryModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class InquiryPresenter : BaseMvpPresenter<InquiryContract.IView, InquiryContract.IModel>(), InquiryContract.IPresenter{

    override fun registerModel() = InquiryModel::class.java

}

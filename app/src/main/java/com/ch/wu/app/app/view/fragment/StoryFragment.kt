package com.ch.wu.app.app.view.fragment

import android.os.Bundle
import com.ch.wu.app.R
import com.ch.wu.app.app.contract.StoryContract
import com.ch.wu.app.app.presenter.StoryPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class StoryFragment : BaseMvpFragment<StoryContract.IPresenter>(), StoryContract.IView {

    companion object {

    }

    override fun registerPresenter() = StoryPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.home_story
    }
}

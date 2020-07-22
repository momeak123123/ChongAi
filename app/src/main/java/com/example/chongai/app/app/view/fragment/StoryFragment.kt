package com.example.chongai.app.app.view.fragment

import android.os.Bundle
import com.example.chongai.app.R
import com.example.chongai.app.app.contract.StoryContract
import com.example.chongai.app.app.presenter.StoryPresenter
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class StoryFragment : BaseMvpFragment<StoryContract.IPresenter>(), StoryContract.IView {

    companion object {
        fun newInstance(): StoryFragment? {
            val args = Bundle()
            val fragment = StoryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun registerPresenter() = StoryPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.home_story
    }
}

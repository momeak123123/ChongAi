package com.example.chongai.app.app.view.fragment

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.chongai.app.R
import com.example.chongai.app.app.contract.HomeContract
import com.example.chongai.app.app.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import mvp.ljb.kt.fragment.BaseMvpFragment


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class HomeFragment : BaseMvpFragment<HomeContract.IPresenter>(), HomeContract.IView {

    override fun registerPresenter() = HomePresenter::class.java
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
    }

    override fun initData() {
        super.initData()


    }

    override fun initView() {
        super.initView()

        mContentBanner.setData(
            listOf("网络图片路径1", "网络图片路径2", "网络图片路径3"),
            listOf("", "", "")
        )

        mContentBanner.setAdapter{ banner, itemView, model, position ->
               /* Glide.with(requireActivity())
                    .load(model)
                    .placeholder(R.drawable.holder)
                    .error(R.drawable.holder)
                    .centerCrop()
                    .dontAnimate()
                    .into(itemView)*/
        }



        mContentBanner.setDelegate { banner, itemView, model, position ->
            Toast.makeText(
                banner.context,
                "点击了$position",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onResume() {
        super.onResume()


    }
}



package com.example.chongai.app.app.view.act

import android.R.attr.banner
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.chongai.app.R
import com.example.chongai.app.adapter.DynamicAdapter
import com.example.chongai.app.adapter.RecommendAdapter
import com.example.chongai.app.app.contract.DynamicContract
import com.example.chongai.app.app.presenter.DynamicPresenter
import com.example.chongai.app.bean.Comment
import com.example.chongai.app.bean.Dynamic
import com.example.chongai.app.view.FigureIndicatorView
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.zhpan.indicator.base.IIndicator
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_dynamic.*
import kotlinx.android.synthetic.main.home_recommend.*
import mvp.ljb.kt.act.BaseMvpActivity


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/23
 * @Description input description
 **/
class DynamicActivity : BaseMvpActivity<DynamicContract.IPresenter>() , DynamicContract.IView {

    companion object {
        lateinit var observer: Observer<Boolean>
    }
    override fun registerPresenter() = DynamicPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_dynamic
    }


    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)

    }

    override fun initData() {
        super.initData()

    }

    override fun initView() {
        super.initView()

    }

    override fun onResume() {
        super.onResume()
        observer = object : Observer<Boolean> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(data: Boolean) {
                if (data) {
                    finish()
                }
            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {
            }

        }
    }

    /**
     * 初始化列表
     */
    private fun initSongList(list: MutableList<Comment>, data:Dynamic) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyc_item.isNestedScrollingEnabled = false
        recyc_item.layoutManager = layoutManager
        recyc_item.itemAnimator = DefaultItemAnimator()
        recyc_item.setHasFixedSize(true)
        val adapter = DynamicAdapter(list,this,data)
        recyc_item.adapter = adapter
        adapter.setOnItemClickListener(object : DynamicAdapter.ItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                if (position > 0) {

                }

            }
        })


    }
}

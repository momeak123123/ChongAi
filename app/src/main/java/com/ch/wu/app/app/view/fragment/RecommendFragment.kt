package com.ch.wu.app.app.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.ch.wu.app.R
import com.ch.wu.app.adapter.RecommendAdapter
import com.ch.wu.app.app.contract.RecommendContract
import com.ch.wu.app.app.presenter.RecommendPresenter
import com.ch.wu.app.app.view.act.DynamicActivity
import com.ch.wu.app.bean.Dynamic
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.home_recommend.*
import mvp.ljb.kt.fragment.BaseMvpFragment
import java.util.*


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendFragment : BaseMvpFragment<RecommendContract.IPresenter>(), RecommendContract.IView {

    companion object {
        lateinit var observer: Observer<MutableList<String>>
        lateinit var observers: Observer<MutableList<Dynamic>>
    }

    override fun registerPresenter() = RecommendPresenter::class.java
    var list = mutableListOf<Dynamic>()
    override fun getLayoutId(): Int {
        return R.layout.home_recommend
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)

    }

    override fun initData() {
        super.initData()

        observer = object : Observer<MutableList<String>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(data: MutableList<String>) {
                if (data.size>0) {
                    mContentBanner.setAdapter { banner, itemView, model, position ->
                        context?.let {
                            Glide.with(it)
                                .load(model)
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.placeholder)
                                .centerCrop()
                                .dontAnimate()
                                .into(itemView as ImageView)
                        }
                    }

                    mContentBanner.setData(
                        data,
                        listOf("", "", "")
                    )
                }
            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {
            }

        }

        observers = object : Observer<MutableList<Dynamic>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(data: MutableList<Dynamic>) {
                if (data.size > 0) {
                    list.clear()
                    list = data
                    val det = Dynamic(0, "", "", "", 0, "", "", "")
                    list.add(0, det)
                    initSongList(list)
                }

                if (swipe_refresh_layout != null) {
                    swipe_refresh_layout.isRefreshing = false
                }
            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {
            }

        }

        swipe_refresh_layout.isRefreshing = true
        context?.let { getPresenter().banner(it) }
    }

    override fun onResume() {
        super.onResume()

        context?.let { getPresenter().list(it) }

    }


    override fun initView() {
        super.initView()
        swipe_refresh_layout.setColorSchemeColors(-0xff6634, -0xbbbc, -0x996700, -0x559934, -0x7800)
        //下拉刷新
        swipe_refresh_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { context?.let { getPresenter().list(it) } })



    }

    /**
     * 初始化列表
     */
    private fun initSongList(list: MutableList<Dynamic>) {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyc_item.isNestedScrollingEnabled = false
        recyc_item.layoutManager = layoutManager
        recyc_item.itemAnimator = DefaultItemAnimator()
        recyc_item.setHasFixedSize(true)
        val adapter = RecommendAdapter(list, requireContext())
        recyc_item.adapter = adapter
        adapter.setOnItemClickListener(object : RecommendAdapter.ItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                if (position > 0) {
                    val intent = Intent()
                    intent.setClass(requireContext(), DynamicActivity().javaClass)
                    intent.putExtra("dynamic", list[position])
                    startActivity(intent)
                }

            }
        })


    }
}

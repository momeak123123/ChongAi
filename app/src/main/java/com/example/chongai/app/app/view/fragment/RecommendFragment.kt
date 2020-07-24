package com.example.chongai.app.app.view.fragment

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.request.RequestOptions
import com.example.chongai.app.R
import com.example.chongai.app.adapter.RecommendAdapter
import com.example.chongai.app.app.contract.RecommendContract
import com.example.chongai.app.app.presenter.RecommendPresenter
import com.example.chongai.app.app.view.act.DynamicActivity
import com.example.chongai.app.bean.CustomBean
import com.example.chongai.app.bean.Dynamic
import com.google.gson.Gson
import kotlinx.android.synthetic.main.home_recommend.*
import mvp.ljb.kt.fragment.BaseMvpFragment


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendFragment : BaseMvpFragment<RecommendContract.IPresenter>(), RecommendContract.IView {

    override fun registerPresenter() = RecommendPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.home_recommend
    }

    override fun initData() {
        super.initData()
        swipe_refresh_layout.isRefreshing = true
        loadData()
    }

    fun loadData() {
        val data = context?.let { getPresenter().banner(it) }
        val list = context?.let { getPresenter().list(it) }
        if (data != null) {
            if (list != null) {
                initSongList(list, data)
                if (swipe_refresh_layout != null) {
                    swipe_refresh_layout.isRefreshing = false
                }
            }
        }
    }

    override fun initView() {
        super.initView()
        swipe_refresh_layout.setColorSchemeColors(-0xff6634, -0xbbbc, -0x996700, -0x559934, -0x7800)
        //下拉刷新
        swipe_refresh_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { loadData() })

    }

    /**
     * 初始化列表
     */
    private fun initSongList(list: MutableList<Dynamic>, data: MutableList<String>) {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyc_item.isNestedScrollingEnabled = false
        recyc_item.layoutManager = layoutManager
        recyc_item.itemAnimator = DefaultItemAnimator()
        recyc_item.setHasFixedSize(true)
        val adapter = RecommendAdapter(list, requireContext(), data)
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

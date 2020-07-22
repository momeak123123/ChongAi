package com.example.chongai.app.app.view.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chongai.app.R
import com.example.chongai.app.adapter.HomeAdapter
import com.example.chongai.app.adapter.RecommendAdapter
import com.example.chongai.app.app.contract.RecommendContract
import com.example.chongai.app.app.presenter.RecommendPresenter
import com.example.chongai.app.bean.Recommend
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem
import kotlinx.android.synthetic.main.fragment_recommend.*
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendFragment : BaseMvpFragment<RecommendContract.IPresenter>(), RecommendContract.IView {

    override fun registerPresenter() = RecommendPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_recommend
    }

    override fun initData() {
        super.initData()

        val data = context?.let { getPresenter().banner(it) }
        val list = context?.let { getPresenter().list(it) }
        if (data != null) {
            if (list != null) {
                initSongList(list,data)
            }
        }
    }

    override fun initView() {
        super.initView()
    }

    /**
     * 初始化列表
     */
    private fun initSongList(list: MutableList<Recommend>, data:MutableList<BannerItem>) {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyc_item.isNestedScrollingEnabled = false
        recyc_item.layoutManager = layoutManager
        recyc_item.itemAnimator = DefaultItemAnimator()
        recyc_item.setHasFixedSize(true)
        val adapter = RecommendAdapter(list,requireContext(),data)
        recyc_item.adapter = adapter
        adapter.setOnItemClickListener(object : RecommendAdapter.ItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                if (position > 0) {

                }

            }
        })
    }
}

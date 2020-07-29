package com.ch.wu.app.app.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ch.wu.app.R
import com.ch.wu.app.adapter.MessAdapter
import com.ch.wu.app.adapter.RecommendAdapter
import com.ch.wu.app.app.contract.MessContract
import com.ch.wu.app.app.presenter.MessPresenter
import com.ch.wu.app.app.view.act.DynamicActivity
import com.ch.wu.app.bean.Dynamic
import com.ch.wu.app.bean.Notice
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_mess.*
import kotlinx.android.synthetic.main.home_recommend.*
import mvp.ljb.kt.fragment.BaseMvpFragment

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MessFragment : BaseMvpFragment<MessContract.IPresenter>(), MessContract.IView {

    companion object {
        lateinit var observer: Observer<MutableList<Notice>>
    }
    override fun registerPresenter() = MessPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.fragment_mess
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
    }

    override fun initData() {
        super.initData()

        observer = object : Observer<MutableList<Notice>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(data: MutableList<Notice>) {
                if (data.size>0) {
                    initSongList(data)
                }
            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {
            }

        }

        context?.let { getPresenter().noticelist(it) }


    }

    override fun initView() {
        super.initView()

    }

    override fun onResume() {
        super.onResume()


    }

    /**
     * 初始化列表
     */
    private fun initSongList(list: MutableList<Notice>) {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        noticerecycler.isNestedScrollingEnabled = false
        noticerecycler.layoutManager = layoutManager
        noticerecycler.itemAnimator = DefaultItemAnimator()
        noticerecycler.setHasFixedSize(true)
        val adapter = MessAdapter(list, requireContext())
        noticerecycler.adapter = adapter
        adapter.setOnItemClickListener(object : MessAdapter.ItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                if (position > 0) {
                    val intent = Intent()
                    intent.setClass(requireContext(), DynamicActivity().javaClass)
                    intent.putExtra("id", list[position].notice_id)
                    startActivity(intent)
                }

            }
        })


    }
}

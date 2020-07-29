package com.ch.wu.app.app.view.act

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ch.wu.app.R
import com.ch.wu.app.adapter.DynamicAdapter
import com.ch.wu.app.app.contract.DynamicContract
import com.ch.wu.app.app.presenter.DynamicPresenter
import com.ch.wu.app.bean.Comment
import com.ch.wu.app.bean.Dynamic
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_dynamic.*
import mvp.ljb.kt.act.BaseMvpActivity


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/23
 * @Description input description
 **/
class DynamicActivity : BaseMvpActivity<DynamicContract.IPresenter>(), DynamicContract.IView {

    private lateinit var data: Dynamic

    companion object {
        lateinit var observer: Observer<Boolean>
        lateinit var observers: Observer<MutableList<Comment>>
    }

    lateinit var context: Context
    var comm = mutableListOf<Comment>()
    override fun registerPresenter() = DynamicPresenter::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_dynamic
    }


    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        val window = window
        window.clearFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT

        val bundle = intent.extras
        data = bundle?.get("dynamic") as Dynamic
        context = this
        initCommentList(comm)
    }

    override fun initData() {
        super.initData()

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

        observers = object : Observer<MutableList<Comment>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(data: MutableList<Comment>) {
                if (data.size > 0) {
                    comm.clear()
                    comm = data
                    val det = Comment(0, "", "", "", "", "", "",0)
                    comm.add(0, det)
                    initCommentList(comm)
                } else {
                    comm.clear()
                    val det = Comment(0, "", "", "", "", "", "",0)
                    comm.add(0, det)
                    initCommentList(comm)
                }
            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {
            }

        }

        getPresenter().comment(context)
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
    private fun initCommentList(list: MutableList<Comment>) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        dynamic.isNestedScrollingEnabled = false
        dynamic.layoutManager = layoutManager
        dynamic.itemAnimator = DefaultItemAnimator()
        dynamic.setHasFixedSize(true)
        val adapter = DynamicAdapter(list, this, data)
        dynamic.adapter = adapter
        adapter.setOnItemClickListener(object : DynamicAdapter.ItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                if (position > 0) {

                }

            }
        })


    }
}

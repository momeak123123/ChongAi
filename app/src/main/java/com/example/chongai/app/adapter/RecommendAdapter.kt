package com.example.chongai.app.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chongai.app.R
import com.example.chongai.app.bean.Recommend
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner
import com.xuexiang.xui.widget.banner.widget.banner.base.BaseBanner
import com.xuexiang.xui.widget.imageview.RadiusImageView

class RecommendAdapter(
    val datas: MutableList<Recommend>,
    val context: Context,
    val data:MutableList<BannerItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_SELLER = 1
    }

    private var mItemClickListener: ItemClickListener? = null


    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_TITLE
        } else {
            TYPE_SELLER
        }
    }

    /**
     * 相当于getView()
     */
    override fun onCreateViewHolder(holder: ViewGroup, position: Int): RecyclerView.ViewHolder {
        //加载View
        return when (position) {
            TYPE_TITLE -> TitleHolder(
                LayoutInflater.from(context).inflate(R.layout.home_header, holder, false)
            )
            TYPE_SELLER -> SellerHolder(
                LayoutInflater.from(context).inflate(R.layout.home_item, holder, false)
            )
            else -> TitleHolder(
                LayoutInflater.from(context).inflate(R.layout.home_header, holder, false)
            )
        }

    }

    /**
     * 得到总条数
     */
    override fun getItemCount(): Int {

        return datas.size

    }


    /**
     * 绑定数据，View和数据绑定
     */

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < datas.size) {
            when (getItemViewType(position)) {
                TYPE_TITLE -> (holder as TitleHolder).bindData()
                TYPE_SELLER -> (holder as SellerHolder).bindData(position)
            }

        }


    }


    inner class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var mContentBanner: SimpleImageBanner = itemView.findViewById(R.id.mContentBanner)

        fun bindData() {

            mContentBanner.setSource(data)
                .setOnItemClickListener(BaseBanner.OnItemClickListener<BannerItem?> { _, _, position ->
                    Toast.makeText(
                        context,
                        "点击了$position",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                .setIsOnePageLoop(false).startScroll()


        }

    }

    inner class SellerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ima: RadiusImageView = itemView.findViewById(R.id.ima)
        private var title: TextView = itemView.findViewById(R.id.title)
        private var petname: TextView = itemView.findViewById(R.id.petname)
        private var petimg: RadiusImageView = itemView.findViewById(R.id.petimg)
        private var like: TextView = itemView.findViewById(R.id.like)

        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun bindData(position: Int) {

            itemView.setOnClickListener { v ->
                mItemClickListener?.onItemClick(v, position)
            }
            Glide.with(context).load(datas[position].pet_dynamic_ima_small).placeholder(R.drawable.placeholder_big).into(ima)
            Glide.with(context).load(datas[position].pet_imgurl).placeholder(R.drawable.placeholder).into(petimg)
            title.text = datas[position].pet_dynamic_title
            petname.text = datas[position].pet_name
            like.text = datas[position].pet_dynamic_like.toString()+"赞"
        }
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.mItemClickListener = itemClickListener
    }
}


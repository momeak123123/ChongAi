package com.ch.wu.app.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ch.wu.app.R
import com.ch.wu.app.bean.Dynamic
import com.ch.wu.app.holder.NetViewHolder
import com.shehuan.niv.NiceImageView
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.utils.BannerUtils


class RecommendAdapter(
    val datas: MutableList<Dynamic>,
    val context: Context
) : RecyclerView.Adapter<RecommendAdapter.InnerHolder>() {

    private var mItemClickListener: ItemClickListener? = null

    /**
     * 相当于getView()
     */
    override fun onCreateViewHolder(holder: ViewGroup, position: Int): InnerHolder {
        //加载View
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.home_recommend, holder, false)
        return InnerHolder(itemView)

    }

    /**
     * 得到总条数
     */
    override fun getItemCount(): Int = datas.size


    class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var ima: NiceImageView = itemView.findViewById(R.id.ima)
         var title: TextView = itemView.findViewById(R.id.title)
         var petname: TextView = itemView.findViewById(R.id.petname)
         var petimg: NiceImageView = itemView.findViewById(R.id.petimg)
         var like: TextView = itemView.findViewById(R.id.like)

    }

    /**
     * 绑定数据，View和数据绑定
     */
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.itemView.setOnClickListener { v ->
            mItemClickListener?.onItemClick(v,position)
        }

        Glide.with(context).load(datas[position].pet_dynamic_ima_small).placeholder(R.drawable.placeholder_big).into(holder.ima)
        Glide.with(context).load(datas[position].pet_imgurl).placeholder(R.drawable.placeholder).into(holder.petimg)
        holder.title.text = datas[position].pet_dynamic_title
        holder.petname.text = datas[position].pet_name
        holder.like.text = datas[position].pet_dynamic_like.toString()+"赞"
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.mItemClickListener = itemClickListener
    }

}


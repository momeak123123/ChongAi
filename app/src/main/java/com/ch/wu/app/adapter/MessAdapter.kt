package com.ch.wu.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ch.wu.app.R
import com.ch.wu.app.bean.Notice
import com.shehuan.niv.NiceImageView

class MessAdapter  (var datas:MutableList<Notice>, val context: Context) : RecyclerView.Adapter<MessAdapter.InnerHolder>() {


    private var mItemClickListener: ItemClickListener? = null

    /**
     * 相当于getView()
     */
    override fun onCreateViewHolder(holder: ViewGroup, position: Int): InnerHolder {
        //加载View
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.mess_item, holder, false)
        return InnerHolder(itemView)

    }

    /**
     * 得到总条数
     */
    override fun getItemCount(): Int = datas.size


    class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: NiceImageView = itemView.findViewById(R.id.img)
        var title: TextView = itemView.findViewById(R.id.title)
        var txt: TextView = itemView.findViewById(R.id.txt)
        var time: TextView = itemView.findViewById(R.id.time)

    }

    /**
     * 绑定数据，View和数据绑定
     */
    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.itemView.setOnClickListener { v ->
            mItemClickListener?.onItemClick(v,position)
        }
        Glide.with(context).load(datas[position].notice_imgurl).placeholder(R.drawable.placeholder).into(holder.img)
        holder.title.text = datas[position].notice_title
        holder.txt.text = datas[position].notice_txt
        holder.time.text = datas[position].notice_time.toString()
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.mItemClickListener = itemClickListener
    }


    fun addAll(data: MutableList<Notice>){
        datas.addAll(data)
    }

}
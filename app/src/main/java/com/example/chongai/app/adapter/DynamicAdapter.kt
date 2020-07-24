package com.example.chongai.app.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chongai.app.R
import com.example.chongai.app.app.view.act.DynamicActivity
import com.example.chongai.app.bean.Comment
import com.example.chongai.app.bean.Dynamic
import com.jaeger.ninegridimageview.ItemImageClickListener
import com.jaeger.ninegridimageview.ItemImageLongClickListener
import com.jaeger.ninegridimageview.NineGridImageView
import com.jaeger.ninegridimageview.NineGridImageViewAdapter
import com.jakewharton.rxbinding2.view.RxView
import com.shehuan.niv.NiceImageView
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class DynamicAdapter(
val datas: MutableList<Comment>,
val context: Context,
val dyna :Dynamic
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
                LayoutInflater.from(context).inflate(R.layout.dynamic_header, holder, false)
            )
            TYPE_SELLER -> SellerHolder(
                LayoutInflater.from(context).inflate(R.layout.dynamic_item, holder, false)
            )
            else -> TitleHolder(
                LayoutInflater.from(context).inflate(R.layout.dynamic_header, holder, false)
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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < datas.size) {
            when (getItemViewType(position)) {
                TYPE_TITLE -> (holder as TitleHolder).bindData()
                TYPE_SELLER -> (holder as SellerHolder).bindData(position)
            }

        }


    }


    inner class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var left: ImageView = itemView.findViewById(R.id.h_left)
        private var right: ImageView = itemView.findViewById(R.id.h_right)
        private var ima: NiceImageView = itemView.findViewById(R.id.ima)
        private var title: TextView = itemView.findViewById(R.id.dynamic_title)
        private var time: TextView = itemView.findViewById(R.id.dynamic_time)
        private var txt: TextView = itemView.findViewById(R.id.dynamic_txt)
        private var petname: TextView = itemView.findViewById(R.id.petname)
        private var petimg: NiceImageView = itemView.findViewById(R.id.petimg)
        private var attention: TextView = itemView.findViewById(R.id.attention)

        @SuppressLint("CheckResult")
        @RequiresApi(Build.VERSION_CODES.M)
        fun bindData() {
            Glide.with(context).load(dyna.pet_imgurl).placeholder(R.drawable.placeholder_big).into(ima)
            Glide.with(context).load(dyna.pet_imgurl).placeholder(R.drawable.placeholder).into(petimg)
            title.text = dyna.pet_dynamic_title
            txt.text = dyna.pet_dynamic_txt
            time.text = dyna.pet_dynamic_time
            petname.text = dyna.pet_name

            RxView.clicks(attention)
                .throttleFirst(0, TimeUnit.SECONDS)
                .subscribe {
                    if(attention.text == "关注"){
                        attention.text = "已关注"
                    }else{
                        attention.text = "关注"
                    }

                }
            RxView.clicks(left)
                .throttleFirst(0, TimeUnit.SECONDS)
                .subscribe {
                    Observable.just(true).subscribe(DynamicActivity.observer)
                }
            RxView.clicks(right)
                .throttleFirst(0, TimeUnit.SECONDS)
                .subscribe {

                }

        }

    }

    inner class SellerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nineGridImageView: NineGridImageView<String> = itemView.findViewById(R.id.nineGridImageView)
        private var txt: TextView = itemView.findViewById(R.id.txt)
        private var petname: TextView = itemView.findViewById(R.id.petname)
        private var petimg: NiceImageView = itemView.findViewById(R.id.petimg)
        private var time: TextView = itemView.findViewById(R.id.time)

        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun bindData(position: Int) {

            itemView.setOnClickListener { v ->
                mItemClickListener?.onItemClick(v, position)
            }
            val url = datas[position].pet_comment_ima.split(",")
            nineGridImageView.setImagesData(url, 0)
            nineGridImageView.setAdapter(mAdapter)
            nineGridImageView.setItemImageClickListener(ItemImageClickListener<String> { context, imageView, index, list ->
                Log.d(
                    "onItemImageClick",
                    list[index]
                )
            })
            nineGridImageView.setItemImageLongClickListener(ItemImageLongClickListener<String> { context, imageView, index, list ->
                Log.d("onItemImageLongClick", list[index])
                true
            })

            Glide.with(context).load(datas[position].pet_imgurl).placeholder(R.drawable.placeholder).into(petimg)
            txt.text = datas[position].pet_comment_txt
            petname.text = datas[position].pet_name
            time.text = datas[position].pet_comment_time
        }
    }

    private val mAdapter: NineGridImageViewAdapter<String> =
        object : NineGridImageViewAdapter<String>() {
            override fun onDisplayImage(
                context: Context,
                imageView: ImageView,
                s: String
            ) {
                Glide.with(context).load(s).placeholder(R.drawable.placeholder_big).into(imageView)
            }
            override fun onItemImageClick(
                context: Context,
                imageView: ImageView,
                index: Int,
                list: List<String>
            ) {
                Toast.makeText(context, "image position is $index", Toast.LENGTH_SHORT).show()
            }

            override fun onItemImageLongClick(
                context: Context,
                imageView: ImageView,
                index: Int,
                list: List<String>
            ): Boolean {
                Toast.makeText(context, "image long click position is $index", Toast.LENGTH_SHORT)
                    .show()
                return true
            }
        }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.mItemClickListener = itemClickListener
    }
}


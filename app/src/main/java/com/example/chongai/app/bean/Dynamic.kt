package com.example.chongai.app.bean

import android.os.Parcel
import android.os.Parcelable

data class Dynamic(
    val pet_id:Long,//用户id
    val pet_dynamic_ima_small: String?,//动态封面
    val pet_dynamic_title:String?,//动态标题
    val pet_dynamic_txt:String?,//动态内容
    val pet_dynamic_like:Long,//动态点赞量
    val pet_dynamic_time:String?,//动态点赞量
    val pet_name:String?,//用户昵称
    val pet_imgurl:String?//用户头像
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(pet_id)
        parcel.writeString(pet_dynamic_ima_small)
        parcel.writeString(pet_dynamic_title)
        parcel.writeString(pet_dynamic_txt)
        parcel.writeLong(pet_dynamic_like)
        parcel.writeString(pet_dynamic_time)
        parcel.writeString(pet_name)
        parcel.writeString(pet_imgurl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dynamic> {
        override fun createFromParcel(parcel: Parcel): Dynamic {
            return Dynamic(parcel)
        }

        override fun newArray(size: Int): Array<Dynamic?> {
            return arrayOfNulls(size)
        }
    }
}
package com.example.chongai.app.bean

data class Dynamic(
    val pet_id:Long,//用户id
    val pet_dynamic_ima_small:String,//动态封面
    val pet_dynamic_title:String,//动态标题
    val pet_dynamic_txt:String,//动态内容
    val pet_dynamic_like:Long,//动态点赞量
    val pet_dynamic_time:String,//动态点赞量
    val pet_name:String,//用户昵称
    val pet_imgurl:String//用户头像
)
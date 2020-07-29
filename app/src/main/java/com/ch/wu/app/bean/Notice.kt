package com.ch.wu.app.bean

data class Notice (
    val notice_id:Long,//用户id
    val notice_state:Int,//状态
    val notice_type:Int,//类型
    val notice_time:Long,//时间
    val notice_txt:String,//内容
    val notice_title:String,//标题
    val notice_imgurl:String//头像
)
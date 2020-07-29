package com.ch.wu.app.bean

data class Comment(
    val pet_id: Long,//用户id
    val pet_comment_ima: String,//评论图片
    val pet_comment_txt: String,//评论内容
    val pet_comment_time: String,//评论点赞量
    val pet_name: String,//用户昵称
    val pet_imgurl: String,//用户头像
    val pet_comment_name: String,//评论用户名称
    val type: Int//评论类型 回答/追问
)
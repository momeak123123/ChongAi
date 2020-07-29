package  com.ch.wu.app.app.model

import android.content.Context
import com.ch.wu.app.app.contract.DynamicContract
import com.ch.wu.app.app.view.act.DynamicActivity
import com.ch.wu.app.bean.Comment
import io.reactivex.Observable
import mvp.ljb.kt.model.BaseModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/23
 * @Description input description
 **/
class DynamicModel : BaseModel(), DynamicContract.IModel {
    override fun comment(context: Context) {
        val data: MutableList<Comment> = ArrayList()
        data.add(Comment(0,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。","12:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png","",0))
        data.add(Comment(1,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png|https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。","13:40","官方回答1","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png","官方回答",1))
        data.add(Comment(2,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。","14:40","官方回答2","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png","官方回答1",1))
        Observable.just(data).subscribe(DynamicActivity.observers)
    }
}
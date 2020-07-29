package  com.ch.wu.app.app.model

import android.content.Context
import com.ch.wu.app.app.contract.RecommendContract
import com.ch.wu.app.app.view.act.DynamicActivity
import com.ch.wu.app.app.view.fragment.RecommendFragment
import com.ch.wu.app.bean.Dynamic
import io.reactivex.Observable
import mvp.ljb.kt.model.BaseModel


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendModel : BaseModel(), RecommendContract.IModel{

    override fun banner(context: Context){
        val list: MutableList<String> = ArrayList()
        list.add(
            "https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Banner/banner1.png"
        )
        list.add(
            "https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Banner/banner2.png"
        )
        list.add(
            "https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Banner/banner3.png"
        )
        Observable.just(list).subscribe(RecommendFragment.observer)
    }

    override fun list(context: Context) {
        val data: MutableList<Dynamic> = ArrayList()
        data.add(Dynamic(0,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","晒出更萌宠物，更有机会拿大奖，赶快行动吧","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。",0,"12:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        data.add(Dynamic(1,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","晒出更萌宠物，更有机会拿大奖，赶快行动吧","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。",0,"13:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        data.add(Dynamic(2,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","晒出更萌宠物，更有机会拿大奖，赶快行动吧","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。",0,"14:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        Observable.just(data).subscribe(RecommendFragment.observers)
    }
}
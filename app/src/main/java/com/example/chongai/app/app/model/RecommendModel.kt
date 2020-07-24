package  com.example.chongai.app.app.model

import android.content.Context
import com.example.chongai.app.app.contract.RecommendContract
import com.example.chongai.app.bean.Dynamic
import mvp.ljb.kt.model.BaseModel


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendModel : BaseModel(), RecommendContract.IModel{

    override fun banner(context: Context): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        list.add(
            "https://img.zcool.cn/community/013de756fb63036ac7257948747896.jpg"
        )
        list.add(
            "https://img.zcool.cn/community/01639a56fb62ff6ac725794891960d.jpg"
        )
        list.add(
            "https://img.zcool.cn/community/01270156fb62fd6ac72579485aa893.jpg"
        )
        list.add(
            "https://img.zcool.cn/community/01233056fb62fe32f875a9447400e1.jpg"
        )
        list.add(
            "https://img.zcool.cn/community/016a2256fb63006ac7257948f83349.jpg"
        )
        return list
    }

    override fun list(context: Context): MutableList<Dynamic> {
        val data: MutableList<Dynamic> = ArrayList()
        data.add(Dynamic(0,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","晒出更萌宠物，更有机会拿大奖，赶快行动吧","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。",0,"12:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        data.add(Dynamic(1,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","晒出更萌宠物，更有机会拿大奖，赶快行动吧","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。",0,"13:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        data.add(Dynamic(2,"https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/Dynamic/17430808668774.png","晒出更萌宠物，更有机会拿大奖，赶快行动吧","狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。",0,"14:40","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        return data
    }
}
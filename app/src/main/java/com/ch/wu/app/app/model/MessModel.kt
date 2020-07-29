package  com.ch.wu.app.app.model

import android.content.Context
import com.ch.wu.app.app.contract.MessContract
import com.ch.wu.app.app.view.act.DynamicActivity
import com.ch.wu.app.app.view.fragment.MessFragment
import com.ch.wu.app.bean.Comment
import com.ch.wu.app.bean.Notice
import io.reactivex.Observable
import mvp.ljb.kt.model.BaseModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class MessModel : BaseModel(), MessContract.IModel {
    override fun noticelist(context: Context) {
        val data: MutableList<Notice> = ArrayList()
        data.add(Notice(0,0,0,1345464,"狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。","官方回答","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        data.add(Notice(1,0,0,1345464,"狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。","官方回答1","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        data.add(Notice(2,0,0,1345464,"狗狗是人类最好的朋友，这种友谊已经上升到一个科学高度。有专家说：当你想要缓解一下工作中的紧张压力，来吧，弯下腰来抚摸一下你脚下的宠物狗是最简单的方法。那么，在IT人理不出程序条理、创意人写不出好的策划、记者写稿思绪混乱的时候，原来我们需要的不是咖啡或者心灵鸡汤——我们真正需要的是一个伙伴。","官方回答2","https://chongwuwuyu.oss-cn-shenzhen.aliyuncs.com/User/17340914305573.png"))
        Observable.just(data).subscribe(MessFragment.observer)
    }
}
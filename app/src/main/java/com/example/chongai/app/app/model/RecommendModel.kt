package  com.example.chongai.app.app.model

import android.content.Context
import com.example.chongai.app.app.contract.RecommendContract
import com.example.chongai.app.bean.Recommend
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem
import mvp.ljb.kt.model.BaseModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/22
 * @Description input description
 **/
class RecommendModel : BaseModel(), RecommendContract.IModel{

    override fun banner(context: Context): MutableList<BannerItem> {
        val list: MutableList<BannerItem> = ArrayList()
        val ban1 =  BannerItem()
        ban1.setImgUrl("https://img.zcool.cn/community/013de756fb63036ac7257948747896.jpg")
        list.add(ban1)
        val ban2 =  BannerItem()
        ban2.setImgUrl("https://img.zcool.cn/community/01639a56fb62ff6ac725794891960d.jpg")
        list.add(ban2)
        val ban3 =  BannerItem()
        ban3.setImgUrl("https://img.zcool.cn/community/01270156fb62fd6ac72579485aa893.jpg")
        list.add(ban3)
        return list
    }

    override fun list(context: Context): MutableList<Recommend> {
        val data: MutableList<Recommend> = ArrayList()
        data.add(Recommend(0,"","",0,"",""))
        data.add(Recommend(0,"","",0,"",""))
        data.add(Recommend(0,"","",0,"",""))
        data.add(Recommend(0,"","",0,"",""))
        data.add(Recommend(0,"","",0,"",""))
        return data
    }
}
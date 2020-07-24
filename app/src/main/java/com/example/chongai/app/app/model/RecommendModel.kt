package  com.example.chongai.app.app.model

import android.content.Context
import com.example.chongai.app.app.contract.RecommendContract
import com.example.chongai.app.bean.CustomBean
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
        data.add(Dynamic(0,"","",0,"",""))
        data.add(Dynamic(0,"","",0,"",""))
        data.add(Dynamic(0,"","",0,"",""))
        data.add(Dynamic(0,"","",0,"",""))
        data.add(Dynamic(0,"","",0,"",""))
        return data
    }
}
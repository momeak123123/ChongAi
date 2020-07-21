package  com.example.chongai.app.app.model

import android.content.Context
import com.example.chongai.app.R
import com.example.chongai.app.app.contract.HomeContract
import com.example.chongai.app.bean.Nav
import mvp.ljb.kt.model.BaseModel


/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/07/21
 * @Description input description
 **/
class HomeModel : BaseModel(), HomeContract.IModel {
    override fun banner(context: Context): MutableList<String> {
        val ban: MutableList<String> = ArrayList()
        ban.add("https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_TK5jX.png")
        ban.add("https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_AhKVK.png")
        ban.add("https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_kE4jY.png")
        return ban
    }

    override fun tran(context: Context): MutableList<Nav> {
        val navs: MutableList<Nav> = ArrayList()
        navs.add(
            Nav(
                R.drawable.ic_nav_charge,
                "流量",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_TK5jX.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_bill,
                "分账",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_AhKVK.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_device_binding,
                "绑定",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_kE4jY.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_member_manage,
                "会员",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_2yXk8.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_msg,
                "消息",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_irvud.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_download,
                "物料",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_PcmPU.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_excel,
                "营收",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_NeFKy.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_favor,
                "收藏",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_yUFai.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_goods,
                "商品",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_KahtV.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_group,
                "分组",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_vuZsr.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_devices,
                "设备统计",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_t4sRT.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_vip_card,
                "会员卡",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172730_j2td3.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_vip_integral,
                "积分",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172730_rArtS.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_members,
                "用户",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_LsMFQ.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_device_magage,
                "设备管理",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172629_UcuEH.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_shop_decorate,
                "装修",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_fleMs.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_order,
                "订单",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_zzyP2.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_service,
                "客服",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172705_Wuun5.png"
            )
        )
        navs.add(
            Nav(
                R.drawable.ic_nav_shopping,
                "商城",
                "https://c-ssl.duitang.com/uploads/item/201911/25/20191125172730_VnmYC.png"
            )
        )
        return navs
    }
}
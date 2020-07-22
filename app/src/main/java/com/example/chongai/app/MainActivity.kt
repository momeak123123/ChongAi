package com.example.chongai.app

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.chongai.app.app.view.fragment.*
import com.next.easynavigation.view.EasyNavigationBar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var needPermissions = arrayOf(
        Manifest.permission.VIBRATE,
        Manifest.permission.BROADCAST_STICKY,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.ACCESS_WIFI_STATE,
        Manifest.permission.INTERNET,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WAKE_LOCK,
        Manifest.permission.CAMERA,
        Manifest.permission.DISABLE_KEYGUARD
    )

    /**
     * 判断是否需要检测，防止不停的弹框
     */
    private var isNeedCheck = true

    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context
    private var exit = false



    //未选中icon
    private val normalIcon = intArrayOf(
        R.drawable.homes,
        R.drawable.nearbys,
        R.drawable.messs,
        R.drawable.mys
    )

    //选中时icon
    private val selectIcon = intArrayOf(
        R.drawable.home,
        R.drawable.nearby,
        R.drawable.mess,
        R.drawable.my
    )

    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        context = this

        initView()

    }

    private fun initView(){
        val tab1 = getString(R.string.tab1)
        val tab2 = getString(R.string.tab2)
        val tab3 = getString(R.string.tab3)
        val tab4 = getString(R.string.tab4)
        val tabText = arrayOf(tab1, tab2, tab3, tab4)
        fragments.add(RecommendFragment())
        fragments.add(NearbyFragment())
        fragments.add(MessFragment())
        fragments.add(MyFragment())
        navigationBar.titleItems(tabText)
            .normalIconItems(normalIcon)
            .selectIconItems(selectIcon)
            .fragmentList(fragments)
            .canScroll(true)
            .iconSize(20f) //Tab图标大小
            .tabTextSize(10) //Tab文字大小
            .tabTextTop(5) //Tab文字距Tab图标的距离
            .normalTextColor(Color.parseColor("#bdc3d0")) //Tab未选中时字体颜色
            .selectTextColor(Color.parseColor("#71a0ff")) //Tab选中时字体颜色
            .scaleType(ImageView.ScaleType.CENTER_INSIDE) //同 ImageView的ScaleType
            .navigationBackground(Color.parseColor("#ffffff")) //导航栏背景色
            .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
            .fragmentManager(supportFragmentManager)
            .setOnTabClickListener(object : EasyNavigationBar.OnTabClickListener {
                override fun onTabSelectEvent(view: View, position: Int): Boolean {
                    return false
                }

                override fun onTabReSelectEvent(
                    view: View,
                    position: Int
                ): Boolean {
                    return false
                }
            })
            .smoothScroll(true) //点击Tab  Viewpager切换是否有动画
            .canScroll(true) //Viewpager能否左右滑动
            .centerImageRes(R.drawable.add_image)
            .centerIconSize(40F)    //中间加号图片的大小
            .centerLayoutHeight(100)   //包含加号的布局高度 背景透明  所以加号看起来突出一块
            .navigationHeight(60)  //导航栏高度
            .lineColor(Color.parseColor("#ffffff"))
            .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM) //RULE_CENTER 加号居中addLayoutHeight调节位置 EasyNavigationBar.RULE_BOTTOM 加号在导航栏靠下
            .centerLayoutBottomMargin(10)   //加号到底部的距离
            .hasPadding(true)    //true ViewPager布局在导航栏之上 false有重叠
            .centerAlignBottom(true) //加号是否同Tab文字底部对齐  RULE_BOTTOM时有效；
            .textSizeType(EasyNavigationBar.TextSizeType.TYPE_DP) //字体单位 建议使用DP  可切换SP
            .setOnCenterTabClickListener {

                false
            }
            .build()
    }

    override fun onResume() {
        super.onResume()

        if (isNeedCheck) {
            checkPermissions(needPermissions)
        }
    }

    /**
     * 检查权限
     *
     * @param
     * @since 2.5.0
     */
    private fun checkPermissions(permissions: Array<String>) {
        //获取权限列表
        val needRequestPermissonList =
            findDeniedPermissions(permissions)
        if (needRequestPermissonList.isNotEmpty()) {
            //list.toarray将集合转化为数组
            ActivityCompat.requestPermissions(
                this,
                needRequestPermissonList.toTypedArray(),
                0
            )
        }
    }


    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     */
    private fun findDeniedPermissions(permissions: Array<String>): List<String> {
        val needRequestPermissonList: MutableList<String> =
            ArrayList()
        //for (循环变量类型 循环变量名称 : 要被遍历的对象)
        for (perm in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    perm
                ) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.shouldShowRequestPermissionRationale(
                    this, perm
                )
            ) {
                needRequestPermissonList.add(perm)
            }
        }
        return needRequestPermissonList
    }

    /**
     * 检测是否说有的权限都已经授权
     *
     * @param grantResults
     * @return
     * @since 2.5.0
     */
    private fun verifyPermissions(grantResults: IntArray): Boolean {
        for (result in grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, paramArrayOfInt: IntArray
    ) {
        if (requestCode == 0) {
            if (!verifyPermissions(paramArrayOfInt)) {      //没有授权
                showMissingPermissionDialog() //显示提示信息
                isNeedCheck = false
            }
        }
    }

    /**
     * 显示提示信息
     *
     * @since 2.5.0
     */
    private fun showMissingPermissionDialog() {
        val builder =
            AlertDialog.Builder(this)
        builder.setTitle(R.string.notifyTitle)
        builder.setMessage(R.string.notifyMsg)

        // 拒绝, 退出应用
        builder.setNegativeButton(
            R.string.cancel
        ) { _, _ -> finish() }
        builder.setPositiveButton(
            R.string.setting
        ) { _, _ -> startAppSettings() }
        builder.setCancelable(false)
        builder.show()
    }


    /**
     * 启动应用的设置
     *
     * @since 2.5.0
     */
    private fun startAppSettings() {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        )
        intent.data = Uri.parse("package:$packageName")
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onBackPressed() {
        if (exit) {
            System.exit(0)
        } else {
            exit = true
            Toast.makeText(context, getText(R.string.main_set), Toast.LENGTH_SHORT).show()
        }
    }
}

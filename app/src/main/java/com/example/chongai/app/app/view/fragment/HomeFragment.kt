package com.example.chongai.app.app.view.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.chongai.app.R
import com.example.chongai.app.config.ScaleTransitionPagerTitleView
import com.next.easynavigation.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView


class HomeFragment : Fragment() {

    private val mDataList = listOf("推荐", "关注", "故事", "健康")
   override fun onCreateView(
       inflater: LayoutInflater,
       container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View? {
       return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val list: MutableList<Fragment> = ArrayList()
        list.add(RecommendFragment())
        list.add(NearbyFragment())
        list.add(StoryFragment())
        list.add(InquiryFragment())
        mViewPager.adapter = ViewPagerAdapter(fragmentManager, list)

        val commonNavigator = CommonNavigator(requireContext())
        magicIndicator.setBackgroundColor(Color.WHITE)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return mDataList.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val simplePagerTitleView: SimplePagerTitleView =
                    ScaleTransitionPagerTitleView(context)
                simplePagerTitleView.text = mDataList[index]
                simplePagerTitleView.textSize = 18f
                simplePagerTitleView.normalColor = Color.GRAY
                simplePagerTitleView.selectedColor = Color.BLACK
                simplePagerTitleView.setOnClickListener { mViewPager.currentItem = index }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = BezierPagerIndicator(context)
                indicator.setColors(
                    Color.parseColor("#76b0ff"),
                    Color.parseColor("#73e8f4"),
                    Color.parseColor("#fcde64"),
                    Color.parseColor("#ff4a42")
                )
                return indicator
            }
        }
        magicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(magicIndicator, mViewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}
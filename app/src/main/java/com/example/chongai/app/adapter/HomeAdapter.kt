package com.example.chongai.app.adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.chongai.app.app.view.fragment.*


class HomeAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {
    private val strings = arrayOf("A", "B", "C", "D")
    private val fragmentList = arrayOf(RecommendFragment(), AttentionFragment(),StoryFragment(), InquiryFragment())
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return strings[position]
    }
}

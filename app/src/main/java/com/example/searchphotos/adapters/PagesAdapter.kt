package com.example.searchphotos.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.searchphotos.fragments.AllImagesFragment

class PagesAdapter(fragmentManager: FragmentManager, private val titleList: List<String>): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int  = 5

    override fun getItem(position: Int): Fragment {
        return AllImagesFragment.newInstance(titleList[position])
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
}
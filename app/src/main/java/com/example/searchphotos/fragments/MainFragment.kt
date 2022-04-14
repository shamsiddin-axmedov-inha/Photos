package com.example.searchphotos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.searchphotos.R
import com.example.searchphotos.adapters.PagesAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.tab_item.view.*

class MainFragment : Fragment() {

    lateinit var root: View
    lateinit var titleList: ArrayList<String>
    lateinit var pagesAdapter: PagesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_main, container, false)

        titleList = ArrayList()
        titleList.add("All")
        titleList.add("New")
        titleList.add("Animals")
        titleList.add("Technology")
        titleList.add("Nature")

        pagesAdapter = PagesAdapter(childFragmentManager, titleList)
        root.view_pager.adapter = pagesAdapter
        root.tabLayout.setupWithViewPager(root.view_pager)

        setTabs()

        root.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.titleTv?.setTextColor(resources.getColor(R.color.white))
                tab?.customView?.circle_indicator?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.titleTv?.setTextColor(resources.getColor(R.color.grey))
                tab?.customView?.circle_indicator?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        return root
    }

    private fun setTabs() {
        val tabCount = root.tabLayout.tabCount

        for (i in 0 until tabCount){
            val tabView = LayoutInflater.from(root.context).inflate(R.layout.tab_item, null, false)
            val tabAt = root.tabLayout.getTabAt(i)
            tabAt?.customView = tabView

            tabView.titleTv?.text = titleList[i]

            if (i == 0){
                tabView?.titleTv?.setTextColor(resources.getColor(R.color.white))
                tabView.circle_indicator.visibility = View.VISIBLE
            }else{
                tabView.circle_indicator.visibility = View.INVISIBLE
                tabView.titleTv?.setTextColor(resources.getColor(R.color.grey))
            }
        }
    }

}
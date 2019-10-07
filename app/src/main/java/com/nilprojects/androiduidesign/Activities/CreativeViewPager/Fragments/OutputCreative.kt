package com.nilprojects.androiduidesign.Activities.CreativeViewPager.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nilprojects.androiduidesign.Activities.CreativeViewPager.NatureCreativePagerAdapter

import com.nilprojects.androiduidesign.R
import com.tbuonomo.creativeviewpager.CreativeViewPager


class OutputCreative : Fragment() {

    lateinit var creativeViewPagerView : CreativeViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_output_creative, container, false)

        creativeViewPagerView = view.findViewById<CreativeViewPager>(R.id.creativeViewPagerView)


        creativeViewPagerView.setCreativeViewPagerAdapter(NatureCreativePagerAdapter(activity!!.applicationContext))


        return view
    }

}
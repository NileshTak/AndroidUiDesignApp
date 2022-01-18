package com.nilprojects.androiduidesign.Activities.FoldingTapBar.Fragment

import android.content.ClipData
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.Toast
import client.yalantis.com.foldingtabbar.FoldingTabBar
import com.nilprojects.androiduidesign.R
import org.jetbrains.annotations.NotNull






class folding_tap_output : Fragment() {
    lateinit var FoldtapBar: FoldingTabBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_folding_tap_output, container, false)

        FoldtapBar = view.findViewById (R.id.folding_tapBarMenu) as FoldingTabBar


        return view
    }




}
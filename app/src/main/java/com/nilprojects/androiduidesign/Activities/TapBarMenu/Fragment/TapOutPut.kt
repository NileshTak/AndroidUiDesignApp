package com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.michaldrabik.tapbarmenulib.TapBarMenu

import com.nilprojects.androiduidesign.R


class TapOutPut : Fragment() {


    lateinit var tapBarMenu: TapBarMenu
    lateinit var item1 : ImageView
    lateinit var item2 : ImageView
    lateinit var item3 : ImageView
    lateinit var item4 : ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_tap_out_put, container, false)

        tapBarMenu = view.findViewById (R.id.tapBarMenu) as TapBarMenu
        item1 = view.findViewById<ImageView>(R.id.item1)
        item2 = view.findViewById<ImageView>(R.id.item2)
        item3 = view.findViewById<ImageView>(R.id.item3)
        item4 = view.findViewById<ImageView>(R.id.item4)

        tapBarMenu.setOnClickListener {
            onMenuButtonClick()
        }

        item1.setOnClickListener {
            onMenuItemClick(item1)
        }

        item2.setOnClickListener {
            onMenuItemClick(item2)
        }

        item3.setOnClickListener {
            onMenuItemClick(item3)
        }
        item4.setOnClickListener {
            onMenuItemClick(item4)
        }

        return view
    }

    fun onMenuButtonClick() {
        tapBarMenu.toggle()
    }

    fun onMenuItemClick(view: View) {
        tapBarMenu.close()
        when (view.id) {
            R.id.item1 -> Toast.makeText(activity,"Item1 Selected", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(activity,"Item2 Selected", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(activity,"Item3 Selected", Toast.LENGTH_SHORT).show()
            R.id.item4 -> Toast.makeText(activity,"Item4 Selected", Toast.LENGTH_SHORT).show()
        }
    }

}
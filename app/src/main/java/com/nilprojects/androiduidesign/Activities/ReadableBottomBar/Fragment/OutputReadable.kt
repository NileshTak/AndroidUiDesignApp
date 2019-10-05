package com.nilprojects.androiduidesign.Activities.ReadableBottomBar.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.iammert.library.readablebottombar.ReadableBottomBar

import com.nilprojects.androiduidesign.R

class OutputReadable : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_output_readable, container, false)

        var nav = view.findViewById<ReadableBottomBar>(R.id.nav)


        nav.setOnItemSelectListener( object :ReadableBottomBar.ItemSelectListener{
            override fun onItemSelected(index: Int) {
                when(index)
                {
                    0 -> {
                        Toast.makeText(activity,"Home Activity Clicked", Toast.LENGTH_LONG).show()
                    }
                    1 -> {
                        Toast.makeText(activity,"Search Activity Clicked", Toast.LENGTH_LONG).show()
                    }
                    2 -> {
                        Toast.makeText(activity,"Bag Activity Clicked", Toast.LENGTH_LONG).show()
                    }
                    3 -> {
                        Toast.makeText(activity,"Orders Activity Clicked", Toast.LENGTH_LONG).show()
                    }
                    4 -> {
                        Toast.makeText(activity,"Profile Activity Clicked", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })

        return view
    }
}

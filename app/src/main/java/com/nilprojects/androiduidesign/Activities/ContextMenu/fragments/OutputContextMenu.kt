package com.nilprojects.androiduidesign.Activities.ContextMenu.fragments

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.nilprojects.androiduidesign.R
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment
import com.yalantis.contextmenu.lib.MenuObject
import com.yalantis.contextmenu.lib.MenuParams
import kotlinx.android.synthetic.main.toolbar.*
import android.view.Menu
import android.view.MenuItem
import android.R.menu

import android.view.MenuInflater





class OutputContextMenu : Fragment() {

    private lateinit var contextMenuDialogFragment: ContextMenuDialogFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output_context_menu, container, false)

//        initToolbar()
//        initMenuFragment()
//        setHasOptionsMenu(true);
        return view
    }







}
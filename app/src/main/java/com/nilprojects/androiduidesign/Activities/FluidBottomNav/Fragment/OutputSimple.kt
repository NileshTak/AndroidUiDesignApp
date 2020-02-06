package com.nilprojects.androiduidesign.Activities.FluidBottomNav.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.nilprojects.androiduidesign.Activities.BubbleNav.BottomBarActivity
import com.nilprojects.androiduidesign.Activities.BubbleNav.EqualBottomBarActivity
import com.nilprojects.androiduidesign.Activities.BubbleNav.FloatingTopBarActivity
import com.nilprojects.androiduidesign.Activities.BubbleNav.TopBarActivity

import com.nilprojects.androiduidesign.R
import kotlinx.android.synthetic.main.activity_main_bubble.*


class OutputSimple : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.activity_main_bubble, container, false)


        view.findViewById<Button>(R.id.open_top_navigation_bar).setOnClickListener {
            launchTopBarActivity()
        }

        view.findViewById<Button>(R.id.open_top_float_navigation_bar).setOnClickListener {
            launchFloatingBarActivity()
        }

        view.findViewById<Button>(R.id.open_bottom_equal_navigation_bar).setOnClickListener {
            launchEqualBarActivity()
        }

        view.findViewById<Button>(R.id.open_bottom_navigation_bar).setOnClickListener {
            launchBottomBarActivity()
        }

        return view
    }

    private fun launchBottomBarActivity() {
        val intent = Intent(activity, BottomBarActivity::class.java)
        startActivity(intent)
    }

    private fun launchFloatingBarActivity() {
        val intent = Intent(activity, FloatingTopBarActivity::class.java)
        startActivity(intent)
    }

    private fun launchTopBarActivity() {
        val intent = Intent(activity, TopBarActivity::class.java)
        startActivity(intent)
    }

    private fun launchEqualBarActivity() {
        val intent = Intent(activity, EqualBottomBarActivity::class.java)
        startActivity(intent)
    }

}
package com.nilprojects.androiduidesign.Activities.FragmentNavAnim

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nilprojects.androiduidesign.CommonUtils.Utils

import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivityNavFrag : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var optionSelected = 0
    private var mFirstFragment: SlidingListFragmentLeft? = null
    lateinit var fabGitFrag : FloatingActionButton

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frag_nav)
        supportActionBar!!.title = "Fragment Navigation Animation"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        fabGitFrag = findViewById<FloatingActionButton>(R.id.fabGitFrag)

        fabGitFrag.setOnClickListener {
            Utils.navigateToGithub("https://github.com/DesarrolloAntonio/FragmentTransactionExtended",this@MainActivityNavFrag)
        }

        val spinner = findViewById<View>(R.id.spinner) as Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.array_spinner,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        //Add first fragment
        mFirstFragment = SlidingListFragmentLeft()
        val fm = fragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.fragment_place, mFirstFragment)
        fragmentTransaction.commit()
    }

    fun addTransition(view: View) {
        val button = findViewById<View>(R.id.button) as Button
        if (fragmentManager.backStackEntryCount == 0) {
            val secondFragment = SlidingListFragmentRight()
            val fm = fragmentManager
            val fragmentTransaction = fm.beginTransaction()
            val fragmentTransactionExtended = FragmentTransactionExtended(
                this,
                fragmentTransaction,
                mFirstFragment,
                secondFragment,
                R.id.fragment_place
            )
            fragmentTransactionExtended.addTransition(optionSelected)
            fragmentTransactionExtended.commit()
            button.text = "Back"
        } else {
            fragmentManager.popBackStack()
            button.text = "Push"
        }
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        optionSelected = i
    }

    override fun onNothingSelected(adapterView: AdapterView<*>) {}

    override fun onBackPressed() {
        val button = findViewById<View>(R.id.button) as Button
        button.text = "Push"
        super.onBackPressed()
    }

}

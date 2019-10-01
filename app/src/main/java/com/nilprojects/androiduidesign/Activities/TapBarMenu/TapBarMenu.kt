package com.nilprojects.androiduidesign.Activities.TapBarMenu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapCode
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapOutPut
import com.nilprojects.androiduidesign.R
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper




class TapBarMenu : AppCompatActivity() {


    lateinit var tabLayout : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPager: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tap_bar_menu)
        supportActionBar!!.title = "Tap Bar Menu"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(TapOutPut(), "Output" )
        adapter.addFragment(TapCode(), "Code")



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons()

    }

    private fun setupTabIcons() {
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_action_add)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_arrow_to_drawer)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

package com.nilprojects.androiduidesign.Activities.MeowBottomNav

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment.MeowCode
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment.MeowOutput
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapCode
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapOutPut
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MeowNavBottom : AppCompatActivity() {


    lateinit var tabLayoutMeow : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPagerMeow: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meow_nav_bottom)
        supportActionBar!!.title = "Meow Bottom Nav"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayoutMeow = findViewById<TabLayout>(R.id.tabLayoutMeow)
        viewPagerMeow = findViewById<ViewPager>(R.id.viewPagerMeow)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(MeowOutput(), "Output" )
        adapter.addFragment(MeowCode(), "Code")



        viewPagerMeow.setAdapter(adapter);
        tabLayoutMeow.setupWithViewPager(viewPagerMeow);

    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

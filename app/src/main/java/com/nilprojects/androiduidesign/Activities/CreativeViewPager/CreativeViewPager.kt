package com.nilprojects.androiduidesign.Activities.CreativeViewPager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.CreativeViewPager.Fragments.CodeCreative
import com.nilprojects.androiduidesign.Activities.CreativeViewPager.Fragments.OutputCreative
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.Fragment.CodeSimple
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.Fragment.OutputSimple
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class CreativeViewPager : AppCompatActivity() {

    lateinit var tabLayoutCreative : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPagerCreative: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creative_view_pager)

        supportActionBar!!.title = "Creative View Pager"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayoutCreative = findViewById<TabLayout>(R.id.tabLayoutCreative)
        viewPagerCreative = findViewById<ViewPager>(R.id.viewPagerCreative)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputCreative(), "Output" )
        adapter.addFragment(CodeCreative(), "Code")

        viewPagerCreative.setAdapter(adapter);
        tabLayoutCreative.setupWithViewPager(viewPagerCreative);

    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

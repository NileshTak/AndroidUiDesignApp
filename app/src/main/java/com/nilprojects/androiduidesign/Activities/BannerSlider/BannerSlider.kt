package com.nilprojects.androiduidesign.Activities.BannerSlider

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.BannerSlider.Fragments.OutputBanner
import com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.Fragment.CodeSIS
import com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.Fragment.OutputSIS
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class BannerSlider : AppCompatActivity() {

    lateinit var tabLayoutBanner : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPagerBanner: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner_slider)
        supportActionBar!!.title = "Banner Slider"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayoutBanner = findViewById<TabLayout>(R.id.tabLayoutBanner)
        viewPagerBanner = findViewById<ViewPager>(R.id.viewPagerBanner)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputBanner(), "Output" )
//        adapter.addFragment(CodeSIS(), "Code")

        viewPagerBanner.setAdapter(adapter);
        tabLayoutBanner.setupWithViewPager(viewPagerBanner);

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

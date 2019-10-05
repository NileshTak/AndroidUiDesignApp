package com.nilprojects.androiduidesign.Activities.FluidBottomNav

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.Fragment.CodeSimple
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.Fragment.OutputSimple
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class FluidBottomNav : AppCompatActivity() {

    lateinit var tabLayout : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPager: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bubble_bottom_nav)

        supportActionBar!!.title = "Simple Bottom Nav"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayout = findViewById<TabLayout>(R.id.tabLayoutBubble)
        viewPager = findViewById<ViewPager>(R.id.viewPagerBubble)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputSimple(), "Output" )
        adapter.addFragment(CodeSimple(), "Code")



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

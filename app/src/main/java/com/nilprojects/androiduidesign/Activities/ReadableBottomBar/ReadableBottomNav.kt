package com.nilprojects.androiduidesign.Activities.ReadableBottomBar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.ReadableBottomBar.Fragment.Code
import com.nilprojects.androiduidesign.Activities.ReadableBottomBar.Fragment.OutputReadable
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class ReadableBottomNav : AppCompatActivity() {

    lateinit var tabLayout : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPager: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readable_bottom_nav)
        supportActionBar!!.title = "Readable Bottom Nav"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayout = findViewById<TabLayout>(R.id.tabLayoutReadable)
        viewPager = findViewById<ViewPager>(R.id.viewPagerReadable)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputReadable(), "Output" )
        adapter.addFragment(Code(), "Code")



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

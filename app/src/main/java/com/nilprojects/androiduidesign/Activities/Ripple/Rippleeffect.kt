package com.nilprojects.androiduidesign.Activities.Ripple

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.Ripple.Fragments.CodeRipple
import com.nilprojects.androiduidesign.Activities.Ripple.Fragments.OutputRipple
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class Rippleeffect : AppCompatActivity() {

    lateinit var tabLayout : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPager: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rippleeffect)
        supportActionBar!!.title = "Ripple Background Effect"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        tabLayout = findViewById<TabLayout>(R.id.tabLayoutRipple)
        viewPager = findViewById<ViewPager>(R.id.viewPagerRipple)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputRipple(), "Output" )
        adapter.addFragment(CodeRipple(), "Code")

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

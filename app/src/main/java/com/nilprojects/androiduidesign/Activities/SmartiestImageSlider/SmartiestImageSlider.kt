package com.nilprojects.androiduidesign.Activities.SmartiestImageSlider

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment.MeowCode
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment.MeowOutput
import com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.Fragment.CodeSIS
import com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.Fragment.OutputSIS
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class SmartiestImageSlider : AppCompatActivity() {

    lateinit var tabLayoutSIS : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPagerSIS: ViewPager

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smartiest_image_slider)

        supportActionBar!!.title = "Smarteist Image Slider"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        tabLayoutSIS = findViewById<TabLayout>(R.id.tabLayoutSIS)
        viewPagerSIS = findViewById<ViewPager>(R.id.viewPagerSIS)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputSIS(), "Output" )
        adapter.addFragment(CodeSIS(), "Code")



        viewPagerSIS.setAdapter(adapter);
        tabLayoutSIS.setupWithViewPager(viewPagerSIS);

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> {
                Utils.navigateToGithub("https://github.com/smarteist/Android-Image-Slider",this)

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

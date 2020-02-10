package com.nilprojects.androiduidesign.Activities.TapBarMenu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapCode
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapOutPut
import com.nilprojects.androiduidesign.R
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.CommonUtils.Utils
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import android.widget.Toast







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

    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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
                Utils.navigateToGithub("https://github.com/michaldrabik/TapBarMenu",this)

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }


}

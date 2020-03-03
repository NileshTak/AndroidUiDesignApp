package com.nilprojects.androiduidesign.Activities.MeowBottomNav

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment.MeowCode
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment.MeowOutput
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapCode
import com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment.TapOutPut
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MeowNavBottom : AppCompatActivity() {


    lateinit var tabLayoutMeow : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPagerMeow: ViewPager

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
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



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> {
                Utils.navigateToGithub("https://github.com/oneHamidreza/MeowBottomNavigation",this)

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

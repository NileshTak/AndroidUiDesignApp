package com.nilprojects.androiduidesign.Activities.BubbleNav

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nilprojects.androiduidesign.Activities.BubbleNav.adapters.ScreenSlidePagerAdapter
import com.nilprojects.androiduidesign.Activities.BubbleNav.fragment.ScreenSlidePageFragment
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

import kotlinx.android.synthetic.main.activity_floating_top_bar.*

class FloatingTopBarActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_top_bar)
        supportActionBar!!.title = "Floating Navigation Bar"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        floating_top_bar_navigation.setTypeface(Typeface.createFromAsset(assets, "rubik.ttf"))
        floating_top_bar_navigation.setBadgeValue(0, "3")
        floating_top_bar_navigation.setBadgeValue(1, "9+") //invisible badge

        val fragList = ArrayList<ScreenSlidePageFragment>()
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.home), R.color.red_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.search), R.color.blue_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.likes), R.color.blue_grey_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.notification), R.color.green_inactive))
        val pagerAdapter = ScreenSlidePagerAdapter(fragList, supportFragmentManager)
        view_pager.adapter = pagerAdapter
        //disable swipe
        view_pager.setOnTouchListener { _, _ ->
            return@setOnTouchListener true
        }

        floating_top_bar_navigation.setNavigationChangeListener { _, position ->
            view_pager.setCurrentItem(position, true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

package com.nilprojects.androiduidesign.Activities.BubbleNav

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener
import com.nilprojects.androiduidesign.Activities.BubbleNav.adapters.ScreenSlidePagerAdapter
import com.nilprojects.androiduidesign.Activities.BubbleNav.fragment.ScreenSlidePageFragment
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.toolbar.*

import java.util.ArrayList

class BottomBarActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar)
       supportActionBar!!.title = "Bottom Navigation Bar"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        val fragList = ArrayList<ScreenSlidePageFragment>()
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.home),
                R.color.red_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.search),
                R.color.blue_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.likes),
                R.color.blue_grey_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.notification),
                R.color.green_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.profile),
                R.color.purple_inactive
            )
        )
        val pagerAdapter = ScreenSlidePagerAdapter(fragList, supportFragmentManager)

        val bubbleNavigationLinearView =
            findViewById<BubbleNavigationLinearView>(R.id.bottom_navigation_view_linear)
        bubbleNavigationLinearView.setTypeface(Typeface.createFromAsset(assets, "rubik.ttf"))

        bubbleNavigationLinearView.setBadgeValue(0, "40")
        bubbleNavigationLinearView.setBadgeValue(1, null) //invisible badge
        bubbleNavigationLinearView.setBadgeValue(2, "7")
        bubbleNavigationLinearView.setBadgeValue(3, "2")
        bubbleNavigationLinearView.setBadgeValue(4, "") //empty badge

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}

            override fun onPageSelected(i: Int) {
                bubbleNavigationLinearView.setCurrentActiveItem(i)
            }

            override fun onPageScrollStateChanged(i: Int) {

            }
        })

        bubbleNavigationLinearView.setNavigationChangeListener { view, position ->
            viewPager.setCurrentItem(
                position,
                true
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

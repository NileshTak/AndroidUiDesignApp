package com.nilprojects.androiduidesign.Activities.BubbleNav

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.nilprojects.androiduidesign.Activities.BubbleNav.adapters.ScreenSlidePagerAdapter
import com.nilprojects.androiduidesign.Activities.BubbleNav.fragment.ScreenSlidePageFragment
import com.nilprojects.androiduidesign.R
import kotlinx.android.synthetic.main.activity_top_bar.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class TopBarActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_bar)

        supportActionBar!!.title = "Top Navigation Bar"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        val fragList = ArrayList<ScreenSlidePageFragment>()
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.restaurant), R.color.orange_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.room), R.color.red_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.happy), R.color.green_inactive))
        val pagerAdapter = ScreenSlidePagerAdapter(fragList, supportFragmentManager)
        view_pager.adapter = pagerAdapter
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                top_navigation_constraint.setCurrentActiveItem(p0)
            }

        })

        top_navigation_constraint.setNavigationChangeListener { _, position ->
            view_pager.setCurrentItem(position, true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

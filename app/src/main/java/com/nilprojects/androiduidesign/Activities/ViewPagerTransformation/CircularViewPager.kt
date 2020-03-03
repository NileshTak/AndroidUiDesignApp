package com.nilprojects.androiduidesign.Activities.ViewPagerTransformation

import android.content.Context
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.EighthFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.FifthFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.FirstFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.FourthFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.NinthFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.SecondFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.SeventhFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.SixthFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.TenthFragment
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments.ThirdFragment
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class CircularViewPager : AppCompatActivity() {

    internal var handler = Handler()

    lateinit var viewPager: ViewPager

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_view_pager)

        supportActionBar!!.title = "View Pager Transformation"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        viewPager = findViewById(R.id.viewPager)

        addFragment()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun addFragment() {

        val adapter = MyPagerAdapter(supportFragmentManager)

        val f1 = FirstFragment()
        val f2 = FirstFragment()
        val second = SecondFragment()
        val third = ThirdFragment()
        val fourth = FourthFragment()
        val fifth = FifthFragment()
        val sixth = SixthFragment()
        val seventh = SeventhFragment()
        val eight = EighthFragment()
        val ninth = NinthFragment()
        val t1 = TenthFragment()
        val t2 = TenthFragment()

        adapter.addFragments(t2)
        adapter.addFragments(f1)
        adapter.addFragments(second)
        adapter.addFragments(third)
        adapter.addFragments(fourth)
        adapter.addFragments(fifth)
        adapter.addFragments(sixth)
        adapter.addFragments(seventh)
        adapter.addFragments(eight)
        adapter.addFragments(ninth)
        adapter.addFragments(t1)
        adapter.addFragments(f2)

        viewPager.adapter = adapter
        viewPager.currentItem = 1

        viewPager.addOnPageChangeListener(MyPageListener())


    }


    private inner class MyPageListener : ViewPager.OnPageChangeListener {


        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }

        override fun onPageSelected(position: Int) {

            if (position == 0) {

                handler.postDelayed({ viewPager.setCurrentItem(10, false) }, 500)

            } else if (position == 11) {

                handler.postDelayed({ viewPager.setCurrentItem(1, false) }, 500)
            }

        }

        override fun onPageScrollStateChanged(state: Int) {

        }
    }

}
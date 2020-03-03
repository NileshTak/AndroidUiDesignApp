package com.nilprojects.androiduidesign.Activities.SpotsUi.Activity

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager

import com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter.MainViewPager1Adapter
import com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter.MainViewPagerAdapter
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.FifthFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.FourthFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.MainFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.SartscreenFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.SearchFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Utils.DrawFromBackTransformer
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

import java.util.Timer
import java.util.TimerTask


class MainActivitySpot : AppCompatActivity(), View.OnClickListener {

    lateinit var viewPager: ViewPager
    lateinit var viewPager1: ViewPager
    lateinit var mainViewPagerAdapter: MainViewPagerAdapter
    lateinit var mainViewPager1Adapter: MainViewPager1Adapter

    lateinit var frm1: FrameLayout
    lateinit var frm2: FrameLayout
    lateinit var frm3: FrameLayout
    lateinit var frm4: FrameLayout
    lateinit var frm5: FrameLayout
    lateinit var imv1: ImageView
    lateinit var imv2: ImageView
    lateinit var imv3: ImageView
    lateinit var imv4: ImageView
    lateinit var imv5: ImageView
    lateinit var lytcontainer: FrameLayout

    internal val mHandler = Handler()
    internal var mTimer: Timer? = Timer()
    internal var timestamp = 0

    internal var fragment: Fragment? = null
    internal var fragmentClass: Class<*>? = null


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_spotui)



        viewPager = findViewById<View>(R.id.view_pager3) as ViewPager
        mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = mainViewPagerAdapter
        viewPager.setPageTransformer(true, DrawFromBackTransformer())
        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    SartscreenFragment.lytappbar.setExpanded(true)
                    SartscreenFragment.scrollView.scrollTo(100, 0)

                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        viewPager1 = findViewById<View>(R.id.view_pager4) as ViewPager
        mainViewPager1Adapter = MainViewPager1Adapter(supportFragmentManager)
        viewPager1.adapter = mainViewPager1Adapter
        viewPager1.setPageTransformer(true, DrawFromBackTransformer())
        viewPager1.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    MainFragment.appBarLayout.setExpanded(true)
                    MainFragment.scrollView1.scrollTo(100, 0)

                    mTimer!!.cancel()
                    mTimer = null

                } else if (position == 1) {

                    timestamp = 0

                    if (mTimer != null) {
                        mTimer!!.cancel()
                        mTimer = null
                    }

                    mTimer = Timer()
                    val task = MyTimerTask()
                    mTimer!!.schedule(task, 0, 3000)
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        lytcontainer = findViewById<View>(R.id.frm_container) as FrameLayout

        viewPager.visibility = View.VISIBLE
        lytcontainer.visibility = View.GONE
        viewPager1.visibility = View.GONE


        frm1 = findViewById<View>(R.id.lyt_start1) as FrameLayout
        frm1.setOnClickListener(this)
        frm2 = findViewById<View>(R.id.lyt_start2) as FrameLayout
        frm2.setOnClickListener(this)
        frm3 = findViewById<View>(R.id.lyt_start3) as FrameLayout
        frm3.setOnClickListener(this)
        frm4 = findViewById<View>(R.id.lyt_start4) as FrameLayout
        frm5 = findViewById<View>(R.id.lyt_start5) as FrameLayout
        frm4.setOnClickListener(this)
        frm5.setOnClickListener(this)

        imv1 = findViewById<View>(R.id.imv_start1) as ImageView
        imv2 = findViewById<View>(R.id.imv_start2) as ImageView
        imv3 = findViewById<View>(R.id.imv_start3) as ImageView
        imv4 = findViewById<View>(R.id.imv_start4) as ImageView
        imv5 = findViewById<View>(R.id.imv_start5) as ImageView
        imv1.visibility = View.GONE
        imv2.visibility = View.VISIBLE
        imv3.visibility = View.VISIBLE
        imv4.visibility = View.VISIBLE
        imv5.visibility = View.VISIBLE


    }

    fun setstatus() {
        MainFragment.mLVRingProgress.progress = timestamp
    }

    override fun onClick(view: View) {
        when (view.id) {

            R.id.lyt_start1 -> {
                viewPager.visibility = View.VISIBLE
                viewPager.adapter = mainViewPagerAdapter
                viewPager.setPageTransformer(true, DrawFromBackTransformer())
                lytcontainer.visibility = View.GONE
                viewPager1.visibility = View.GONE
                tap1()
            }
            R.id.lyt_start2 -> {
                viewPager.visibility = View.GONE
                lytcontainer.visibility = View.GONE
                viewPager1.visibility = View.VISIBLE
                viewPager1.setCurrentItem(0, true)
                tap2()
            }
            R.id.lyt_start3 -> {

                viewPager.visibility = View.GONE
                lytcontainer.visibility = View.VISIBLE
                viewPager1.visibility = View.GONE
                beginTransction(SearchFragment())
                tap3()
            }
            R.id.lyt_start4 -> {
                viewPager.visibility = View.GONE
                lytcontainer.visibility = View.VISIBLE
                viewPager1.visibility = View.GONE
                beginTransction(FourthFragment())
                tap4()
            }
            R.id.lyt_start5 -> {
                viewPager.visibility = View.GONE
                lytcontainer.visibility = View.VISIBLE
                viewPager1.visibility = View.GONE
                beginTransction(FifthFragment())
                tap5()
            }
        }
    }

    fun tap1() {
        imv1.visibility = View.GONE
        imv2.visibility = View.VISIBLE
        imv3.visibility = View.VISIBLE
        imv4.visibility = View.VISIBLE
        imv5.visibility = View.VISIBLE
    }

    fun tap2() {
        imv2.visibility = View.GONE
        imv1.visibility = View.VISIBLE
        imv3.visibility = View.VISIBLE
        imv4.visibility = View.VISIBLE
        imv5.visibility = View.VISIBLE
    }

    fun tap3() {
        imv1.visibility = View.VISIBLE
        imv2.visibility = View.VISIBLE
        imv3.visibility = View.GONE
        imv4.visibility = View.VISIBLE
        imv5.visibility = View.VISIBLE
    }

    fun tap4() {
        imv1.visibility = View.VISIBLE
        imv2.visibility = View.VISIBLE
        imv3.visibility = View.VISIBLE
        imv4.visibility = View.GONE
        imv5.visibility = View.VISIBLE
    }

    fun tap5() {
        imv1.visibility = View.VISIBLE
        imv2.visibility = View.VISIBLE
        imv3.visibility = View.VISIBLE
        imv4.visibility = View.VISIBLE
        imv5.visibility = View.GONE
    }

    private inner class MyTimerTask : TimerTask() {
        override fun run() {
            mHandler.post {
                setstatus()
                timestamp += 5
            }
        }
    }

    fun beginTransction(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frm_container, fragment)
        // transaction.addToBackStack(null);
        transaction.commit()

    }
}

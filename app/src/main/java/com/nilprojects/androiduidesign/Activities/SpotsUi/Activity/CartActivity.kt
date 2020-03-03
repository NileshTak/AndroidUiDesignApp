package com.nilprojects.androiduidesign.Activities.SpotsUi.Activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.CartfirstFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.CartlistfourthFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.CartlistsecondFragment
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.CartthirdFragment
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper



class CartActivity : AppCompatActivity() {

    lateinit var firsttransaction: ImageView
    lateinit var secondtransaction: ImageView
    lateinit var thirdtransaction: ImageView
    lateinit var fourthtransaction: ImageView
    lateinit var firstwhiteiamge: ImageView
    lateinit var secondwhiteimage: ImageView
    lateinit var thirdwhiteimage: ImageView
    lateinit var fourthwhiteimage: ImageView
    lateinit var firstcompleteimage: ImageView
    lateinit var secondcompleteimage: ImageView
    lateinit var thirdcompleteimage: ImageView
    lateinit var fourthcompleteimage: ImageView
    lateinit var firstwhiteline: ImageView
    lateinit var secondwhiteline: ImageView
    lateinit var thirdwhiteline: ImageView

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        firsttransaction = findViewById<View>(R.id.imv_firsttransaction) as ImageView
        firsttransaction.visibility = View.VISIBLE
        secondtransaction = findViewById<View>(R.id.imv_secondtransaction) as ImageView
        secondtransaction.visibility = View.GONE
        thirdtransaction = findViewById<View>(R.id.imv_thirdtransaction) as ImageView
        thirdtransaction.visibility = View.GONE
        fourthtransaction = findViewById<View>(R.id.imv_fourthtransaction) as ImageView
        fourthtransaction.visibility = View.GONE

        firstwhiteiamge = findViewById<View>(R.id.imv_firstwhtecircle) as ImageView
        firstwhiteiamge.visibility = View.VISIBLE
        secondwhiteimage = findViewById<View>(R.id.imv_secondwhiteimage) as ImageView
        secondwhiteimage.visibility = View.VISIBLE
        secondwhiteimage.alpha = 0.65.toFloat()
        thirdwhiteimage = findViewById<View>(R.id.imv_thirdwhiteimage) as ImageView
        thirdwhiteimage.alpha = 0.65.toFloat()
        fourthwhiteimage = findViewById<View>(R.id.imv_fourthwhiteimage) as ImageView
        fourthwhiteimage.alpha = 0.65.toFloat()


        firstcompleteimage = findViewById<View>(R.id.imv_firstcheck) as ImageView
        firstcompleteimage.visibility = View.GONE
        secondcompleteimage = findViewById<View>(R.id.imv_secondcheck) as ImageView
        secondcompleteimage.visibility = View.GONE
        thirdcompleteimage = findViewById<View>(R.id.imv_thirdcomplete) as ImageView
        thirdcompleteimage.visibility = View.GONE
        fourthcompleteimage = findViewById<View>(R.id.imv_fourthcomplete) as ImageView
        fourthcompleteimage.visibility = View.GONE

        firstwhiteline = findViewById<View>(R.id.imv_firstwhiteline) as ImageView
        firstwhiteline.alpha = 0.5.toFloat()
        secondwhiteline = findViewById<View>(R.id.imv_secondwhiteline) as ImageView
        secondwhiteline.alpha = 0.5.toFloat()
        thirdwhiteline = findViewById<View>(R.id.imv_thirdwhiteline) as ImageView
        thirdwhiteline.alpha = 0.5.toFloat()


        val pager = findViewById<View>(R.id.viewper) as ViewPager
        pager.adapter = MyPagerAdapter(supportFragmentManager)

        pager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position == 0) {
                    firstwhiteline.alpha = (positionOffset + 0.5).toFloat()
                    secondwhiteimage.alpha = (positionOffset + 0.65).toFloat()
                } else if (position == 1) {
                    secondwhiteline.alpha = (positionOffset + 0.5).toFloat()
                    thirdwhiteimage.alpha = (positionOffset + 0.65).toFloat()
                } else if (position == 2) {
                    thirdwhiteline.alpha = (positionOffset + 0.5).toFloat()
                    fourthwhiteimage.alpha = (positionOffset + 0.65).toFloat()
                }


                Log.d("position===", "$position $positionOffset $positionOffsetPixels")

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    page1selected()
                } else if (position == 1) {
                    page2selected()
                } else if (position == 2) {
                    page3selected()
                } else if (position == 3) {
                    page4selected()
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(pos: Int): Fragment {
            when (pos) {

                0 -> return CartfirstFragment.newInstance()
                1 -> return CartlistsecondFragment.newInstance()
                2 -> return CartthirdFragment.newInstance()
                3 -> return CartlistfourthFragment.newInstance()
                else -> return CartfirstFragment.newInstance()
            }
        }

        override fun getCount(): Int {
            return 4
        }
    }

    fun page1selected() {
        firstwhiteline.alpha = 0.0.toFloat()
        firstwhiteiamge.visibility = View.VISIBLE
        firsttransaction.visibility = View.VISIBLE
        firstcompleteimage.visibility = View.GONE
        secondtransaction.visibility = View.GONE
    }

    fun page2selected() {
        firstwhiteline.alpha = 1.0.toFloat()
        firstwhiteiamge.visibility = View.GONE
        firsttransaction.visibility = View.GONE
        firstcompleteimage.visibility = View.VISIBLE
        secondtransaction.visibility = View.VISIBLE

        thirdtransaction.visibility = View.GONE
        secondcompleteimage.visibility = View.GONE
        secondwhiteimage.visibility = View.VISIBLE
        secondwhiteimage.alpha = 1.0.toFloat()


    }

    fun page3selected() {
        secondwhiteline.alpha = 1.0.toFloat()
        secondwhiteimage.visibility = View.GONE
        secondtransaction.visibility = View.GONE
        secondcompleteimage.visibility = View.VISIBLE
        thirdtransaction.visibility = View.VISIBLE

        fourthtransaction.visibility = View.GONE
        thirdcompleteimage.visibility = View.GONE
        thirdwhiteimage.visibility = View.VISIBLE
        thirdwhiteimage.alpha = 1.0.toFloat()
    }

    fun page4selected() {
        thirdwhiteline.alpha = 1.0.toFloat()
        thirdwhiteimage.visibility = View.GONE
        thirdtransaction.visibility = View.GONE
        thirdcompleteimage.visibility = View.VISIBLE
        fourthtransaction.visibility = View.VISIBLE


    }
}

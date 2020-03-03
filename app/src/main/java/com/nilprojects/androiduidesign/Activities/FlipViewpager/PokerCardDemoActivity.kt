package com.nilprojects.androiduidesign.Activities.FlipViewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

import com.nilprojects.androiduidesign.R
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer
import io.github.inflationx.viewpump.ViewPumpContextWrapper

import java.util.ArrayList

class PokerCardDemoActivity : AppCompatActivity() {

    lateinit var pokerViewPager: ViewPager
    private var pagerAdapter: PokerPagerAdapter? = null

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poker_card_demo)

        pokerViewPager = findViewById(R.id.pokerViewPager)
        pagerAdapter = PokerPagerAdapter(this)
        pokerViewPager.adapter = pagerAdapter

        val cardFlipPageTransformer = CardFlipPageTransformer()
        cardFlipPageTransformer.isScalable = false
        cardFlipPageTransformer.flipOrientation = CardFlipPageTransformer.VERTICAL
        pokerViewPager.setPageTransformer(true, cardFlipPageTransformer)

    }

    inner class PokerPagerAdapter(internal var context: Context) : PagerAdapter() {
        lateinit var mLayoutInflater: LayoutInflater
        internal var pages: ArrayList<*> = ArrayList<Any>()

        init {
            mLayoutInflater = LayoutInflater.from(context)

            pages.add(Any() as Nothing)
            pages.add(Any() as Nothing)
        }

        override fun getCount(): Int {
            return pages.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        // This method should create the page for the given position passed to it as an argument.
        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            val rootView = mLayoutInflater.inflate(R.layout.card_image_layout, container, false)
            val imgCardSide = rootView.findViewById<AppCompatImageView>(R.id.imgCardSide)
            imgCardSide.setOnClickListener {
                if (position == 0) {
                    pokerViewPager.setCurrentItem(1, true)
                } else {
                    pokerViewPager.setCurrentItem(0, true)
                }
            }
            val sides = intArrayOf(R.drawable.poker_card_front, R.drawable.poker_card_back)
            imgCardSide.setImageResource(sides[position])
            container.addView(rootView)
            return rootView

        }

        // Removes the page from the container for the given position.
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }
}

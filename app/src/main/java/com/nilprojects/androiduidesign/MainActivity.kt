
package com.nilprojects.androiduidesign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.FluidBottomNav
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.MeowNavBottom
import com.nilprojects.androiduidesign.Activities.ReadableBottomBar.ReadableBottomNav

import com.nilprojects.androiduidesign.Activities.TapBarMenu.TapBarMenu

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    private var mExpandableLayout: ExpandableLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switcher = findViewById<View>(R.id.switcher)

        mExpandableLayout = findViewById<ExpandableLayout>(R.id.expandableLayout)

        mExpandableLayout!!.setSwitcher(switcher)
        mExpandableLayout!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayout!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayout!!.setExpandDuration(800)
        mExpandableLayout!!.setCollapseDuration(400)

        mExpandableLayout!!.setOnStateChangedListener(object :
            ExpandableLayout.OnStateChangedListener {
           override fun onPreExpand() {
                Log.d("ExpandableLayout", "onPreExpand")
            }

            override fun onPreCollapse() {
                Log.d("ExpandableLayout", "onPreCollapse")
            }

            override fun onExpanded() {
                Log.d("ExpandableLayout", "onExpanded")
            }

            override fun onCollapsed() {
                Log.d("ExpandableLayout", "onCollapsed")
            }
        })
        findViewById<CardView>(R.id.CVBottomNav).setOnClickListener(View.OnClickListener {

            mExpandableLayout!!.toggle() }
        )

        findViewById<LinearLayout>(R.id.llTapBarMenu).setOnClickListener {
            var int = Intent(this,TapBarMenu :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llMeow).setOnClickListener {
            var int = Intent(this,MeowNavBottom :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llReadable).setOnClickListener {
            var int = Intent(this, ReadableBottomNav :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llSimple).setOnClickListener {
            var int = Intent(this, FluidBottomNav :: class.java)
            startActivity(int)
        }

    }
}

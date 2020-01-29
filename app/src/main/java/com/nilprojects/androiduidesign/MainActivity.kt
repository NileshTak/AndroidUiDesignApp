
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
import com.nilprojects.androiduidesign.Activities.BannerSlider.BannerSlider
import com.nilprojects.androiduidesign.Activities.CardPreviewAnim.CardPreview
import com.nilprojects.androiduidesign.Activities.ContextMenu.ContextMenu
import com.nilprojects.androiduidesign.Activities.CreativeViewPager.CreativeViewPager
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.FluidBottomNav
import com.nilprojects.androiduidesign.Activities.FragmentNavAnim.MainActivityNavFrag
import com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.SmartiestImageSlider
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.MeowNavBottom
import com.nilprojects.androiduidesign.Activities.MikepenzeNav.MaterialDrawerActivity
import com.nilprojects.androiduidesign.Activities.ReadableBottomBar.ReadableBottomNav
import com.nilprojects.androiduidesign.Activities.Ripple.Rippleeffect
import com.nilprojects.androiduidesign.Activities.SideMenu.MainActivitySideMenu
import com.nilprojects.androiduidesign.Activities.SlidingRootNav.SlidingRootNavActivity

import com.nilprojects.androiduidesign.Activities.TapBarMenu.TapBarMenu
import com.nilprojects.androiduidesign.Activities.ViewAnimation.MyActivity
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.ViewPagerTransformation
import kotlinx.android.synthetic.main.activity_main.*

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    lateinit var mExpandableLayout: ExpandableLayout
    lateinit var mExpandableLayoutAnim: ExpandableLayout
    private var mExpandableLayoutBannerSlider: ExpandableLayout? = null
    private var mExpandableLayoutSlider: ExpandableLayout? = null

    lateinit var expandableLayoutMenu : ExpandableLayout

    lateinit var switcher : View
    lateinit var switcherBanner : View
    lateinit var switcherAnim : View
    lateinit var switcherSlider : View

    lateinit var switcherMenu : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switcher = findViewById<View>(R.id.switcher)
        switcherSlider = findViewById<View>(R.id.switcherSlider)
        switcherMenu = findViewById<View>(R.id.switcherMenu)
        switcherAnim = findViewById<View>(R.id.switcherAnim)

        var cardview = findViewById<CardView>(R.id.cardview)
        cardview.setBackgroundResource(R.drawable.card_view_home_bg);

        switcherBanner = findViewById<View>(R.id.switcherPager)
        mExpandableLayoutBannerSlider = findViewById<ExpandableLayout>(R.id.expandableLayoutPager)
        expandableLayoutMenu = findViewById<ExpandableLayout>(R.id.expandableLayoutMenu)

        mExpandableLayout = findViewById<ExpandableLayout>(R.id.expandableLayout)
        mExpandableLayoutAnim = findViewById<ExpandableLayout>(R.id.expandableLayoutAnim)
        mExpandableLayoutSlider = findViewById<ExpandableLayout>(R.id.expandableLayoutSlider)


        setUpExpand()

//        mExpandableLayout!!.setOnStateChangedListener(object :
//            ExpandableLayout.OnStateChangedListener {
//           override fun onPreExpand() {
//                Log.d("ExpandableLayout", "onPreExpand")
//            }
//
//            override fun onPreCollapse() {
//                Log.d("ExpandableLayout", "onPreCollapse")
//            }
//
//            override fun onExpanded() {
//                Log.d("ExpandableLayout", "onExpanded")
//            }
//
//            override fun onCollapsed() {
//                Log.d("ExpandableLayout", "onCollapsed")
//            }
//        })

        findViewById<CardView>(R.id.CVBottomNav).setOnClickListener(View.OnClickListener {

            mExpandableLayout!!.toggle() }
        )

        findViewById<CardView>(R.id.CVSlider).setOnClickListener(View.OnClickListener {
            mExpandableLayoutSlider!!.toggle() }
        )

        findViewById<CardView>(R.id.CVPager).setOnClickListener(View.OnClickListener {
            mExpandableLayoutBannerSlider!!.toggle() }
        )

        findViewById<CardView>(R.id.CVMenu).setOnClickListener(View.OnClickListener {
            expandableLayoutMenu!!.toggle() }
        )


        findViewById<CardView>(R.id.CVAnim).setOnClickListener(View.OnClickListener {
            mExpandableLayoutAnim!!.toggle() }
        )

        findViewById<LinearLayout>(R.id.llTapBarMenu).setOnClickListener {
            var int = Intent(this,TapBarMenu :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llTransViewpager).setOnClickListener {
            var int = Intent(this,ViewPagerTransformation :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llRipple).setOnClickListener {
            var int = Intent(this,Rippleeffect :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llMeow).setOnClickListener {
            var int = Intent(this,MeowNavBottom :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llContextMenu).setOnClickListener {
            var int = Intent(this,ContextMenu :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llMaterialMenu).setOnClickListener {
            var int = Intent(this,MaterialDrawerActivity :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llSlidingRoot).setOnClickListener {
            var int = Intent(this,SlidingRootNavActivity :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llReadable).setOnClickListener {
            var int = Intent(this, ReadableBottomNav :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llSideMenu).setOnClickListener {
            var int = Intent(this, MainActivitySideMenu :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llSimple).setOnClickListener {
            var int = Intent(this, FluidBottomNav :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llSmarteistImageSlider).setOnClickListener {
            var int = Intent(this,SmartiestImageSlider :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llBannerSlider).setOnClickListener {
            var int = Intent(this,BannerSlider :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llCreative).setOnClickListener {
            var int = Intent(this,CreativeViewPager :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llCardPreview).setOnClickListener {
            var int = Intent(this,CardPreview :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llViewAnim).setOnClickListener {
            var int = Intent(this,MyActivity :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llFragNav).setOnClickListener {
            var int = Intent(this,MainActivityNavFrag :: class.java)
            startActivity(int)
        }

    }

    private fun setUpExpand() {

        mExpandableLayoutBannerSlider!!.setSwitcher(switcherBanner)
        mExpandableLayoutBannerSlider!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayoutBannerSlider!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayoutBannerSlider!!.setExpandDuration(800)
        mExpandableLayoutBannerSlider!!.setCollapseDuration(400)


        mExpandableLayoutAnim!!.setSwitcher(switcherAnim)
        mExpandableLayoutAnim!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayoutAnim!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayoutAnim!!.setExpandDuration(800)
        mExpandableLayoutAnim!!.setCollapseDuration(400)

        mExpandableLayout!!.setSwitcher(switcher)
        mExpandableLayout!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayout!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayout!!.setExpandDuration(800)
        mExpandableLayout!!.setCollapseDuration(400)

        mExpandableLayoutSlider!!.setSwitcher(switcherSlider)
        mExpandableLayoutSlider!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayoutSlider!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayoutSlider!!.setExpandDuration(800)
        mExpandableLayoutSlider!!.setCollapseDuration(400)


        expandableLayoutMenu!!.setSwitcher(switcherMenu)
        expandableLayoutMenu!!.setExpandInterpolator(BounceInterpolator())
        expandableLayoutMenu!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        expandableLayoutMenu!!.setExpandDuration(800)
        expandableLayoutMenu!!.setCollapseDuration(400)
    }
}

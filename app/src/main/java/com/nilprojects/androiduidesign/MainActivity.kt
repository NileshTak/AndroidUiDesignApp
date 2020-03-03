
package com.nilprojects.androiduidesign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.nilprojects.androiduidesign.Activities.Alerter.KotlinDemoActivity
import com.nilprojects.androiduidesign.Activities.BannerSlider.BannerSlider
import com.nilprojects.androiduidesign.Activities.BottomNavCustom.CustomBottomNav
import com.nilprojects.androiduidesign.Activities.CardPreviewAnim.CardPreview
import com.nilprojects.androiduidesign.Activities.ContextMenu.ContextMenu
import com.nilprojects.androiduidesign.Activities.CreativeViewPager.CreativeViewPager
import com.nilprojects.androiduidesign.Activities.ExpandableLayout.CustomActivity
import com.nilprojects.androiduidesign.Activities.ExpandableLayout.MainActivityExpandable
import com.nilprojects.androiduidesign.Activities.ExpandableView.MainActivityExpandableView
import com.nilprojects.androiduidesign.Activities.FlipViewpager.MainActivityFlip
import com.nilprojects.androiduidesign.Activities.FloatingNav.FloatingNav
import com.nilprojects.androiduidesign.Activities.FluidBottomNav.FluidBottomNav
import com.nilprojects.androiduidesign.Activities.FoldingCell.MainActivityFoldingCell
import com.nilprojects.androiduidesign.Activities.FragmentNavAnim.MainActivityNavFrag
import com.nilprojects.androiduidesign.Activities.LiquidSwipe.LiquidSwipeMainActivity
import com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.SmartiestImageSlider
import com.nilprojects.androiduidesign.Activities.MeowBottomNav.MeowNavBottom
import com.nilprojects.androiduidesign.Activities.MikepenzeNav.MaterialDrawerActivity
import com.nilprojects.androiduidesign.Activities.ReadableBottomBar.ReadableBottomNav
import com.nilprojects.androiduidesign.Activities.Ripple.Rippleeffect
import com.nilprojects.androiduidesign.Activities.SideMenu.MainActivitySideMenu
import com.nilprojects.androiduidesign.Activities.SlidingRootNav.SlidingRootNavActivity
import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.MainActivitySpot

import com.nilprojects.androiduidesign.Activities.TapBarMenu.TapBarMenu
import com.nilprojects.androiduidesign.Activities.TargetPrompt.MainActivityTargetPrompt
import com.nilprojects.androiduidesign.Activities.ViewAnimation.MyActivity
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.ViewPagerTransformation

import io.github.inflationx.viewpump.ViewPumpContextWrapper




class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    lateinit var mExpandableLayout: ExpandableLayout
    lateinit var mExpandableLayoutAnim: ExpandableLayout
    private var mExpandableLayoutBannerSlider: ExpandableLayout? = null
    private var expandableLayoutExpand1: ExpandableLayout? = null
    private var mExpandableLayoutSlider: ExpandableLayout? = null

    lateinit var expandableLayoutMenu : ExpandableLayout

    lateinit var switcher : View
    lateinit var switcherBanner : View
    lateinit var switcherAnim : View
    lateinit var switcherSlider : View
    lateinit var switcherExp1 : View

    lateinit var switcherMenu : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switcher = findViewById<View>(R.id.switcher)
        switcherSlider = findViewById<View>(R.id.switcherSlider)
        switcherMenu = findViewById<View>(R.id.switcherMenu)
        switcherAnim = findViewById<View>(R.id.switcherAnim)
        switcherExp1 = findViewById<View>(R.id.switcherExp1)

        var cardview = findViewById<CardView>(R.id.cardview)
        cardview.setBackgroundResource(R.drawable.card_view_home_bg);

        switcherBanner = findViewById<View>(R.id.switcherPager)
        mExpandableLayoutBannerSlider = findViewById<ExpandableLayout>(R.id.expandableLayoutPager)
        expandableLayoutMenu = findViewById<ExpandableLayout>(R.id.expandableLayoutMenu)

        mExpandableLayout = findViewById<ExpandableLayout>(R.id.expandableLayout)
        mExpandableLayoutAnim = findViewById<ExpandableLayout>(R.id.expandableLayoutAnim)
        mExpandableLayoutSlider = findViewById<ExpandableLayout>(R.id.expandableLayoutSlider)

        expandableLayoutExpand1 = findViewById<ExpandableLayout>(R.id.expandableLayoutExpand1)


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



        findViewById<CardView>(R.id.CVExpand).setOnClickListener(View.OnClickListener {
            expandableLayoutExpand1!!.toggle() }
        )

        findViewById<LinearLayout>(R.id.llTapBarMenu).setOnClickListener {
            var int = Intent(this,TapBarMenu :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llExpandableLayout).setOnClickListener {
            var int = Intent(this,CustomActivity :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llFoldingCell).setOnClickListener {
            var int = Intent(this,MainActivityFoldingCell :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llAlert).setOnClickListener {
            var int = Intent(this,KotlinDemoActivity :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llSpotUi).setOnClickListener {
            var int = Intent(this,MainActivitySpot :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llFlip).setOnClickListener {
            var int = Intent(this,MainActivityFlip :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llExpandingView).setOnClickListener {
            var int = Intent(this,MainActivityExpandableView :: class.java)
            startActivity(int)
        }



        findViewById<LinearLayout>(R.id.llTransViewpager).setOnClickListener {
            var int = Intent(this,ViewPagerTransformation :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llFloatingNav).setOnClickListener {
            var int = Intent(this,FloatingNav :: class.java)
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


        findViewById<LinearLayout>(R.id.llCustomNav).setOnClickListener {
            var int = Intent(this,CustomBottomNav :: class.java)
            startActivity(int)
        }


        findViewById<LinearLayout>(R.id.llTargetPrompt).setOnClickListener {
            var int = Intent(this,MainActivityTargetPrompt :: class.java)
            startActivity(int)
        }

        findViewById<LinearLayout>(R.id.llLiquid).setOnClickListener {
            var int = Intent(this,LiquidSwipeMainActivity :: class.java)
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

        findViewById<ImageView>(R.id.ivAbout).setOnClickListener {
            val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)

        }

    }


    override fun onBackPressed() {
         val exitBottomSheetFragment = ExitBottomSheetFragment()
        exitBottomSheetFragment.show(this@MainActivity.supportFragmentManager, exitBottomSheetFragment.tag)
   }



    private fun setUpExpand() {

        mExpandableLayoutBannerSlider!!.setSwitcher(switcherBanner)
        mExpandableLayoutBannerSlider!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayoutBannerSlider!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayoutBannerSlider!!.setExpandDuration(800)
        mExpandableLayoutBannerSlider!!.setCollapseDuration(400)


        expandableLayoutExpand1!!.setSwitcher(switcherExp1)
        expandableLayoutExpand1!!.setExpandInterpolator(BounceInterpolator())
        expandableLayoutExpand1!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        expandableLayoutExpand1!!.setExpandDuration(800)
        expandableLayoutExpand1!!.setCollapseDuration(400)


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

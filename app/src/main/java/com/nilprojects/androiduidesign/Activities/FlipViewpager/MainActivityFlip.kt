package com.nilprojects.androiduidesign.Activities.FlipViewpager



import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivityFlip : AppCompatActivity() {



    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    private lateinit var mPager: ViewPager
    private var mPagerAdapter: PagerAdapter? = null
    lateinit var radioGroupFlipAnimation: RadioGroup
    lateinit var checkEnableScale: CheckBox

    var bookFlipTransformer = BookFlipPageTransformer()
    var cardFlipTransformer = CardFlipPageTransformer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_flip)

        supportActionBar!!.title = "Flip View Pager"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        radioGroupFlipAnimation = findViewById(R.id.rgFlipAnimation)
        checkEnableScale = findViewById<CheckBox>(R.id.checkEnableScale)

        // Book Flip Transformer
        bookFlipTransformer.isEnableScale = true
        bookFlipTransformer.scaleAmountPercent = 10f

        // Card Flip Transformer
        cardFlipTransformer.isScalable = false
        cardFlipTransformer.flipOrientation = CardFlipPageTransformer.VERTICAL

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById<ViewPager>(R.id.pager)
        mPagerAdapter = DemoPagerAdapter(supportFragmentManager)
        mPager.adapter = mPagerAdapter
        mPager.clipToPadding = false

        updatePagerConfigs()

        radioGroupFlipAnimation.setOnCheckedChangeListener { radioGroup, id ->
            updatePagerConfigs()
        }

        checkEnableScale.setOnCheckedChangeListener { compoundButton, value ->
            updatePagerConfigs()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> {
                Utils.navigateToGithub("https://github.com/wajahatkarim3/EasyFlipViewPager",this)

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }




    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun updatePagerConfigs()
    {
        when(radioGroupFlipAnimation.checkedRadioButtonId)
        {
            R.id.radioBookFlip -> {
                bookFlipTransformer.isEnableScale = checkEnableScale.isChecked
                mPager.setPageTransformer(true, bookFlipTransformer)
            }
            R.id.radioCardFlip -> {
                cardFlipTransformer.isScalable = checkEnableScale.isChecked
                mPager.setPageTransformer(true, cardFlipTransformer)
            }
        }
    }

    class DemoPagerAdapter : FragmentPagerAdapter
    {
        var fragmentsList = arrayListOf<GalleryImageFragment>()

        constructor(fm: FragmentManager) : super(fm)
        {
            val titles = arrayOf(
                    "Book Onboarding",
                    "Poker Card",
                    "Pakistan Gallery"
            )

            val imageIds = intArrayOf(
                    R.drawable.books_snap,
                    R.drawable.poker_snap,
                    R.drawable.gallery_snap
            )

            for (i in 0 until imageIds.size)
            {
                var frag = GalleryImageFragment.newInstance(titles[i], null, imageIds[i])
                fragmentsList.add(frag)
            }
        }

        override fun getItem(position: Int): Fragment = fragmentsList[position]

        override fun getCount() = fragmentsList.size

    }
}

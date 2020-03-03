package com.nilprojects.androiduidesign.Activities.CardPreviewAnim

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import com.applikeysolutions.animation.BlurAnimation
import com.applikeysolutions.animation.orionpreview.ScaleAnimation
import com.applikeysolutions.animation.orionpreview.TranslationAnimation
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_card_preview.*
import kotlinx.android.synthetic.main.product_details_card.*

class CardPreview : AppCompatActivity() {

    lateinit var increaseAnimationImage : ScaleAnimation
    lateinit var decreaseAnimationImage : ScaleAnimation
    lateinit var increaseAnimationText : ScaleAnimation
    lateinit var decreaseAnimationText : ScaleAnimation
    lateinit var upAnimationImageView : TranslationAnimation
    lateinit var arcUpAnimationTv : TranslationAnimation
    lateinit var downAnimationImageView : TranslationAnimation
    lateinit var arcDownAnimationTv : TranslationAnimation
    lateinit var blurAnimation : BlurAnimation


    var screenHeight : Int? = null
    var screenWidth : Int? = null
    lateinit var blurredBitmap : Bitmap



    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_preview)
//        supportActionBar!!.title = "Card Preview Animation"
//        val actionbar = supportActionBar
//        actionbar!!.setDisplayHomeAsUpEnabled(true)

        getScreenSize()
        setProductBottomMargin()

        cv_product_details.setOnClickListener {
            upAnimationImageView.showAnimation()
            arcUpAnimationTv.showAnimation()
            increaseAnimationImage.showAnimation()
            increaseAnimationText.showAnimation()

            cv_product_details.setClickable(false)
            rl_container.setClickable(true)
            addBlur()
        }


        iv_back.setOnClickListener {
            finish()
        }

        btnCode.setOnClickListener {
            val url = "https://github.com/AKTDev/Card-Preview"
            Utils.navigateToGithub(url,this)
//            val intentGithub = Intent(Intent.ACTION_VIEW)
//            intentGithub.data = Uri.parse(url)
//            startActivity(intentGithub)
        }



        rl_container.setOnClickListener {
            downAnimationImageView.showAnimation();
            arcDownAnimationTv.showAnimation();
            decreaseAnimationImage.showAnimation();
            decreaseAnimationText.showAnimation();

            rl_container.setClickable(false);
            cv_product_details.setClickable(true);
            removeBlur();
        }



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getScreenSize() {
        val displaymetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        screenHeight = displaymetrics.heightPixels
        screenWidth = displaymetrics.widthPixels
    }

    private fun setProductBottomMargin() {
        ll_product_details.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    ll_product_details.viewTreeObserver.removeGlobalOnLayoutListener(this)
                } else {
                    ll_product_details.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }

                val params = cv_product_details.layoutParams as RelativeLayout.LayoutParams
                params.bottomMargin = ll_product_details.measuredHeight * -1
                cv_product_details.layoutParams = params
            }
        })
    }


    override fun onResume() {
        super.onResume()
        initAnimation()
    }


    private fun initAnimation() {
        tv_product_title.post {
            increaseAnimationImage = ScaleAnimation.ScaleAnimationBuilder(imgBackground, 1.5f, 1.5f).build()
            increaseAnimationText = ScaleAnimation.ScaleAnimationBuilder(tv_product_title, 2.25f, 2.25f).build()
            decreaseAnimationImage = ScaleAnimation.ScaleAnimationBuilder(imgBackground, 1f, 1f).build()
            decreaseAnimationText = ScaleAnimation.ScaleAnimationBuilder(tv_product_title, 1f, 1f).build()
            upAnimationImageView = TranslationAnimation.TranslationAnimationBuilder(cv_product_details,
                TranslationAnimation.TranslationMode.TranslationY, 0f, -(screenHeight!!.div(2.2f)))
                .build()
            arcUpAnimationTv = TranslationAnimation.TranslationAnimationBuilder(tv_product_title,
                TranslationAnimation.TranslationMode.TranslationAll, 0f, screenHeight!!.div(10f))
                .arcMode(TranslationAnimation.ArcMode.ArcUpward)
                .additionStartPoint(0f)
                .additionEndPoint(screenWidth!!.div(2f) - tv_product_title.width)
                .build()
            downAnimationImageView = TranslationAnimation.TranslationAnimationBuilder(cv_product_details,
                TranslationAnimation.TranslationMode.TranslationY, -(screenHeight!!.div(3f)), 0f)
                .build()
            arcDownAnimationTv = TranslationAnimation.TranslationAnimationBuilder(tv_product_title,
                TranslationAnimation.TranslationMode.TranslationAll, screenHeight!!.div(7f), 0f)
                .arcMode(TranslationAnimation.ArcMode.ArcDownard)
                .additionStartPoint(screenWidth!!.div(2f) - tv_product_title.width)
                .additionEndPoint(0f)
                .build()

            blurAnimation = BlurAnimation.BlurAnimationBuilder(0.4f, 7f).build()
            val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.sample_background)
            blurredBitmap = blurAnimation.blur(this@CardPreview, originalBitmap)
        }
    }


    private fun addBlur() {
        imgBackground.setImageBitmap(BitmapDrawable(resources, blurredBitmap).bitmap)
    }

    private fun removeBlur() {
        imgBackground.setImageResource(R.drawable.sample_background)
    }
}
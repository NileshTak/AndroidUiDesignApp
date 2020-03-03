package com.nilprojects.androiduidesign.Activities.ViewPagerTransformation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View

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
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.AntiClockSpinTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.Clock_SpinTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.CubeInDepthTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.CubeInRotationTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.CubeInScalingTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.CubeOutDepthTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.CubeOutRotationTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.CubeOutScalingTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.DepthTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.FadeOutTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.FanTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.FidgetSpinTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.GateTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.HingeTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.HorizontalFlipTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.PopTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.SimpleTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.SlowTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.SpinnerTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.TossTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.VerticalFlipTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.VerticalShutTransformation
import com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Transformations.ZoomOutTransformation
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper


class TransformationActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var pagerAdapter: MyPagerAdapter
//     var intent: Intent

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transformation)

        supportActionBar!!.title = "View Pager Transformation"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        viewPager = findViewById<View>(R.id.viewPager) as ViewPager

        pagerAdapter = MyPagerAdapter(supportFragmentManager)
        addingFragmentsTOpagerAdapter()
        viewPager.adapter = pagerAdapter

        val slowTransformation = SlowTransformation()
        val simpleTransformation = SimpleTransformation()
        val depthTransformation = DepthTransformation()
        val zoomOutTransformation = ZoomOutTransformation()
        val clockSpinTransformation = Clock_SpinTransformation()
        val antiClockSpinTransformation = AntiClockSpinTransformation()
        val fidgetSpinTransformation = FidgetSpinTransformation()
        val verticalFlipTransformation = VerticalFlipTransformation()
        val horizontalFlipTransformation = HorizontalFlipTransformation()
        val popTransformation = PopTransformation()
        val fadeOutTransformation = FadeOutTransformation()
        val cubeOutRotationTransformation = CubeOutRotationTransformation()
        val cubeInRotationTransformation = CubeInRotationTransformation()
        val cubeOutScalingTransformation = CubeOutScalingTransformation()
        val cubeInScalingTransformation = CubeInScalingTransformation()
        val cubeOutDepthTransformation = CubeOutDepthTransformation()
        val cubeInDepthTransformation = CubeInDepthTransformation()
        val hingeTransformation = HingeTransformation()
        val gateTransformation = GateTransformation()
        val tossTransformation = TossTransformation()
        val fanTransformation = FanTransformation()
        val spinnerTransformation = SpinnerTransformation()
        val verticalShutTransformation = VerticalShutTransformation()


        var intent = getIntent()
        val transformation = intent.getStringExtra(Constant.TRANSFORMATION)


        when (transformation) {
            Constant.SLOW_TRANSFORMATION -> viewPager.setPageTransformer(true, slowTransformation)
            Constant.SIMPLE_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                simpleTransformation
            )
            Constant.DEPTH_TRANSFORMATION -> viewPager.setPageTransformer(true, depthTransformation)
            Constant.ZOOM_OUT_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                zoomOutTransformation
            )
            Constant.CLOCK_SPIN_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                clockSpinTransformation
            )
            Constant.ANTICLOCK_SPIN_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                antiClockSpinTransformation
            )
            Constant.FIDGET_SPINNER_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                fidgetSpinTransformation
            )
            Constant.VERTICAL_FLIP_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                verticalFlipTransformation
            )
            Constant.HORIZONTAL_FLIP_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                horizontalFlipTransformation
            )
            Constant.POP_TRANSFORMATION -> viewPager.setPageTransformer(true, popTransformation)
            Constant.FADE_OUT_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                fadeOutTransformation
            )
            Constant.CUBE_OUT_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                cubeOutRotationTransformation
            )
            Constant.CUBE_IN_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                cubeInRotationTransformation
            )
            Constant.CUBE_OUT_SCALING_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                cubeOutScalingTransformation
            )
            Constant.CUBE_IN_SCALING_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                cubeInScalingTransformation
            )
            Constant.CUBE_OUT_DEPTH_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                cubeOutDepthTransformation
            )
            Constant.CUBE_IN_DEPTH_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                cubeInDepthTransformation
            )
            Constant.HINGE_TRANSFORMATION -> viewPager.setPageTransformer(true, hingeTransformation)
            Constant.GATE_TRANSFORMATION -> viewPager.setPageTransformer(true, gateTransformation)
            Constant.TOSS_TRANSFORMATION -> viewPager.setPageTransformer(true, tossTransformation)
            Constant.FAN_TRANSFORMATION -> viewPager.setPageTransformer(true, fanTransformation)
            Constant.SPINNER_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                spinnerTransformation
            )
            Constant.VERTICAL_SHUT_TRANSFORMATION -> viewPager.setPageTransformer(
                true,
                verticalShutTransformation
            )
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun addingFragmentsTOpagerAdapter() {
        pagerAdapter.addFragments(FirstFragment())
        pagerAdapter.addFragments(SecondFragment())
        pagerAdapter.addFragments(ThirdFragment())
        pagerAdapter.addFragments(FourthFragment())
        pagerAdapter.addFragments(FifthFragment())
        pagerAdapter.addFragments(SixthFragment())
        pagerAdapter.addFragments(SeventhFragment())
        pagerAdapter.addFragments(EighthFragment())
        pagerAdapter.addFragments(NinthFragment())
        pagerAdapter.addFragments(TenthFragment())
    }

}
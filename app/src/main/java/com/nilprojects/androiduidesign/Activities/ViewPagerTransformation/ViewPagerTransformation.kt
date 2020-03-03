package com.nilprojects.androiduidesign.Activities.ViewPagerTransformation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper




class ViewPagerTransformation : AppCompatActivity(), View.OnClickListener  {


    lateinit var simple: Button
    lateinit var depth:Button
    lateinit var zoomOut:Button
    lateinit var clock_Spin:Button
    lateinit var antiClock_Spin:Button
    lateinit var fidgetSpinner:Button
    lateinit var vertical_Flip:Button
    lateinit var horizontal_Flip:Button
    lateinit var pop:Button
    lateinit var fadeOut:Button

    lateinit var cubeOut: Button
    lateinit var cubeIn:Button
    lateinit var cubeOutScale:Button
    lateinit var cubeInScale:Button
    lateinit var cubeOutDepth:Button
    lateinit var cubeInDepth:Button
    lateinit var hinge:Button
    lateinit var gate:Button
    lateinit var toss:Button
    lateinit var fan:Button
    lateinit var spinner:Button
    lateinit var vertical_Shut:Button

    lateinit var slow: Button
    lateinit var circular:Button

    lateinit var floatingActionButton: FloatingActionButton


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_view_pager_transformation)
            supportActionBar!!.title = "View Pager Transformation"
            val actionbar = supportActionBar
            actionbar!!.setDisplayHomeAsUpEnabled(true)

            floatingActionButton = findViewById(R.id.fab) as FloatingActionButton
            floatingActionButton.setOnClickListener(View.OnClickListener {
                val url = "https://github.com/dipanshukr/ViewPagerTransformations"
                val intentGithub = Intent(Intent.ACTION_VIEW)
                intentGithub.data = Uri.parse(url)
                startActivity(intentGithub)
            })

            //method where we initialise buttons
            intialiseButtons()

            //method where listner is attached to ezch buttons
            attachListner()

        }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

        private fun intialiseButtons() {
            slow = findViewById(R.id.slowTransformation) as Button
            circular = findViewById(R.id.circularViewpagerTransformation) as Button
            simple = findViewById(R.id.simpleTransformation) as Button
            depth = findViewById(R.id.depthTransformation) as Button
            zoomOut = findViewById(R.id.zoomOutTransformation) as Button
            clock_Spin = findViewById(R.id.clockSpinTransformation) as Button
            antiClock_Spin = findViewById(R.id.antiClockSpinTransformation) as Button
            fidgetSpinner = findViewById(R.id.fidgetSpinTransformation) as Button
            vertical_Flip = findViewById(R.id.verticalFlipTransformation) as Button
            horizontal_Flip = findViewById(R.id.horizontalFlipTransformation) as Button
            pop = findViewById(R.id.popTransformation) as Button
            fadeOut = findViewById(R.id.fadeOutTransformation) as Button
            cubeOut = findViewById(R.id.cubeOutTransformation) as Button
            cubeIn = findViewById(R.id.cubeInTransformation) as Button
            cubeOutScale = findViewById(R.id.cubeOutScalingTransformation) as Button
            cubeInScale = findViewById(R.id.cubeInScalingTransformation) as Button
            cubeOutDepth = findViewById(R.id.cubeOutDepthTransformation) as Button
            cubeInDepth = findViewById(R.id.cubeInDepthTransformation) as Button
            hinge = findViewById(R.id.hingeTransformation) as Button
            gate = findViewById(R.id.gateTransformation) as Button
            toss = findViewById(R.id.tossTransformation) as Button
            fan = findViewById(R.id.fanTransformation) as Button
            spinner = findViewById(R.id.spinnerTransformation) as Button
            vertical_Shut = findViewById(R.id.verticalShutTransformation) as Button

        }

        private fun attachListner() {
            slow.setOnClickListener(this)
            circular.setOnClickListener(this)
            simple.setOnClickListener(this)
            depth.setOnClickListener(this)
            zoomOut.setOnClickListener(this)
            clock_Spin.setOnClickListener(this)
            antiClock_Spin.setOnClickListener(this)
            fidgetSpinner.setOnClickListener(this)
            vertical_Flip.setOnClickListener(this)
            horizontal_Flip.setOnClickListener(this)
            pop.setOnClickListener(this)
            fadeOut.setOnClickListener(this)
            cubeOut.setOnClickListener(this)
            cubeIn.setOnClickListener(this)
            cubeOutScale.setOnClickListener(this)
            cubeInScale.setOnClickListener(this)
            cubeOutDepth.setOnClickListener(this)
            cubeInDepth.setOnClickListener(this)
            hinge.setOnClickListener(this)
            gate.setOnClickListener(this)
            toss.setOnClickListener(this)
            fan.setOnClickListener(this)
            spinner.setOnClickListener(this)
            vertical_Shut.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.slowTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.SLOW_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.circularViewpagerTransformation -> startActivity(
                    Intent(
                        this@ViewPagerTransformation,
                        CircularViewPager::class.java
                    )
                )
                R.id.simpleTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.SIMPLE_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.depthTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.DEPTH_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.zoomOutTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.ZOOM_OUT_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.clockSpinTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.CLOCK_SPIN_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.antiClockSpinTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.ANTICLOCK_SPIN_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.fidgetSpinTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.FIDGET_SPINNER_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.verticalFlipTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.VERTICAL_FLIP_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.horizontalFlipTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(
                        Constant.TRANSFORMATION,
                        Constant.HORIZONTAL_FLIP_TRANSFORMATION
                    )
                    startActivity(intent)
                }
                R.id.popTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.POP_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.fadeOutTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.FADE_OUT_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.cubeOutTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.CUBE_OUT_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.cubeInTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.CUBE_IN_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.cubeOutScalingTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(
                        Constant.TRANSFORMATION,
                        Constant.CUBE_OUT_SCALING_TRANSFORMATION
                    )
                    startActivity(intent)
                }
                R.id.cubeInScalingTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(
                        Constant.TRANSFORMATION,
                        Constant.CUBE_IN_SCALING_TRANSFORMATION
                    )
                    startActivity(intent)
                }
                R.id.cubeOutDepthTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.CUBE_OUT_DEPTH_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.cubeInDepthTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.CUBE_IN_DEPTH_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.hingeTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.HINGE_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.gateTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.GATE_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.tossTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.TOSS_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.fanTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.FAN_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.spinnerTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.SPINNER_TRANSFORMATION)
                    startActivity(intent)
                }
                R.id.verticalShutTransformation -> {
                    intent = Intent(this@ViewPagerTransformation, TransformationActivity::class.java)
                    intent.putExtra(Constant.TRANSFORMATION, Constant.VERTICAL_SHUT_TRANSFORMATION)
                    startActivity(intent)
                }
            }
        }

    }

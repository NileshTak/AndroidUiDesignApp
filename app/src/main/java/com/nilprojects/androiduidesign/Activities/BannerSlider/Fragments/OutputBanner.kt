package com.nilprojects.androiduidesign.Activities.BannerSlider.Fragments

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat

import com.nilprojects.androiduidesign.R
import ss.com.bannerslider.Slider
import ss.com.bannerslider.indicators.IndicatorShape


class OutputBanner : Fragment() {

    private var slider: Slider? = null
    lateinit var intervalSeekBar : SeekBar
    lateinit var loopSlidesSwitch : SwitchCompat
    lateinit var indicatorSizeSeekBar : SeekBar
    lateinit var hideIndicatorsSwitch : SwitchCompat
    lateinit var spinner : Spinner
    lateinit var mustAnimateIndicators : SwitchCompat


    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_output_banner, container, false)

        slider = view.findViewById<Slider>(R.id.banner_slider1)
        intervalSeekBar = view.findViewById<SeekBar>(R.id.seekbar_interval)
        indicatorSizeSeekBar = view.findViewById<SeekBar>(R.id.seekbar_indicator_size)
        loopSlidesSwitch = view.findViewById<SwitchCompat>(R.id.checkbox_loop_slides)

        hideIndicatorsSwitch = view.findViewById<SwitchCompat>(R.id.checkbox_hide_indicators)

        mustAnimateIndicators = view.findViewById<SwitchCompat>(R.id.checkbox_animate_indicators)
        spinner = view.findViewById<Spinner>(R.id.spinner_page_indicator)


        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage("Wait a Sec....Fetching Images")
        progressDialog.setCancelable(false)
        progressDialog.show()


        Slider.init(PicassoImageLoadingService(activity))
        setupViews()

        return view
    }
    private fun setupViews() {

        setupPageIndicatorChooser()
        setupSettingsUi()


        //delay for testing empty view functionality
        slider!!.postDelayed(Runnable {
            slider!!.setAdapter(MainSliderAdapter())
            slider!!.setSelectedSlide(0)
            progressDialog.dismiss()
        }, 1000)

    }

    private fun setupSettingsUi() {

        intervalSeekBar.setMax(10000)
        intervalSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    slider!!.setInterval(i)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        indicatorSizeSeekBar.setMax(resources.getDimensionPixelSize(R.dimen.max_slider_indicator_size))
        indicatorSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    slider!!.setIndicatorSize(i)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })


        loopSlidesSwitch.setChecked(true)
        mustAnimateIndicators.setChecked(true)

        loopSlidesSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            slider!!.setLoopSlides(
                b
            )
        })

        mustAnimateIndicators.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            slider!!.setAnimateIndicators(
                b
            )
        })

        hideIndicatorsSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                slider!!.hideIndicators()
            } else {
                slider!!.showIndicators()
            }
        })
    }


    private fun setupPageIndicatorChooser() {

        val pageIndicatorsLabels = resources.getStringArray(R.array.page_indicators)

        val arrayAdapter = ArrayAdapter(
            activity!!.applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            pageIndicatorsLabels
        )

        spinner.setAdapter(arrayAdapter)

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                when (i) {
                    0 -> slider!!.setIndicatorStyle(IndicatorShape.CIRCLE)
                    1 -> slider!!.setIndicatorStyle(IndicatorShape.DASH)
                    2 -> slider!!.setIndicatorStyle(IndicatorShape.ROUND_SQUARE)
                    3 -> slider!!.setIndicatorStyle(IndicatorShape.SQUARE)
                    4 -> {
                        slider!!.setSelectedSlideIndicator(
                            ContextCompat.getDrawable(
                                activity!!.applicationContext,
                                R.drawable.selected_slide_indicator
                            )
                        )
                        slider!!.setUnSelectedSlideIndicator(
                            ContextCompat.getDrawable(
                                activity!!.applicationContext,
                                R.drawable.unselected_slide_indicator
                            )
                        )
                    }
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        })
    }
}

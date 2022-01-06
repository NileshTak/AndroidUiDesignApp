package com.nilprojects.androiduidesign.Activities.RubberPicker.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import android.content.Context
import android.net.Uri
import kotlinx.android.synthetic.main.fragment_code_rubber.*


class CodeRubber : Fragment() {
    lateinit var xmlData : TextView
    lateinit var kotlinData : TextView
    lateinit var tvTapDependency : TextView
    lateinit var tvTapGradle : TextView
    var TapXmlData = "<com.jem.rubberpicker.RubberSeekBar\n"+
                        "...\n"+
                   " app:minValue=\"20\" \n"+
                    "app:maxValue=\"80\"\n"+
                   " app:elasticBehavior=\"cubic\"\n"+
                   " app:dampingRatio=\"0.3\"\n"+
                  "  app:stiffness=\"300\"\n"+
                   " app:stretchRange=\"24dp\"\n"+
                    "app:defaultThumbRadius=\"16dp\"\n"+
                   " app:normalTrackWidth=\"4dp\"\n"+
                   " app:highlightTrackWidth=\"8dp\"\n"+
                 "   app:normalTrackColor=\"#AAAAAA\"\n"+
                   " app:highlightTrackColor=\"#BA1F33\"\n"+
                   " app:defaultThumbInsideColor=\"#FFF\"\n"+
                  "  app:highlightDefaultThumbOnTouchColor=\"#CD5D67\"/>\n"+

                "<!-- Similar attributes can be applied for RubberRangePicker as well-->\n"+
               " <com.jem.rubberpicker.RubberRangePicker\n"+
                   " ...\n"+
               " app:minValue=\"0\"\n"+
                "app:maxValue=\"100\"\n"+
               " app:elasticBehavior=\"linear\"\n"+
              "  app:dampingRatio=\"0.4\"\n"+
               " app:stiffness=\"400\"\n"+
               " app:stretchRange=\"36dp\"\n"+
                "app:defaultThumbRadius=\"16dp\"\n"+
                "app:normalTrackWidth=\"4dp\"\n"+
              "  app:highlightTrackWidth=\"8dp\"\n"+
               " app:normalTrackColor=\"#AAAAAA\"\n"+
            "    app:highlightTrackColor=\"#BA1F33\"\n"+
            "    app:defaultThumbInsideColor=\"#CFCD5D67\"\n"+
             "   app:highlightDefaultThumbOnTouchColor=\"#CD5D67\"/>\n"

    var TapKotlinData = "val rubberSeekBar = RubberSeekBar(this)\n"+
                       " rubberSeekBar.setMin(20)\n"+
                        "rubberSeekBar.setMax(80)\n"+
                        "rubberSeekBar.setElasticBehavior(ElasticBehavior.CUBIC)\n"+
                        "rubberSeekBar.setDampingRatio(0.4F)\n"+
                       " rubberSeekBar.setStiffness(1000F)\n"+
                       " rubberSeekBar.setStretchRange(50f)\n"+
                       " rubberSeekBar.setThumbRadius(32f)\n"+
                        "rubberSeekBar.setNormalTrackWidth(2f)\n"+
                       " rubberSeekBar.setHighlightTrackWidth(4f)\n"+
                        "rubberSeekBar.setNormalTrackColor(Color.GRAY)\n"+
                       " rubberSeekBar.setHighlightTrackColor(Color.BLUE)\n"+
                      "  rubberSeekBar.setHighlightThumbOnTouchColor(Color.CYAN)\n"+
                        "rubberSeekBar.setDefaultThumbInsideColor(Color.WHITE)\n"+

                      "  val currentValue = rubberSeekBar.getCurrentValue()\n"+
                       " rubberSeekBar.setCurrentValue(currentValue + 10)\n"+
                       " rubberSeekBar.setOnRubberSeekBarChangeListener(object : RubberSeekBar.OnRubberSeekBarChangeListener {\n"+
                          "  override fun onProgressChanged(seekBar: RubberSeekBar, value: Int, fromUser: Boolean) {}\n"+
                         "   override fun onStartTrackingTouch(seekBar: RubberSeekBar) {}\n"+
                            "override fun onStopTrackingTouch(seekBar: RubberSeekBar) {}\n"+
                        "})\n"+


                        "Similarly for RubberRangePicker\n"+
                        "val rubberRangePicker = RubberRangePicker(this)\n"+
                        "rubberRangePicker.setMin(20)\n"+
                        "...\n"+
                        "rubberRangePicker.setHighlightThumbOnTouchColor(Color.CYAN)\n"+

                        "val startThumbValue = rubberRangePicker.getCurrentStartValue()\n"+
                        "rubberRangePicker.setCurrentStartValue(startThumbValue + 10)\n"+
                        "val endThumbValue = rubberRangePicker.getCurrentEndValue()\n"+
                        "rubberRangePicker.setCurrentEndValue(endThumbValue + 10)\n"+
                        "rubberRangePicker.setOnRubberRangePickerChangeListener(object: RubberRangePicker.OnRubberRangePickerChangeListener{\n"+
                            "override fun onProgressChanged(rangePicker: RubberRangePicker, startValue: Int, endValue: Int, fromUser: Boolean) {}\n"+
                            "override fun onStartTrackingTouch(rangePicker: RubberRangePicker, isStartThumb: Boolean) {}\n"+
                            "override fun onStopTrackingTouch(rangePicker: RubberRangePicker, isStartThumb: Boolean) {}\n"+
                       " })\n"

    var dependency = "implementation 'com.github.Chrisvin:RubberPicker:v1.5'"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_code_rubber, container, false)


        xmlData = view.findViewById<TextView>(R.id.xmlDataRub)
        kotlinData = view.findViewById<TextView>(R.id.kotlinDataRub)
        tvTapDependency = view.findViewById<TextView>(R.id.tvRubDependency)
        var fabRubGit = view.findViewById<FloatingActionButton>(R.id.fabRubGit)

        xmlData.text = TapXmlData

        tvTapDependency.text = dependency
        kotlinData.text = TapKotlinData

        fabRubGit.setOnClickListener {
            val url = "https://github.com/Chrisvin/RubberPicker"
            Utils.navigateToGithub(url, kotlinData.context)
        }

        return view
    }

}
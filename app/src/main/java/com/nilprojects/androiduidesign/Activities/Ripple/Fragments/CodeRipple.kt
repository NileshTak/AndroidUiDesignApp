package com.nilprojects.androiduidesign.Activities.Ripple.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nilprojects.androiduidesign.R

class CodeRipple : Fragment() {

    lateinit var xmlData : TextView
    lateinit var kotlinData : TextView
    lateinit var tvTapDependency : TextView
    lateinit var tvTapGradle : TextView
    var TapXmlData = "<com.skyfishjy.library.RippleBackground\n" +
            "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:id=\"@+id/content\"\n" +
            "    app:rb_color=\"#0099CC\"\n" +
            "    app:rb_radius=\"32dp\"\n" +
            "    app:rb_rippleAmount=\"6\"\n" +
            "    app:rb_duration=\"3000\"\n" +
            "    app:rb_scale=\"6\">\n" +
            "    <ImageView\n" +
            "        android:layout_width=\"64dp\"\n" +
            "        android:layout_height=\"64dp\"\n" +
            "        android:layout_centerInParent=\"true\"\n" +
            "        android:id=\"@+id/centerImage\"\n" +
            "        android:src=\"@drawable/phone1\"/>\n" +
            "    <ImageView\n" +
            "        android:layout_width=\"64dp\"\n" +
            "        android:layout_height=\"64dp\"\n" +
            "        android:id=\"@+id/foundDevice\"\n" +
            "        android:layout_above=\"@id/centerImage\"\n" +
            "        android:layout_marginBottom=\"32dp\"\n" +
            "        android:layout_toLeftOf=\"@id/centerImage\"\n" +
            "        android:layout_marginRight=\"6dp\"\n" +
            "        android:src=\"@drawable/phone2\"\n" +
            "        android:visibility=\"invisible\"/>\n" +
            "</com.skyfishjy.library.RippleBackground>\n"

    var TapKotlinData = "class OutputRipple : Fragment() {\n" +
            "\n" +
            "    private var foundDevice: ImageView? = null\n" +
            "\n" +
            "    override fun onCreateView(\n" +
            "        inflater: LayoutInflater, container: ViewGroup?,\n" +
            "        savedInstanceState: Bundle?\n" +
            "    ): View? {\n" +
            "        // Inflate the layout for this fragment\n" +
            "        val view = inflater.inflate(R.layout.fragment_output, container, false)\n" +
            "\n" +
            "        val rippleBackground = view.findViewById(R.id.content) as RippleBackground\n" +
            "\n" +
            "        val handler = Handler()\n" +
            "\n" +
            "        foundDevice = view.findViewById(R.id.foundDevice) as ImageView\n" +
            "        val button = view.findViewById(R.id.centerImage) as ImageView\n" +
            "        button.setOnClickListener {\n" +
            "            rippleBackground.startRippleAnimation()\n" +
            "            handler.postDelayed({ foundDevice() }, 3000)\n" +
            "        }\n" +
            "\n" +
            "        return view\n" +
            "    }\n" +
            "\n" +

            "    @SuppressLint(\"ObjectAnimatorBinding\")\n" +
            "    private fun foundDevice() {\n" +
            "        val animatorSet = AnimatorSet()\n" +
            "        animatorSet.duration = 400\n" +
            "        animatorSet.interpolator = AccelerateDecelerateInterpolator()\n" +
            "        val animatorList = ArrayList<Animator>()\n" +
            "        val scaleXAnimator = ObjectAnimator.ofFloat(foundDevice, \"ScaleX\", 0f, 1.2f, 1f)\n" +
            "        animatorList.add(scaleXAnimator)\n" +
            "        val scaleYAnimator = ObjectAnimator.ofFloat(foundDevice, \"ScaleY\", 0f, 1.2f, 1f)\n" +
            "        animatorList.add(scaleYAnimator)\n" +
            "        animatorSet.playTogether(animatorList)\n" +
            "        foundDevice!!.setVisibility(View.VISIBLE)\n" +
            "        animatorSet.start()\n" +
            "    }\n" +

            "}\n"

    var dependency = "implementation 'com.skyfishjy.ripplebackground:library:1.0.1'"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_code2, container, false)


        xmlData = view.findViewById<TextView>(R.id.xmlDataRip)
        kotlinData = view.findViewById<TextView>(R.id.kotlinDataRip)
        tvTapDependency = view.findViewById<TextView>(R.id.tvRipDependency)

        xmlData.text = TapXmlData

        tvTapDependency.text = dependency
        kotlinData.text = TapKotlinData

        return view
    }

}
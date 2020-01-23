package com.nilprojects.androiduidesign.Activities.Ripple.Fragments

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView

import com.nilprojects.androiduidesign.R
import com.skyfishjy.library.RippleBackground
import java.util.ArrayList

class OutputRipple : Fragment() {

    private var foundDevice: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_output, container, false)

        val rippleBackground = view.findViewById(R.id.content) as RippleBackground

        val handler = Handler()

        foundDevice = view.findViewById(R.id.foundDevice) as ImageView
        val button = view.findViewById(R.id.centerImage) as ImageView
        button.setOnClickListener {
            rippleBackground.startRippleAnimation()
            handler.postDelayed({ foundDevice() }, 3000)
        }

        return view
    }



    @SuppressLint("ObjectAnimatorBinding")
    private fun foundDevice() {
        val animatorSet = AnimatorSet()
        animatorSet.duration = 400
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        val animatorList = ArrayList<Animator>()
        val scaleXAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleX", 0f, 1.2f, 1f)
        animatorList.add(scaleXAnimator)
        val scaleYAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleY", 0f, 1.2f, 1f)
        animatorList.add(scaleYAnimator)
        animatorSet.playTogether(animatorList)
        foundDevice!!.setVisibility(View.VISIBLE)
        animatorSet.start()
    }

}
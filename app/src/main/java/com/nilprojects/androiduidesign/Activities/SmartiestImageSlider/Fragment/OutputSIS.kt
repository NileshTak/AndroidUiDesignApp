package com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.Fragment

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.FirebaseFirestore

import com.nilprojects.androiduidesign.R
import com.nilprojects.androiduidesign.SliderImgClass
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import java.util.ArrayList


class OutputSIS : Fragment() {

    lateinit var sliderView: SliderView
    lateinit var sliderView2: SliderView
    lateinit var arr : ArrayList<String>

    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_output_si, container, false)

        sliderView = view.findViewById<SliderView>(R.id.imageSlider)


        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage("Wait a Sec....Fetching Images")
        progressDialog.setCancelable(false)
        progressDialog.show()
        sliderView2 = view.findViewById<SliderView>(R.id.imageSlider2)

        fetchSliderImages()

        return view
    }

    private fun fetchSliderImages() {
        var db = FirebaseFirestore.getInstance()
        db.collection("SliderImages").document("Images")
            .get()
            .addOnSuccessListener { documentSnapshot ->

                val city = documentSnapshot.toObject(SliderImgClass :: class.java)
                if (city != null) {
                    arr = arrayListOf<String>()
                    arr.add(city.Img1)
                    arr.add(city.Img2)
                    arr.add(city.Img3)
                    arr.add(city.Img4)
                    arr.add(city.Img5)


                    val adapter = SliderAdapterExample(activity!!.applicationContext,arr)
                    sliderView.startAutoCycle()
                    sliderView.sliderAdapter = adapter
                    sliderView2.startAutoCycle()
                    sliderView2.sliderAdapter = adapter


                    sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                    sliderView.sliderIndicatorSelectedColor = Color.WHITE
                    sliderView.sliderIndicatorUnselectedColor = Color.GRAY
                    sliderView.setSliderTransformAnimation(SliderAnimations.CUBEOUTDEPTHTRANSFORMATION)
                    sliderView.scrollTimeInSec = 4 //set scroll delay in seconds :

                    sliderView.setOnIndicatorClickListener { position -> sliderView.currentPagePosition = position }


                    sliderView2.setIndicatorAnimation(IndicatorAnimations.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                    sliderView2.sliderIndicatorSelectedColor = Color.WHITE
                    sliderView2.sliderIndicatorUnselectedColor = Color.GRAY
                    sliderView2.setIndicatorAnimation(IndicatorAnimations.DROP)
                    sliderView2.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION)
                    sliderView2.scrollTimeInSec = 4 //set scroll delay in seconds :

                    sliderView2.setOnIndicatorClickListener { position -> sliderView.currentPagePosition = position }

                }

                progressDialog.dismiss()
            }

            .addOnFailureListener { exception ->
                Log.w("SocietyFirestore", "No Images Found", exception)
            }
    }

}
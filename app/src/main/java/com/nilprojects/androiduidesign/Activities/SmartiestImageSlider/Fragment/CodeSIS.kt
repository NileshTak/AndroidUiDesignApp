package com.nilprojects.androiduidesign.Activities.SmartiestImageSlider.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nilprojects.androiduidesign.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CodeSIS : Fragment() {

    lateinit var xmlDataSIS : TextView
    lateinit var kotlinDataSIS : TextView
    lateinit var tvDependencySIS : TextView
    lateinit var tvAdapterSIS :TextView



    var AdapterSIS = "class SliderAdapterExample(private val context: Context, private val arr: ArrayList<String>) :\n" +
            "    SliderViewAdapter<SliderAdapterExample.SliderAdapterVH>() {\n" +
            "\n" +
            "    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {\n" +
            "        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null)\n" +
            "        return SliderAdapterVH(inflate)\n" +
            "    }\n" +
            "\n" +
            "    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {\n" +
            "\n" +
            "        when (position) {\n" +
            "            0 -> Glide.with(viewHolder.itemView)\n" +
            "                    .load(arr[0]).into(viewHolder.imageViewBackground)\n" +
            "            1 -> Glide.with(viewHolder.itemView)\n" +
            "                    .load(arr[1])\n" +
            "                    .into(viewHolder.imageViewBackground)\n" +
            "            2 -> Glide.with(viewHolder.itemView)\n" +
            "                    .load(arr[2])\n" +
            "                    .into(viewHolder.imageViewBackground)\n" +
            "            3 -> Glide.with(viewHolder.itemView)\n" +
            "                    .load(arr[3])\n" +
            "                    .into(viewHolder.imageViewBackground)\n" +
            "            4 -> Glide.with(viewHolder.itemView)\n" +
            "                .load(arr[4])\n" +
            "                .into(viewHolder.imageViewBackground)\n" +
            "            else -> Glide.with(viewHolder.itemView)\n" +
            "                    .load(arr[0])\n" +
            "                    .into(viewHolder.imageViewBackground)\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    override fun getCount(): Int {\n" +
            "        //slider view count could be dynamic size\n" +
            "        return 4\n" +
            "    }\n" +
            "\n" +
            "    inner class SliderAdapterVH(internal var itemView: View) : SliderViewAdapter.ViewHolder(itemView) {\n" +
            "        internal var imageViewBackground: ImageView\n" +
            "\n" +
            "        init {\n" +
            "            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider)\n" +
            "        }\n" +
            "    }\n" +
            "}\n"



    var XmlDataSIS = "<RelativeLayout\n " +
            "xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    tools:context=\".Activities.TapBarMenu.TapBarMenu\">\n" +
            "\n" +
            "    <com.google.android.material.tabs.TabLayout\n" +
            "        android:id=\"@+id/tabLayoutSIS\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"wrap_content\"\n" +
            "\n" +
            "        android:minHeight=\"?actionBarSize\"\n" +
            "        app:tabGravity=\"fill\"\n" +
            "\n" +
            "        app:tabIconTint=\"@color/colorPrimary\"\n" +
            "        app:tabRippleColor=\"@color/colorPrimary\"\n" +
            "        app:tabSelectedTextColor=\"@color/colorPrimary\"\n" +
            "        app:tabIndicatorColor=\"@color/colorPrimary\"\n" +
            "        app:tabIndicatorHeight=\"4dp\"\n" +
            "        app:tabBackground=\"@color/white\"\n" +
            "        >\n" +
            "    </com.google.android.material.tabs.TabLayout>\n" +
            "\n" +
            "    <androidx.viewpager.widget.ViewPager\n" +
            "\n" +
            "        android:id=\"@+id/viewPagerSIS\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_below=\"@+id/tabLayoutSIS\"\n" +
            "        android:layout_marginTop=\"10dp\"\n" +
            "        android:layout_height=\"match_parent\">\n" +
            "    </androidx.viewpager.widget.ViewPager>\n" +
            "\n" +
            "\n" +
            "</RelativeLayout>"

    var KotlinDataSIS = "class MainActivity1 : AppCompatActivity() {\n" +
            "\n" +
            "\n" +
            "     lateinit var sliderView: SliderView\n" +
            "    lateinit var sliderView2: SliderView\n" +
            "    lateinit var arr : ArrayList<String>\n" +
            "\n" +
            "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
            "        super.onCreate(savedInstanceState)\n" +
            "        setContentView(R.layout.activity_main)\n" +
            "\n" +
            "         sliderView = view.findViewById<SliderView>(R.id.imageSlider)\n" +
            "        sliderView2 = view.findViewById<SliderView>(R.id.imageSlider2)\n" +
            "\n" +
            "        fetchSliderImages()\n" +


            "        }\n" +

            "         private fun fetchSliderImages() {\n" +

            "                    arr.add(IMG1 URL)\n" +
            "                    arr.add(IMG5 URL)\n" +
            "                    arr.add(IMG4 URL)\n" +
            "                    arr.add(IMG3 URL)\n" +
            "                    arr.add(IMG2 URL)\n" +
            "\n" +
            "\n" +
            "                    val adapter = SliderAdapterExample(activity!!.applicationContext,arr)\n" +
            "                    sliderView.startAutoCycle()\n" +
            "                    sliderView.sliderAdapter = adapter\n" +
            "                    sliderView2.startAutoCycle()\n" +
            "                    sliderView2.sliderAdapter = adapter\n" +
            "\n" +
            "\n" +
            "                    sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!\n" +
            "                    sliderView.sliderIndicatorSelectedColor = Color.WHITE\n" +
            "                    sliderView.sliderIndicatorUnselectedColor = Color.GRAY\n" +
            "                    sliderView.setSliderTransformAnimation(SliderAnimations.CUBEOUTDEPTHTRANSFORMATION)\n" +
            "                    sliderView.scrollTimeInSec = 4 //set scroll delay in seconds :\n" +
            "\n" +
            "                    sliderView.setOnIndicatorClickListener { position -> sliderView.currentPagePosition = position }\n" +
            "\n" +
            "\n" +
            "                    sliderView2.setIndicatorAnimation(IndicatorAnimations.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!\n" +
            "                    sliderView2.sliderIndicatorSelectedColor = Color.WHITE\n" +
            "                    sliderView2.sliderIndicatorUnselectedColor = Color.GRAY\n" +
            "                    sliderView2.setIndicatorAnimation(IndicatorAnimations.DROP)\n" +
            "                    sliderView2.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION)\n" +
            "                    sliderView2.scrollTimeInSec = 4 //set scroll delay in seconds :\n" +
            "\n" +
            "                    sliderView2.setOnIndicatorClickListener { position -> sliderView.currentPagePosition = position }\n" +
            "\n" +
            "                }\n" +

            "\n" +
            "}"

    var dependencySIS = "implementation 'com.github.smarteist:autoimageslider:1.3.1'"

    var customLayout = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:orientation=\"vertical\">\n" +
            "\n" +
            "    <ImageView\n" +
            "        android:id=\"@+id/iv_auto_image_slider\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"match_parent\"\n" +
            "        android:scaleType=\"fitXY\" />\n" +
            "\n" +
            "</FrameLayout>"

    lateinit var tvCustom : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_code_si, container, false)


        xmlDataSIS = view.findViewById<TextView>(R.id.xmlDataSIS)
        kotlinDataSIS = view.findViewById<TextView>(R.id.kotlinDataSIS)

        tvDependencySIS = view.findViewById<TextView>(R.id.tvDependencySIS)
        tvAdapterSIS = view.findViewById<TextView>(R.id.kotlinAdapterSIS)
        tvCustom = view.findViewById<TextView>(R.id.tvcustomLayoutSIS)

        xmlDataSIS.text =  XmlDataSIS
        tvAdapterSIS.text = AdapterSIS
        tvCustom.text = customLayout


        tvDependencySIS.text = dependencySIS
        kotlinDataSIS.text =  KotlinDataSIS


        return view
    }
}
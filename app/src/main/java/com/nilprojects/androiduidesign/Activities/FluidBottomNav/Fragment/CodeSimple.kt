package com.nilprojects.androiduidesign.Activities.FluidBottomNav.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nilprojects.androiduidesign.R


class CodeSimple : Fragment() {

    lateinit var tvMeowXmlData : TextView
    lateinit var tvMeowKotlinData : TextView
    lateinit var tvMeowDependency : TextView
    lateinit var tvMeowGradle : TextView


    var dependency = " implementation 'com.gauravk.bubblenavigation:bubblenavigation:1.0.7'"
    var gradle ="allprojects {\n" +
            "    repositories {\n" +
            "        google()\n" +
            "        jcenter()\n" +
            "    }\n" +
            "}"
    var xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    tools:context=\".Activities.BubbleNav.BottomBarActivity\">\n" +
            "\n" +
            "    <androidx.viewpager.widget.ViewPager\n" +
            "        android:id=\"@+id/view_pager\"\n" +
            "        android:layout_width=\"0dp\"\n" +
            "        android:layout_height=\"0dp\"\n" +
            "        app:layout_constraintBottom_toTopOf=\"@id/bottom_navigation_view_linear\"\n" +
            "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
            "        app:layout_constraintHorizontal_bias=\"1.0\"\n" +
            "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
            "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
            "        app:layout_constraintVertical_bias=\"0.0\" />\n" +
            "\n" +
            "    <com.gauravk.bubblenavigation.BubbleNavigationLinearView\n" +
            "        android:id=\"@+id/bottom_navigation_view_linear\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"wrap_content\"\n" +
            "        android:background=\"@color/white\"\n" +
            "        android:elevation=\"8dp\"\n" +
            "        android:orientation=\"horizontal\"\n" +
            "        android:padding=\"12dp\"\n" +
            "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
            "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
            "        app:layout_constraintStart_toStartOf=\"parent\">\n" +
            "\n" +
            "        <com.gauravk.bubblenavigation.BubbleToggleView\n" +
            "            android:id=\"@+id/l_item_home\"\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            app:bt_active=\"true\"\n" +
            "            app:bt_colorActive=\"@color/red_active\"\n" +
            "            app:bt_colorInactive=\"@color/red_inactive\"\n" +
            "            app:bt_icon=\"@drawable/ic_home\"\n" +
            "            app:bt_shape=\"@drawable/transition_background_drawable_home\"\n" +
            "            app:bt_title=\"@string/home\" />\n" +
            "\n" +
            "        <com.gauravk.bubblenavigation.BubbleToggleView\n" +
            "            android:id=\"@+id/l_item_search\"\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            app:bt_badgeBackgroundColor=\"@color/green_active\"\n" +
            "            app:bt_colorActive=\"@color/blue_active\"\n" +
            "            app:bt_colorInactive=\"@color/blue_inactive\"\n" +
            "            app:bt_icon=\"@drawable/ic_search\"\n" +
            "            app:bt_shape=\"@drawable/transition_background_drawable_search\"\n" +
            "            app:bt_title=\"@string/search\" />\n" +
            "\n" +
            "        <com.gauravk.bubblenavigation.BubbleToggleView\n" +
            "            android:id=\"@+id/l_item_profile_list\"\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            app:bt_colorActive=\"@color/blue_grey_active\"\n" +
            "            app:bt_colorInactive=\"@color/blue_grey_inactive\"\n" +
            "            app:bt_icon=\"@drawable/ic_like\"\n" +
            "            app:bt_shape=\"@drawable/transition_background_drawable_like\"\n" +
            "            app:bt_title=\"@string/likes\" />\n" +
            "\n" +
            "        <com.gauravk.bubblenavigation.BubbleToggleView\n" +
            "            android:id=\"@+id/l_item_notification\"\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            app:bt_colorActive=\"@color/green_active\"\n" +
            "            app:bt_colorInactive=\"@color/green_inactive\"\n" +
            "            app:bt_icon=\"@drawable/ic_playlist\"\n" +
            "            app:bt_shape=\"@drawable/transition_background_drawable_list\"\n" +
            "            app:bt_title=\"@string/notification\" />\n" +
            "\n" +
            "        <com.gauravk.bubblenavigation.BubbleToggleView\n" +
            "            android:id=\"@+id/l_item_profile\"\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            app:bt_colorActive=\"@color/purple_active\"\n" +
            "            app:bt_colorInactive=\"@color/purple_inactive\"\n" +
            "            app:bt_icon=\"@drawable/ic_person\"\n" +
            "            app:bt_shape=\"@drawable/transition_background_drawable_person\"\n" +
            "            app:bt_title=\"@string/profile\" />\n" +
            "    </com.gauravk.bubblenavigation.BubbleNavigationLinearView>\n" +
            "\n" +
            "</androidx.constraintlayout.widget.ConstraintLayout>"

    var kotlind = "class BottomBarActivity : AppCompatActivity() {\n" +
            "\n" +
            "    override fun attachBaseContext(newBase: Context?) {\n" +
            "        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
            "        super.onCreate(savedInstanceState)\n" +
            "        setContentView(R.layout.activity_bottom_bar)\n" +
            "\n" +
            "        val fragList = ArrayList<ScreenSlidePageFragment>()\n" +
            "        fragList.add(\n" +
            "            ScreenSlidePageFragment.newInstance(\n" +
            "                getString(R.string.home),\n" +
            "                R.color.red_inactive\n" +
            "            )\n" +
            "        )\n" +
            "        fragList.add(\n" +
            "            ScreenSlidePageFragment.newInstance(\n" +
            "                getString(R.string.search),\n" +
            "                R.color.blue_inactive\n" +
            "            )\n" +
            "        )\n" +
            "        fragList.add(\n" +
            "            ScreenSlidePageFragment.newInstance(\n" +
            "                getString(R.string.likes),\n" +
            "                R.color.blue_grey_inactive\n" +
            "            )\n" +
            "        )\n" +
            "        fragList.add(\n" +
            "            ScreenSlidePageFragment.newInstance(\n" +
            "                getString(R.string.notification),\n" +
            "                R.color.green_inactive\n" +
            "            )\n" +
            "        )\n" +
            "        fragList.add(\n" +
            "            ScreenSlidePageFragment.newInstance(\n" +
            "                getString(R.string.profile),\n" +
            "                R.color.purple_inactive\n" +
            "            )\n" +
            "        )\n" +
            "        val pagerAdapter = ScreenSlidePagerAdapter(fragList, supportFragmentManager)\n" +
            "\n" +
            "        val bubbleNavigationLinearView =\n" +
            "            findViewById<BubbleNavigationLinearView>(R.id.bottom_navigation_view_linear)\n" +
            "        bubbleNavigationLinearView.setTypeface(Typeface.createFromAsset(assets, \"rubik.ttf\"))\n" +
            "\n" +
            "        bubbleNavigationLinearView.setBadgeValue(0, \"40\")\n" +
            "        bubbleNavigationLinearView.setBadgeValue(1, null) //invisible badge\n" +
            "        bubbleNavigationLinearView.setBadgeValue(2, \"7\")\n" +
            "        bubbleNavigationLinearView.setBadgeValue(3, \"2\")\n" +
            "        bubbleNavigationLinearView.setBadgeValue(4, \"\") //empty badge\n" +
            "\n" +
            "        val viewPager = findViewById<ViewPager>(R.id.view_pager)\n" +
            "        viewPager.adapter = pagerAdapter\n" +
            "        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {\n" +
            "            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}\n" +
            "\n" +
            "            override fun onPageSelected(i: Int) {\n" +
            "                bubbleNavigationLinearView.setCurrentActiveItem(i)\n" +
            "            }\n" +
            "\n" +
            "            override fun onPageScrollStateChanged(i: Int) {\n" +
            "\n" +
            "            }\n" +
            "        })\n" +
            "\n" +
            "        bubbleNavigationLinearView.setNavigationChangeListener { view, position ->\n" +
            "            viewPager.setCurrentItem(\n" +
            "                position,\n" +
            "                true\n" +
            "            )\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    override fun onSupportNavigateUp(): Boolean {\n" +
            "        onBackPressed()\n" +
            "        return true\n" +
            "    }\n" +
            "}\n"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_code_bubble, container, false)

        tvMeowXmlData = view.findViewById<TextView>(R.id.tvBubbleXMLData)
        tvMeowKotlinData = view.findViewById<TextView>(R.id.tvBubbleKotlinData)
        tvMeowGradle = view.findViewById<TextView>(R.id.tvBubbleGradle)
        tvMeowDependency = view.findViewById<TextView>(R.id.tvBubbleDependency)

        tvMeowDependency.text = dependency
        tvMeowGradle.text = gradle
        tvMeowKotlinData.text = kotlind
        tvMeowXmlData.text = xml

        return view
    }

}
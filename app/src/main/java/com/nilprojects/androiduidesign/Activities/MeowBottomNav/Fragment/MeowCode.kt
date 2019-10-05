package com.nilprojects.androiduidesign.Activities.MeowBottomNav.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nilprojects.androiduidesign.R

class MeowCode : Fragment() {

    lateinit var tvMeowXmlData : TextView
    lateinit var tvMeowKotlinData : TextView
    lateinit var tvMeowDependency : TextView
    lateinit var tvMeowGradle : TextView


    var dependency = " implementation 'com.etebarian:meow-bottom-navigation:1.0.4'"
    var gradle ="allprojects {\n" +
            "    repositories {\n" +
            "        google()\n" +
            "        jcenter()\n" +
            "    }\n" +
            "}"
    var xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "\n" +
            "    android:orientation=\"vertical\">\n" +
            "\n" +
            "    <LinearLayout\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"match_parent\"\n" +
            "        android:gravity=\"center\"\n" +
            "        android:background=\"@color/colorPrimary\"\n" +
            "        android:layout_marginTop=\"50dp\"\n" +
            "        android:orientation=\"vertical\">\n" +
            "\n" +
            "        <ImageView\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            android:src=\"@drawable/img_meow_large\" />\n" +
            "\n" +
            "        <TextView\n" +
            "            android:id=\"@+id/tv_selected\"\n" +
            "            android:layout_width=\"match_parent\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            android:layout_marginTop=\"16dp\"\n" +
            "            android:gravity=\"center\"\n" +
            "            android:textColor=\"@color/white\"\n" +
            "            android:textSize=\"16sp\" />\n" +
            "\n" +
            "    </LinearLayout>\n" +
            "\n" +
            "\n" +
            "    <com.etebarian.meowbottomnavigation.MeowBottomNavigation\n" +
            "        android:id=\"@+id/bottomNavigation\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"wrap_content\"\n" +
            "        android:layout_gravity=\"bottom\"\n" +
            "        app:mbn_backgroundBottomColor=\"#ffffff\"\n" +
            "        app:mbn_countBackgroundColor=\"#ff6f00\"\n" +
            "        app:mbn_countTextColor=\"#ffffff\"\n" +
            "        app:mbn_defaultIconColor=\"#90a4ae\"\n" +
            "        app:mbn_rippleColor=\"#2f424242\"\n" +
            "        app:mbn_selectedIconColor=\"#3c415e\"\n" +
            "        app:mbn_shadowColor=\"#1f212121\" />\n" +
            "\n" +
            "</FrameLayout>"

    var kotlind = "class MainActivity : AppCompatActivity() {\n" +
            "\n" +
            "    companion object {\n" +
            "        private const val ID_HOME = 1\n" +
            "        private const val ID_EXPLORE = 2\n" +
            "        private const val ID_MESSAGE = 3\n" +
            "        private const val ID_NOTIFICATION = 4\n" +
            "        private const val ID_ACCOUNT = 5\n" +
            "    }\n" +
            "\n" +
            "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
            "        super.onCreate(savedInstanceState)\n" +
            "        setContentView(R.layout.activity_main)\n" +
            "\n" +
            "        tv_selected.typeface = Typeface.createFromAsset(assets, \"fonts/SourceSansPro-Regular.ttf\")\n" +
            "\n" +
            "        bottomNavigation.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))\n" +
            "        bottomNavigation.add(MeowBottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore))\n" +
            "        bottomNavigation.add(MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message))\n" +
            "        bottomNavigation.add(MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification))\n" +
            "        bottomNavigation.add(MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account))\n" +
            "\n" +
            "        bottomNavigation.setCount(ID_NOTIFICATION, \"3\")\n" +
            "\n" +
            "        bottomNavigation.setOnShowListener {\n" +
            "            val name = when (it.id) {\n" +
            "                ID_HOME -> \"HOME\"\n" +
            "                ID_EXPLORE -> \"EXPLORE\"\n" +
            "                ID_MESSAGE -> \"MESSAGE\"\n" +
            "                ID_NOTIFICATION -> \"NOTIFICATION\"\n" +
            "                ID_ACCOUNT -> \"ACCOUNT\"\n" +
            "                else -> \"\"\n" +
            "            }\n" +
            "            tv_selected.text = \"name page is selected\"\n" +
            "        }\n" +
            "\n" +
            "        bottomNavigation.setOnClickMenuListener {\n" +
            "            val name = when (it.id) {\n" +
            "                ID_HOME -> \"HOME\"\n" +
            "                ID_EXPLORE -> \"EXPLORE\"\n" +
            "                ID_MESSAGE -> \"MESSAGE\"\n" +
            "                ID_NOTIFICATION -> \"NOTIFICATION\"\n" +
            "                ID_ACCOUNT -> \"ACCOUNT\"\n" +
            "                else -> \"\"\n" +
            "            }\n" +
            "            Toast.makeText(this, \"name is clicked\", Toast.LENGTH_SHORT).show()\n" +
            "        }\n" +
            "    }\n" +
            "}\n"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_meow_code, container, false)

        tvMeowXmlData = view.findViewById<TextView>(R.id.tvMeowXMLData)
        tvMeowKotlinData = view.findViewById<TextView>(R.id.tvMeowKotlinData)
        tvMeowGradle = view.findViewById<TextView>(R.id.tvMeowGradle)
        tvMeowDependency = view.findViewById<TextView>(R.id.tvMeowDependency)

        tvMeowDependency.text = dependency
        tvMeowGradle.text = gradle
        tvMeowKotlinData.text = kotlind
        tvMeowXmlData.text = xml

        return view
    }
}
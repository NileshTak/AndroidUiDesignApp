package com.nilprojects.androiduidesign.Activities.ReadableBottomBar.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nilprojects.androiduidesign.R
import kotlinx.android.synthetic.main.fragment_code.*


class Code : Fragment() {

    lateinit var tvReadXmlData : TextView
    lateinit var tvReadKotlinData : TextView
    lateinit var tvReadDependency : TextView
    lateinit var tvReadGradle : TextView
    lateinit var tvReadXmlTabData : TextView

    var dependency = " implementation 'com.github.iammert:ReadableBottomBar:0.2'"
    var gradle = "allprojects {\n" +
            "    repositories {\n" +
            "        ...\n" +
            "        maven { url 'https://jitpack.io' }\n" +
            "    }\n" +
            "}\n"

    var kotlind = "class MainActivity : AppCompatActivity() {\n" +
            "\n" +
            "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
            "        super.onCreate(savedInstanceState)\n" +
            "        setContentView(R.layout.activity_main)\n" +
            "\n" +
            "        nav.setOnItemSelectListener( object :ReadableBottomBar.ItemSelectListener{\n" +
            "            override fun onItemSelected(index: Int) {\n" +
            "                when(index)\n" +
            "                {\n" +
            "                    0 -> {\n" +
            "                        Toast.makeText(this@MainActivity,\"Home Activity Clicked\",Toast.LENGTH_LONG).show()\n" +
            "                    }\n" +
            "                    1 -> {\n" +
            "                        Toast.makeText(this@MainActivity,\"Search Activity Clicked\",Toast.LENGTH_LONG).show()\n" +
            "                    }\n" +
            "                    2 -> {\n" +
            "                        Toast.makeText(this@MainActivity,\"Bag Activity Clicked\",Toast.LENGTH_LONG).show()\n" +
            "                    }\n" +
            "                    3 -> {\n" +
            "                        Toast.makeText(this@MainActivity,\"Orders Activity Clicked\",Toast.LENGTH_LONG).show()\n" +
            "                    }\n" +
            "                    4 -> {\n" +
            "                        Toast.makeText(this@MainActivity,\"Profile Activity Clicked\",Toast.LENGTH_LONG).show()\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "}\n"

    var xmlD = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<RelativeLayout\n" +
            "        xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "        xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "        xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"match_parent\"\n" +
            "        tools:context=\".MainActivity\">\n" +
            "\n" +
            "    <com.iammert.library.readablebottombar.ReadableBottomBar\n" +
            "            android:id=\"@+id/nav\"\n" +
            "            android:layout_width=\"match_parent\"\n" +
            "            android:layout_alignParentBottom=\"true\"\n" +
            "            android:layout_height=\"64dp\"\n" +
            "            app:rbb_tabs=\"@xml/tabs\"/>\n" +
            "\n" +
            "</RelativeLayout>"

    var xmltab = "Create xml directory in res directory and create tabs resource file in xml directory and put this code into that file" +
            "\n\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<tabs>\n" +
            "    <tab\n" +
            "        drawable=\"@drawable/ic_home_black_24dp\"\n" +
            "        text=\"@string/home\" />\n" +
            "\n" +
            "    <tab\n" +
            "        drawable=\"@drawable/ic_search_black_24dp\"\n" +
            "        text=\"@string/search\" />\n" +
            "\n" +
            "    <tab\n" +
            "        drawable=\"@drawable/ic_shopping_basket_black_24dp\"\n" +
            "        text=\"@string/bag\" />\n" +
            "\n" +
            "    <tab\n" +
            "        drawable=\"@drawable/ic_favorite_black_24dp\"\n" +
            "        text=\"@string/favorite\" />\n" +
            "\n" +
            "    <tab\n" +
            "        drawable=\"@drawable/ic_account_circle_black_24dp\"\n" +
            "        text=\"@string/profile\" />\n" +
            "</tabs>"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_code, container, false)

        tvReadXmlData = view.findViewById<TextView>(R.id.tvReadXmlData )
        tvReadKotlinData = view.findViewById<TextView>(R.id.tvReadKotlinData)
        tvReadGradle = view.findViewById<TextView>(R.id.tvReadGradle)
        tvReadDependency = view.findViewById<TextView>(R.id.tvReadDependency)
        tvReadXmlTabData = view.findViewById<TextView>(R.id.tvReadXmlTabData)


        tvReadXmlData.text = xmlD
        tvReadKotlinData.text = kotlind
        tvReadDependency.text = dependency
        tvReadGradle.text = gradle
        tvReadXmlTabData.text = xmltab




        return view
    }
}
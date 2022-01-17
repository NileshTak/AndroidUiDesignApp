package com.nilprojects.androiduidesign.Activities.FoldingTapBar.Fragment

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

/**
 * A simple [Fragment] subclass.
 * Use the [folding_tap_code.newInstance] factory method to
 * create an instance of this fragment.
 */
class folding_tap_code : Fragment() {
    lateinit var xmlData : TextView
    lateinit var kotlinData : TextView
    lateinit var tvTapDependency : TextView
    lateinit var tvTapGradle : TextView
    var TapXmlData ="Menu Item xml\n" +
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<menu xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
            "    <item\n" +
            "        android:id=\"@+id/ftb_menu_nearby\"\n" +
            "        android:icon=\"@drawable/ic_nearby_icon\"\n" +
            "        android:title=\"Nearby\"/>\n" +
            "\n" +
            "    <item\n" +
            "        android:id=\"@+id/ftb_menu_new_chat\"\n" +
            "        android:icon=\"@drawable/ic_new_chat_icon\"\n" +
            "        android:title=\"Chat\"/>\n" +
            "\n" +
            "    <item\n" +
            "        android:id=\"@+id/ftb_menu_profile\"\n" +
            "        android:icon=\"@drawable/ic_profile_icon\"\n" +
            "        android:title=\"Profile\"/>\n" +
            "\n" +
            "    <item\n" +
            "        android:id=\"@+id/ftb_menu_settings\"\n" +
            "        android:icon=\"@drawable/ic_settings_icon\"\n" +
            "        android:title=\"Settings\"/>\n" +
            "\n" +
            "</menu>\n"+
            "XML DATA\n"+
            "<RelativeLayout\n" +
            "    android:id=\"@+id/activity_main\"\n" +
            "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:background=\"@color/colorAccent\"\n" +
            "    tools:context=\"client.yalantis.com.foldingtabbarandroid.MainActivity\">\n" +
            "\n" +
            "    ...\n" +
            "\n" +
            "    <client.yalantis.com.foldingtabbar.FoldingTabBar\n" +
            "        android:id=\"@+id/folding_tab_bar\"\n" +
            "        android:layout_width=\"wrap_content\"\n" +
            "        android:layout_height=\"wrap_content\"\n" +
            "        android:layout_alignParentBottom=\"true\"\n" +
            "        android:layout_centerInParent=\"true\"\n" +
            "        android:layout_marginBottom=\"@dimen/activity_horizontal_margin\"\n" +
            "        app:menu=\"@menu/menu_tab_bar\"/>\n" +
            "\n" +
            "    ...\n" +
            "    \n" +
            "</RelativeLayout>\n"

    var TapKotlinData = "FoldingTabBar tabBar = (FoldingTabBar) findViewById(R.id.folding_tab_bar);\n"+
            "\ttabBar.setOnFoldingItemClickListener(new FoldingTabBar.OnFoldingItemSelectedListener() {\n" +
            "            \t@Override\n" +
            "            \tpublic boolean onFoldingItemSelected(@NotNull MenuItem item) {\n" +
            "                \tswitch (item.getItemId()) {\n" +
            "                   \t case R.id.ftb_menu_nearby:\n" +
            "                        \tmViewPager.setCurrentItem(0);\n" +
            "                        \tbreak;\n" +
            "                    \tcase R.id.ftb_menu_new_chat:\n" +
            "                        \tmViewPager.setCurrentItem(1);\n" +
            "                        \tbreak;\n" +
            "                    \tcase R.id.ftb_menu_profile:\n" +
            "                        \tmViewPager.setCurrentItem(2);\n" +
            "                        \tbreak;\n" +
            "                    \tcase R.id.ftb_menu_settings:\n" +
            "                        \tmViewPager.setCurrentItem(3);\n" +
            "                        \tbreak;\n" +
            "                \t}\n" +
            "                \treturn false;\n" +
            "            }\n" +
            "        });\n"

    var dependency = "dependencies {\n" +
            "\tcompile 'com.github.Yalantis:OfficialFoldingTabBar.Android:v0.9'\n" +
            "}\n"
    var gradle = "allprojects {\n" +
            "\trepositories {\n" +
            "\t...\n" +
            "\tmaven { url \"https://jitpack.io\" }\n" +
            "\t}\n" +
            "}"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_folding_tap_code, container, false)

        xmlData = view.findViewById<TextView>(R.id.foldingxmlData)
        kotlinData = view.findViewById<TextView>(R.id.foldingkotlinData)
        tvTapGradle = view.findViewById<TextView>(R.id.tvFoldingTapGradle)
        tvTapDependency = view.findViewById<TextView>(R.id.tvFoldingTapDependency)

        xmlData.text = TapXmlData

        tvTapGradle.text = gradle
        tvTapDependency.text = dependency
        kotlinData.text = TapKotlinData

        return view
    }
}
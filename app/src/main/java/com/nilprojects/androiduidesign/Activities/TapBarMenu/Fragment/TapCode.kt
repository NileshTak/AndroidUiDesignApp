package com.nilprojects.androiduidesign.Activities.TapBarMenu.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nilprojects.androiduidesign.R

import org.w3c.dom.Text


class TapCode : Fragment() {

    lateinit var xmlData : TextView
    lateinit var kotlinData : TextView
    lateinit var tvTapDependency : TextView
    lateinit var tvTapGradle : TextView
    var TapXmlData = "<RelativeLayout\n" +
            "\txmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "\txmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "\txmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "\tandroid:layout_width=\"match_parent\"\n" +
            "\tandroid:layout_height=\"match_parent\"\n" +
            "\tandroid:background=\"@android:color/white\"\n" +
            "\ttools:context=\".MainActivity1\"\n" +
            "\t>\n" +
            "\n" +
            "\t<FrameLayout\n" +
            "\tandroid:id=\"@+id/fragment_container\"\n" +
            "\tandroid:layout_width=\"match_parent\"\n" +
            "\tandroid:layout_height=\"match_parent\"\n" +
            "\t>\n" +
            "\n" +
            "\t<com.michaldrabik.tapbarmenulib.TapBarMenu\n" +
            "\tandroid:id=\"@+id/tapBarMenu\"\n" +
            "\tandroid:layout_width=\"match_parent\"\n" +
            "\tandroid:layout_height=\"56dp\"\n" +
            "\tandroid:layout_gravity=\"bottom\"\n" +
            "\tandroid:layout_marginBottom=\"24dp\"\n" +
            "\tapp:tbm_backgroundColor=\"@color/red\"\n" +
            "\tapp:tbm_menuAnchor=\"bottom\"\n" +
            "\t>\n" +
            "\n" +
            "\t<ImageView\n" +
            "\tandroid:id=\"@+id/item1\"\n" +
            "\tandroid:layout_width=\"0dp\"\n" +
            "\tandroid:layout_height=\"match_parent\"\n" +
            "\tandroid:layout_weight=\"1\"\n" +
            "\tandroid:paddingTop=\"10dp\"\n" +
            "\tandroid:paddingBottom=\"10dp\"\n" +
            "\tandroid:src=\"@drawable/ic_person\"\n" +
            "\ttools:visibility=\"visible\"\n" +
            "\t/>\n" +
            "\n" +
            "\t<ImageView\n" +
            "\tandroid:id=\"@+id/item2\"\n" +
            "\tandroid:layout_width=\"0dp\"\n" +
            "\tandroid:layout_height=\"wrap_content\"\n" +
            "\tandroid:layout_weight=\"1\"\n" +
            "\tandroid:paddingTop=\"10dp\"\n" +
            "\tandroid:paddingBottom=\"10dp\"\n" +
            "\tandroid:src=\"@drawable/ic_location\"\n" +
            "\t/>\n" +
            "\n" +
            "\t<Space\n" +
            "\tandroid:layout_width=\"0dp\"\n" +
            "\tandroid:layout_height=\"wrap_content\"\n" +
            "\tandroid:layout_weight=\"1\"\n" +
            "\t/>\n" +
            "\n" +
            "\t<ImageView\n" +
            "\tandroid:id=\"@+id/item3\"\n" +
            "\tandroid:layout_width=\"0dp\"\n" +
            "\tandroid:layout_height=\"wrap_content\"\n" +
            "\tandroid:layout_weight=\"1\"\n" +
            "\tandroid:paddingTop=\"10dp\"\n" +
            "\tandroid:paddingBottom=\"10dp\"\n" +
            "\tandroid:src=\"@drawable/ic_thumb_up\"\n" +
            "\t/>\n" +
            "\n" +
            "\t<ImageView\n" +
            "\tandroid:id=\"@+id/item4\"\n" +
            "\tandroid:layout_width=\"0dp\"\n" +
            "\tandroid:layout_height=\"wrap_content\"\n" +
            "\tandroid:layout_weight=\"1\"\n" +
            "\tandroid:paddingTop=\"10dp\"\n" +
            "\tandroid:paddingBottom=\"10dp\"\n" +
            "\tandroid:src=\"@drawable/ic_thumb_down\"\n" +
            "\t/>\n" +
            "\n" +
            "\t</com.michaldrabik.tapbarmenulib.TapBarMenu>\n" +
            "\n" +
            "\t</FrameLayout>\n" +
            "\n" +
            "</RelativeLayout>\n"

    var TapKotlinData = "class MainActivity1 : AppCompatActivity() {\n" +
            "\n" +
            "\n" +
            "    lateinit var tapBarMenu: TapBarMenu\n" +
            "    lateinit var item1 : ImageView\n" +
            "    lateinit var item2 : ImageView\n" +
            "    lateinit var item3 : ImageView\n" +
            "    lateinit var item4 : ImageView\n" +
            "\n" +
            "    override fun onCreate(savedInstanceState: Bundle?) {\n" +
            "        super.onCreate(savedInstanceState)\n" +
            "        setContentView(R.layout.activity_main)\n" +
            "\n" +
            "        tapBarMenu = findViewById<TapBarMenu>(R.id.tapBarMenu)\n" +
            "        item1 = findViewById<ImageView>(R.id.item1)\n" +
            "        item2 = findViewById<ImageView>(R.id.item2)\n" +
            "        item3 = findViewById<ImageView>(R.id.item3)\n" +
            "        item4 = findViewById<ImageView>(R.id.item4)\n" +
            "\n" +
            "        tapBarMenu.setOnClickListener {\n" +
            "            onMenuButtonClick()\n" +
            "        }\n" +
            "\n" +
            "        item1.setOnClickListener {\n" +
            "            onMenuItemClick(item1)\n" +
            "        }\n" +
            "\n" +
            "        item2.setOnClickListener {\n" +
            "            onMenuItemClick(item2)\n" +
            "        }\n" +
            "\n" +
            "        item3.setOnClickListener {\n" +
            "            onMenuItemClick(item3)\n" +
            "        }\n" +
            "        item4.setOnClickListener {\n" +
            "            onMenuItemClick(item4)\n" +
            "        }\n" +
            "\n" +
            "    }\n" +
            "    fun onMenuButtonClick() {\n" +
            "        tapBarMenu.toggle()\n" +
            "    }\n" +
            "\n" +
            "    fun onMenuItemClick(view: View) {\n" +
            "        tapBarMenu.close()\n" +
            "        when (view.id) {\n" +
            "            R.id.item1 -> Toast.makeText(this,\"Item1 Selected\",Toast.LENGTH_SHORT).show()\n" +
            "            R.id.item2 -> Toast.makeText(this,\"Item2 Selected\",Toast.LENGTH_SHORT).show()\n" +
            "            R.id.item3 -> Toast.makeText(this,\"Item3 Selected\",Toast.LENGTH_SHORT).show()\n" +
            "            R.id.item4 -> Toast.makeText(this,\"Item4 Selected\",Toast.LENGTH_SHORT).show()\n" +
            "        }\n" +
            "    }\n" +
            "}\n"

    var dependency = "implementation 'com.github.michaldrabik:TapBarMenu:1.0.6'"
    var gradle = "allprojects {\n" +
            "        repositories {\n" +
            "              google()\n" +
            "                jcenter()\n" +
            "                   maven { url 'https://jitpack.io' }\n" +
            "               }\n" +
            "         }"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_tap_code, container, false)

        xmlData = view.findViewById<TextView>(R.id.xmlData)
        kotlinData = view.findViewById<TextView>(R.id.kotlinData)
        tvTapGradle = view.findViewById<TextView>(R.id.tvTapGradle)
        tvTapDependency = view.findViewById<TextView>(R.id.tvTapDependency)

        xmlData.text = TapXmlData

        tvTapGradle.text = gradle
        tvTapDependency.text = dependency
        kotlinData.text = TapKotlinData

        return view
    }

}
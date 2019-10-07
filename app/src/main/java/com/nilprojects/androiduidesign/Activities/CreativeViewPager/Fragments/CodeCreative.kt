package com.nilprojects.androiduidesign.Activities.CreativeViewPager.Fragments

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


class CodeCreative : Fragment() {

    lateinit var tvCreativeXmlData : TextView
    lateinit var tvCreativeKotlinData : TextView
    lateinit var tvCreativeDependency : TextView
    lateinit var tvCreativeModel : TextView
    lateinit var tvCreativeAdapter : TextView
    lateinit var tvCreativeCustom1 : TextView
    lateinit var tvCreativeCustom2 : TextView

    var dependency = "implementation 'com.tbuonomo:creative-viewpager:1.0.1'"

    var kotlind = "creativeViewPagerView.setCreativeViewPagerAdapter(NatureCreativePagerAdapter(this))"

    var xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    android:id=\"@+id/welcomeRoot\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:background=\"@color/white\"\n" +
            "    >\n" +
            "\n" +
            "    <com.tbuonomo.creativeviewpager.CreativeViewPager\n" +
            "        android:id=\"@+id/creativeViewPagerView\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"match_parent\"\n" +
            "        app:contentHorizontalPadding=\"32dp\"\n" +
            "        app:contentItemMargin=\"8dp\"\n" +
            "        app:headerItemMargin=\"8dp\"\n" +
            "        app:headerItemSize=\"92dp\"\n" +
            "        />\n" +
            "</androidx.constraintlayout.widget.ConstraintLayout>"

    var adapterd = "class NatureCreativePagerAdapter(val context: Context) : CreativePagerAdapter {\n" +
            "\n" +
            "  override fun instantiateHeaderItem(inflater: LayoutInflater,\n" +
            "          container: ViewGroup, position: Int): View {\n" +
            "    // Inflate page layout\n" +
            "    val headerRoot = inflater.inflate(R.layout.item_creative_content_nature, container, false)\n" +
            "\n" +
            "    // Bind the views\n" +
            "    val title: TextView = headerRoot.findViewById(R.id.itemCreativeNatureTitle)\n" +
            "    val image: ImageView = headerRoot.findViewById(R.id.itemCreativeNatureImage)\n" +
            "\n" +
            "    title.text = context.getString(R.string.item_nature_title, position)\n" +
            "    image.setImageDrawable(ContextCompat.getDrawable(context, NatureItem.values()[position].natureDrawable))\n" +
            "\n" +
            "    return headerRoot\n" +
            "  }\n" +
            "\n" +
            "  override fun instantiateContentItem(inflater: LayoutInflater,\n" +
            "          container: ViewGroup, position: Int): View {\n" +
            "    // Inflate the header view layout\n" +
            "    val contentRoot = inflater.inflate(R.layout.item_creative_header_profile, container,\n" +
            "            false)\n" +
            "\n" +
            "    // Bind the views\n" +
            "    val imageView = contentRoot.findViewById<ImageView>(R.id.itemCreativeImage)\n" +
            "\n" +
            "    imageView.setImageDrawable(\n" +
            "            ContextCompat.getDrawable(context, NatureItem.values()[position].userDrawable))\n" +
            "    return contentRoot\n" +
            "  }\n" +
            "\n" +
            "  override fun getCount(): Int {\n" +
            "    return NatureItem.values().size\n" +
            "  }\n" +
            "\n" +
            "  override fun isUpdatingBackgroundColor(): Boolean {\n" +
            "    return true\n" +
            "  }\n" +
            "\n" +
            "  override fun requestBitmapAtPosition(position: Int): Bitmap? {\n" +
            "    // Return the bitmap used for the position\n" +
            "    return BitmapFactory.decodeResource(context.resources,\n" +
            "            NatureItem.values()[position].natureDrawable)\n" +
            "  }\n" +
            "}"

    var modelc = "enum class NatureItem(open val userDrawable: Int, open val natureDrawable: Int) {\n" +
            "  NATURE0(R.drawable.user_000, R.drawable.nature_010),\n" +
            "  NATURE1(R.drawable.user_001, R.drawable.nature_001),\n" +
            "  NATURE2(R.drawable.user_002, R.drawable.nature_002),\n" +
            "  NATURE3(R.drawable.user_003, R.drawable.nature_003),\n" +
            "  NATURE4(R.drawable.user_004, R.drawable.nature_004),\n" +
            "  NATURE5(R.drawable.user_005, R.drawable.nature_005),\n" +
            "  NATURE6(R.drawable.user_006, R.drawable.nature_006),\n" +
            "  NATURE7(R.drawable.user_007, R.drawable.nature_007),\n" +
            "  NATURE8(R.drawable.user_008, R.drawable.nature_008),\n" +
            "  NATURE9(R.drawable.user_009, R.drawable.nature_009),\n" +
            "  NATURE10(R.drawable.user_010, R.drawable.nature_010),\n" +
            "\n" +
            "}"

    var custom1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "\n" +
            "<de.hdodenhof.circleimageview.CircleImageView\n" +
            "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:id=\"@+id/itemCreativeImage\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:scaleType=\"centerCrop\"\n" +
            "    app:civ_border_color=\"@color/md_white_1000\"\n" +
            "    app:civ_border_width=\"2dp\"\n" +
            "    tools:layout_height=\"92dp\"\n" +
            "    tools:layout_width=\"92dp\"\n" +
            "    tools:src=\"@drawable/user_000\"\n" +
            "    />\n"

    var custom2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<android.support.v7.widget.CardView xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:layout_margin=\"@dimen/dimens_16dp\"\n" +
            "    app:cardCornerRadius=\"4dp\"\n" +
            "    app:cardElevation=\"@dimen/dimens_4dp\"\n" +
            "    app:cardUseCompatPadding=\"true\"\n" +
            "    >\n" +
            "\n" +
            "  <android.support.constraint.ConstraintLayout\n" +
            "      android:layout_width=\"match_parent\"\n" +
            "      android:layout_height=\"match_parent\"\n" +
            "      >\n" +
            "\n" +
            "    <ImageView\n" +
            "        android:id=\"@+id/itemCreativeNatureImage\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"0dp\"\n" +
            "        android:scaleType=\"centerCrop\"\n" +
            "        app:layout_constraintBottom_toTopOf=\"@+id/guideline\"\n" +
            "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
            "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
            "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
            "        tools:src=\"@drawable/nature_001\"\n" +
            "        />\n" +
            "\n" +
            "    <ScrollView\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"0dp\"\n" +
            "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
            "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
            "        app:layout_constraintTop_toTopOf=\"@+id/guideline\"\n" +
            "        >\n" +
            "\n" +
            "      <LinearLayout\n" +
            "          android:layout_width=\"match_parent\"\n" +
            "          android:layout_height=\"wrap_content\"\n" +
            "          android:orientation=\"vertical\"\n" +
            "          >\n" +
            "\n" +
            "        <TextView\n" +
            "            android:id=\"@+id/itemCreativeNatureTitle\"\n" +
            "            android:layout_width=\"wrap_content\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            android:layout_marginStart=\"16dp\"\n" +
            "            android:layout_marginTop=\"8dp\"\n" +
            "            android:textSize=\"20sp\"\n" +
            "            tools:text=\"Nature\"\n" +
            "            />\n" +
            "\n" +
            "        <TextView\n" +
            "            android:id=\"@+id/itemCreativeNatureDescription\"\n" +
            "            android:layout_width=\"match_parent\"\n" +
            "            android:layout_height=\"wrap_content\"\n" +
            "            android:layout_marginBottom=\"8dp\"\n" +
            "            android:layout_marginEnd=\"16dp\"\n" +
            "            android:layout_marginStart=\"16dp\"\n" +
            "            android:layout_marginTop=\"8dp\"\n" +
            "            android:text=\"@string/lorem_ipsum\"\n" +
            "            />\n" +
            "      </LinearLayout>\n" +
            "    </ScrollView>\n" +
            "\n" +
            "    <android.support.constraint.Guideline\n" +
            "        android:id=\"@+id/guideline\"\n" +
            "        android:layout_width=\"wrap_content\"\n" +
            "        android:layout_height=\"wrap_content\"\n" +
            "        android:orientation=\"horizontal\"\n" +
            "        app:layout_constraintGuide_percent=\"0.65\"\n" +
            "        />\n" +
            "  </android.support.constraint.ConstraintLayout>\n" +
            "</android.support.v7.widget.CardView>\n"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_code_creative, container, false)

        tvCreativeXmlData = view.findViewById<TextView>(R.id.tvCreativeXMLData)
        tvCreativeKotlinData = view.findViewById<TextView>(R.id.tvCreativeKotlinData)

        tvCreativeDependency = view.findViewById<TextView>(R.id.tvCreativeDependency)

        tvCreativeAdapter = view.findViewById<TextView>(R.id.tvCreativeAdapter)

        tvCreativeCustom1 = view.findViewById<TextView>(R.id.tvCreativeCustom1)

        tvCreativeCustom2 = view.findViewById<TextView>(R.id.tvCreativeCustom2)
        tvCreativeModel = view.findViewById<TextView>(R.id.tvCreativeModel)

        tvCreativeDependency.text = dependency
         tvCreativeKotlinData.text = kotlind
        tvCreativeXmlData.text = xml
        tvCreativeAdapter.text = adapterd
        tvCreativeCustom1.text = custom1
        tvCreativeCustom2.text = custom2
        tvCreativeModel.text = modelc





        return view
    }
}

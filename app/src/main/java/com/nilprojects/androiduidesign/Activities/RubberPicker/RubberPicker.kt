package com.nilprojects.androiduidesign.Activities.RubberPicker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nilprojects.androiduidesign.Activities.RubberPicker.Fragments.CodeRubber
import com.nilprojects.androiduidesign.Activities.RubberPicker.Fragments.OutputRubber
import com.nilprojects.androiduidesign.Adapter.TabAdapter
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class RubberPicker : AppCompatActivity() {

    lateinit var tabLayout : TabLayout
    lateinit var adapter: TabAdapter
    lateinit var  viewPager: ViewPager

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rubber_picker)
        this.supportActionBar?.title = "Rubber Picker"
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)


        tabLayout = findViewById<TabLayout>(R.id.tabLayoutRubber)
        viewPager = findViewById<ViewPager>(R.id.viewPagerRubber)

        adapter = TabAdapter(this.supportFragmentManager)
        adapter.addFragment(OutputRubber(), "Output" )
        adapter.addFragment(CodeRubber(), "Code")

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
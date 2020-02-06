package com.nilprojects.androiduidesign.Activities.BubbleNav


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nilprojects.androiduidesign.Activities.BubbleNav.fragment.EqualBottomBarFragment
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class EqualBottomBarActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equal_bottom_bar)
        supportActionBar!!.title = "Equal Navigation Bar"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        var fragment = supportFragmentManager.findFragmentById(R.id.content_frame) as EqualBottomBarFragment?
        if (fragment == null) {
            fragment = EqualBottomBarFragment()
            addFragment(fragment, R.id.content_frame)
        }
    }

    private fun addFragment(fragment: EqualBottomBarFragment, id: Int) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(id, fragment)
        ft.commit()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

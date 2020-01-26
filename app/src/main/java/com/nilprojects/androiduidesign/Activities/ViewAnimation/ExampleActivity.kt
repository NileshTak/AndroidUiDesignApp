package com.nilprojects.androiduidesign.Activities.ViewAnimation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class ExampleActivity : AppCompatActivity() {


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example)
        supportActionBar!!.title = "Demo"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        val t = findViewById<View>(R.id.notice) as TextView
        t.text = "Please input your Email and Password"

        findViewById<View>(R.id.submit).setOnClickListener {
            YoYo.with(Techniques.Tada)
                .duration(700)
                .playOn(findViewById(R.id.edit_area))

            t.text = "Wrong password!"
        }

        val t2 = findViewById<View>(R.id.notice2) as TextView
        t2.text = "Please input your Email and Password"

        findViewById<View>(R.id.submit2).setOnClickListener {
            YoYo.with(Techniques.Shake).playOn(findViewById(R.id.edit_area2))

            t2.text = "Wrong password!"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

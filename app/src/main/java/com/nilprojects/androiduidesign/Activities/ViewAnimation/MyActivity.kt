package com.nilprojects.androiduidesign.Activities.ViewAnimation

import android.animation.Animator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nilprojects.androiduidesign.CommonUtils.Utils

import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MyActivity : AppCompatActivity() {

    private var mListView: ListView? = null
    private var mAdapter: EffectAdapter? = null
    private var mTarget: View? = null
    private var rope: YoYo.YoYoString? = null
    lateinit var fabGit : FloatingActionButton


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        supportActionBar!!.title = "View Animation"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        mListView = findViewById(R.id.list_items) as ListView
        mTarget = findViewById(R.id.hello_world)
        fabGit = findViewById<FloatingActionButton>(R.id.fabGit)

        mAdapter = EffectAdapter(this)
        mListView!!.adapter = mAdapter


        fabGit.setOnClickListener {
            Utils.navigateToGithub("https://github.com/daimajia/AndroidViewAnimations",this@MyActivity)
        }

        mListView!!.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                if (rope != null) {
                    rope!!.stop(true)
                }
                val technique = view.tag as Techniques
                rope = YoYo.with(technique)
                    .duration(1200)
                    .repeat(YoYo.INFINITE)
                    .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                    .interpolate(AccelerateDecelerateInterpolator())
                    .withListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(animation: Animator) {

                        }

                        override fun onAnimationEnd(animation: Animator) {}

                        override fun onAnimationCancel(animation: Animator) {
                            Toast.makeText(
                                this@MyActivity,
                                "canceled previous animation",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        override fun onAnimationRepeat(animation: Animator) {

                        }
                    })
                    .playOn(mTarget)
            }
        findViewById<TextView>(R.id.hello_world).setOnClickListener(View.OnClickListener {
            if (rope != null) {
                rope!!.stop(true)
            }
        })
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            rope = YoYo.with(Techniques.FadeIn).duration(1000)
                .playOn(mTarget)// after start,just click mTarget view, rope is not init
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.my, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_settings) {
            startActivity(Intent(this, ExampleActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


package com.nilprojects.androiduidesign

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.diegodobelo.expandingview.ExpandingItem
import com.diegodobelo.expandingview.ExpandingList
import com.google.android.material.navigation.NavigationView
import com.nilprojects.androiduidesign.Fragments.HomeFragment
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var tvNavTitle : TextView
    lateinit var navProfList : CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNavTitle = findViewById<TextView>(R.id.tvnavTitle)
        //     btn_logout = findViewById<Button>(R.id.btn_logout)
        navProfList = findViewById<CircleImageView>(R.id.navProfList)


        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left,
            android.R.anim.slide_out_right).replace(R.id.frame_container, HomeFragment()).commit()
        supportActionBar!!.title = ""
        tvNavTitle.text = "Home"



        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout

        val holder = findViewById<LinearLayout>(R.id.holder)
        val toggle = object : ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

                val scaleFactor = 7f
                val slideX = drawerView.width * slideOffset

                holder.setTranslationX(slideX)
                holder.setScaleX(1 - slideOffset / scaleFactor)
                holder.setScaleY(1 - slideOffset / scaleFactor)

                super.onDrawerSlide(drawerView, slideOffset)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)// will remove all possible our aactivity's window bounds
        }

        drawer.addDrawerListener(toggle)

        drawer.setScrimColor(Color.TRANSPARENT)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId)
        {
            R.id.view_users ->
            {
//                var int = Intent(this,User_profiles_list :: class.java)
//                startActivity(int)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        when (id) {
            R.id.nav_home -> {

                loadHomeFrag(fragHome = HomeFragment())
            }
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun loadHomeFrag(fragHome : HomeFragment)
    {
        val fm = supportFragmentManager.beginTransaction()
        supportActionBar!!.title = ""
        tvNavTitle.text = "Home"
        fm.setCustomAnimations(android.R.anim.slide_in_left,
            android.R.anim.slide_out_right)
        fm.replace(R.id.frame_container,fragHome)
        fm.commit()
    }


        }

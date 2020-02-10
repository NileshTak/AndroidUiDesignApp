package com.nilprojects.androiduidesign.Activities.FloatingNav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.github.rubensousa.floatingtoolbar.FloatingToolbar
import com.github.rubensousa.floatingtoolbar.FloatingToolbarMenuBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class FloatingNav : AppCompatActivity(), FloatingToolbar.ItemClickListener,
    Toolbar.OnMenuItemClickListener, CustomAdapter.ClickListener, FloatingToolbar.MorphListener {

    private var mToolbar: Toolbar? = null
    private var mFloatingToolbar: FloatingToolbar? = null
    private var mAdapter: CustomAdapter? = null


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.floating_nav_main)
        mToolbar = findViewById(R.id.toolbar)


        val fab = findViewById<FloatingActionButton>(R.id.fabFloat)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        mFloatingToolbar = findViewById<FloatingToolbar>(R.id.floatingToolbar)


        mToolbar!!.setTitle(R.string.app_name)
        mToolbar!!.inflateMenu(R.menu.menu_toolbar)
        mToolbar!!.setOnMenuItemClickListener(this)

        mAdapter = CustomAdapter(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(mAdapter)


        mFloatingToolbar!!.setClickListener(this)
        mFloatingToolbar!!.attachFab(fab)
        mFloatingToolbar!!.attachRecyclerView(recyclerView)
        mFloatingToolbar!!.addMorphListener(this)

        //Create a custom menu
        mFloatingToolbar!!.setMenu(
            FloatingToolbarMenuBuilder(this)
                .addItem(R.id.action_unread, R.drawable.ic_markunread_black_24dp, "Mark unread")
                .addItem(R.id.action_copy, R.drawable.ic_content_copy_black_24dp, "Copy")
                .addItem(R.id.action_google, R.drawable.ic_google_plus_box, "Google+")
                .addItem(R.id.action_facebook, R.drawable.ic_facebook_box, "Facebook")
                .addItem(R.id.action_twitter, R.drawable.ic_twitter_box, "Twitter")
                .build()
        )

        // Usage with custom view
        /*View customView = mFloatingToolbar.getCustomView();
        if (customView != null) {
            customView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFloatingToolbar.hide();
                }
            });
        }*/

        // How to edit current menu
        // Menu menu = mFloatingToolbar.getMenu();
        // menu.findItem(R.id.action_copy).setVisible(false);
        // mFloatingToolbar.setMenu(menu);
    }

    override protected fun onDestroy() {
        super.onDestroy()
        mFloatingToolbar!!.removeMorphListener(this)
    }

    override fun onItemClick(item: MenuItem) {
        mAdapter!!.addItem(item)
    }

    override fun onItemLongClick(item: MenuItem) {

    }

    override fun onAdapterItemClick(item: MenuItem) {
//        val intent = Intent(this, DetailActivity::class.java)
//        startActivityForResult(intent, 0)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun onMenuItemClick(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_snackbar) {
//            val snackbar = mToolbar?.let {
//                Snackbar.make(
//                    it, "Here's a SnackBar",
//                    Snackbar.LENGTH_INDEFINITE
//                )
//            }
//            mFloatingToolbar!!.showSnackBar(snackbar)

            Utils.navigateToGithub("https://github.com/rubensousa/FloatingToolbar",this)

            return true
        }
        return false
    }

    override fun onMorphEnd() {

    }

    override fun onMorphStart() {

    }

    override fun onUnmorphStart() {

    }

    override fun onUnmorphEnd() {

    }
}

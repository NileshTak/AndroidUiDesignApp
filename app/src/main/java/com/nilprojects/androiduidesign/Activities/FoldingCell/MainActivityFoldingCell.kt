package com.nilprojects.androiduidesign.Activities.FoldingCell

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.nilprojects.androiduidesign.CommonUtils.Utils

import com.nilprojects.androiduidesign.R
import com.ramotion.foldingcell.FoldingCell
import io.github.inflationx.viewpump.ViewPumpContextWrapper

import java.util.ArrayList

/**
 * Example of using Folding Cell with ListView and ListAdapter
 */
class MainActivityFoldingCell : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_foldingcell)
        supportActionBar!!.title = "Folding Cell"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        // get our list view
        val theListView = findViewById<ListView>(R.id.mainListView)

        // prepare elements to display
        val items = ItemFoldingCell.getTestingList()

        // add custom btn handler to first list item
        items[0].requestBtnClickListener = View.OnClickListener {
            Toast.makeText(
                applicationContext,
                "CUSTOM HANDLER FOR FIRST BUTTON",
                Toast.LENGTH_SHORT
            ).show()
        }

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        val adapter = FoldingCellListAdapter(this, items)

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.defaultRequestBtnClickListener = View.OnClickListener {
            Toast.makeText(
                applicationContext,
                "DEFAULT HANDLER FOR ALL BUTTONS",
                Toast.LENGTH_SHORT
            ).show()
        }

        // set elements to adapter
        theListView.adapter = adapter

        // set on click event listener to list view
        theListView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, pos, l ->
                // toggle clicked cell state
                (view as FoldingCell).toggle(false)
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos)
            }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> {
                Utils.navigateToGithub("https://github.com/Ramotion/folding-cell-android",this)

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

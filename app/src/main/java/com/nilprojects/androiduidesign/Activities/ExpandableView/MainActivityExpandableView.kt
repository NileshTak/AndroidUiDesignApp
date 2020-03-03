/**
 * Copyright (c) 2016, Diego Bezerra <diego.bezerra></diego.bezerra>@gmail.com>
 * Permission to use, copy, modify, and/or distribute this software for any purpose
 * with or without fee is hereby granted, provided that the above copyright notice
 * and this permission notice appear in all copies.
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH
 * REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT,
 * OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
 * DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package com.nilprojects.androiduidesign.Activities.ExpandableView

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.diegodobelo.expandingview.ExpandingItem
import com.diegodobelo.expandingview.ExpandingList
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivityExpandableView : AppCompatActivity() {


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    private var mExpandingList: ExpandingList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_expandableview)

        supportActionBar!!.title = "Expandable View"
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        mExpandingList = findViewById(R.id.expanding_list_main)
        createItems()
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
                Utils.navigateToGithub("https://github.com/diegodobelo/AndroidExpandingViewLibrary",this)

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun createItems() {
        addItem(
            "John",
            arrayOf("House", "Boat", "Candy", "Collection", "Sport", "Ball", "Head"),
            R.color.pink,
            R.drawable.ic_ghost
        )
        addItem("Mary", arrayOf("Dog", "Horse", "Boat"), R.color.blue, R.drawable.ic_ghost)
        addItem("Ana", arrayOf("Cat"), R.color.purple, R.drawable.ic_ghost)
        addItem(
            "Peter",
            arrayOf("Parrot", "Elephant", "Coffee"),
            R.color.yellow,
            R.drawable.ic_ghost
        )
        addItem("Joseph", arrayOf(), R.color.orange, R.drawable.ic_ghost)
        addItem("Paul", arrayOf("Golf", "Football"), R.color.green, R.drawable.ic_ghost)
        addItem(
            "Larry",
            arrayOf("Ferrari", "Mazda", "Honda", "Toyota", "Fiat"),
            R.color.blue,
            R.drawable.ic_ghost
        )
        addItem("Moe", arrayOf("Beans", "Rice", "Meat"), R.color.yellow, R.drawable.ic_ghost)
        addItem(
            "Bart",
            arrayOf("Hamburger", "Ice cream", "Candy"),
            R.color.purple,
            R.drawable.ic_ghost
        )
    }

    private fun addItem(title: String, subItems: Array<String>, colorRes: Int, iconRes: Int) {
        //Let's create an item with R.layout.expanding_layout
        val item = mExpandingList!!.createNewItem(R.layout.expanding_layout)

        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes)
            item.setIndicatorIconRes(iconRes)
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            (item.findViewById<View>(R.id.title) as TextView).text = title

            //We can create items in batch.
            item.createSubItems(subItems.size)
            for (i in 0 until item.subItemsCount) {
                //Let's get the created sub item by its index
                val view = item.getSubItemView(i)

                //Let's set some values in
                configureSubItem(item, view, subItems[i])
            }
            item.findViewById<View>(R.id.add_more_sub_items).setOnClickListener {
                showInsertDialog(object : OnItemCreated {
                    override fun itemCreated(title: String) {
                        val newSubItem = item.createSubItem()
                        configureSubItem(item, newSubItem!!, title)
                    }
                })
            }

            item.findViewById<View>(R.id.remove_item)
                .setOnClickListener { mExpandingList!!.removeItem(item) }
        }
    }

    private fun configureSubItem(item: ExpandingItem?, view: View, subTitle: String) {
        (view.findViewById<View>(R.id.sub_title) as TextView).text = subTitle
        view.findViewById<View>(R.id.remove_sub_item)
            .setOnClickListener { item!!.removeSubItem(view) }
    }

    private fun showInsertDialog(positive: OnItemCreated) {
        val text = EditText(this)
        val builder = AlertDialog.Builder(this)
        builder.setView(text)
        builder.setTitle(R.string.enter_title)
        builder.setPositiveButton(android.R.string.ok) { dialog, which -> positive.itemCreated(text.text.toString()) }
        builder.setNegativeButton(android.R.string.cancel, null)
        builder.show()
    }

    internal interface OnItemCreated {
        fun itemCreated(title: String)
    }
}

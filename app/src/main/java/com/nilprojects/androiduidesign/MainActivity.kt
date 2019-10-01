
package com.nilprojects.androiduidesign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.diegodobelo.expandingview.ExpandingItem
import com.diegodobelo.expandingview.ExpandingList
import com.nilprojects.androiduidesign.Activities.TapBarMenu.TapBarMenu
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    private var mExpandingList: ExpandingList? = null

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mExpandingList =  findViewById<ExpandingList>(R.id.expanding_list_main)


        createItems()

    }


    private fun createItems() {
        addItem(
            "Bottom Navigation Bar",
            arrayOf("Tap Bar Menu", "Boat", "Candy", "Collection", "Sport", "Ball", "Head"),
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

        if (item != null) {
            item!!.setIndicatorColorRes(colorRes)
            item!!.setIndicatorIconRes(iconRes)
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            (item!!.findViewById(R.id.title) as TextView).text = title


            //We can create items in batch.
            item!!.createSubItems(subItems.size)
            for (i in 0 until item!!.getSubItemsCount()) {
                //Let's get the created sub item by its index
                val view = item!!.getSubItemView(i)

                configureSubItem(item, view, subItems[i])
            }
//            item!!.findViewById<ImageView>(R.id.add_more_sub_items).setOnClickListener(View.OnClickListener {
//                showInsertDialog(object : OnItemCreated {
//                    override fun itemCreated(title: String) {
//                        val newSubItem = item!!.createSubItem()
//                        configureSubItem(item, newSubItem!!, title)
//                    }
//                })
//            })

//            item!!.findViewById<ImageView>(R.id.remove_item)
//                .setOnClickListener(View.OnClickListener { mExpandingList!!.removeItem(item) })
        }
    }

    private fun configureSubItem(item: ExpandingItem?, view: View, subTitle: String) {

        var subItem = view.findViewById<View>(R.id.sub_title) as TextView

        subItem.text = subTitle

        subItem.setOnClickListener {
            if (subItem.text == "Tap Bar Menu")
            {
                var int = Intent(this, TapBarMenu:: class.java)
                startActivity(int)
            }
        }





//        view.findViewById<View>(R.id.remove_sub_item)
//            .setOnClickListener { item!!.removeSubItem(view) }
    }

//    private fun showInsertDialog(positive: OnItemCreated) {
//        val text = EditText(activity)
//        val builder = AlertDialog.Builder(activity!!.applicationContext)
//        builder.setView(text)
//        builder.setTitle(R.string.enter_title)
//        builder.setPositiveButton(android.R.string.ok) { dialog, which -> positive.itemCreated(text.text.toString()) }
//        builder.setNegativeButton(android.R.string.cancel, null)
//        builder.show()
//    }

//    internal interface OnItemCreated {
//        fun itemCreated(title: String)
//    }
}
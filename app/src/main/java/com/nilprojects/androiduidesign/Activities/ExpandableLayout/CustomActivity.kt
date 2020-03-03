/*
 * Copyright (C) 2019 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nilprojects.androiduidesign.Activities.ExpandableLayout

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_custom.*

class CustomActivity : AppCompatActivity() {

  private val adapter by lazy { ParentAdapter() }

  override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
  }



  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_custom)
    supportActionBar!!.title = "Expandable Layout"
    val actionbar = supportActionBar
    actionbar!!.setDisplayHomeAsUpEnabled(true)


    recyclerView.adapter = adapter
    adapter.addSectionItem(SectionItem("Title0", R.color.colorPrimary, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title1", R.color.md_yellow_100, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title2", R.color.md_amber_700, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title3", R.color.md_orange_200, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title4", R.color.md_green_200, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title5", R.color.md_blue_100, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title6", R.color.md_blue_200, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title7", R.color.md_purple_100, arrayListOf("item0", "item1", "item2", "item3")))
    adapter.addSectionItem(SectionItem("Title8", R.color.md_purple_200, arrayListOf("item0", "item1", "item2", "item3")))
  }


  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
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
        Utils.navigateToGithub("https://github.com/skydoves/ExpandableLayout",this)

        return true
      }

      else -> return super.onOptionsItemSelected(item)
    }
  }


}

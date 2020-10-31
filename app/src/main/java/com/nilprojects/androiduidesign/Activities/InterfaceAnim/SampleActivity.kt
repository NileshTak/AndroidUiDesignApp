package com.agilie.aninterface

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.agilie.agmobilegiftinterface.InterfaceInteractorImpl
import com.agilie.agmobilegiftinterface.gravity.GravityController
import com.agilie.agmobilegiftinterface.gravity.GravityControllerImpl
import com.agilie.agmobilegiftinterface.shake.ShakeBuilder
import com.agilie.mobileeastergift.User
import com.nilprojects.androiduidesign.CommonUtils.Utils
import com.nilprojects.androiduidesign.R
import kotlinx.android.synthetic.main.activity_gravity.*


class SampleActivity : AppCompatActivity(), UsersAdapter.AddNewUserListener {

    lateinit var userAdapter: UsersAdapter
    var userList: List<User> = getUsersList()

    var gravityController: GravityController? = null
    var shakeBuilder: ShakeBuilder? = null

    companion object {
        fun getCallingIntent(context: android.content.Context) = Intent(context, SampleActivity::class.java)
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gravity)

        userAdapter = UsersAdapter(userList, this, this)
        usersRecyclerView.adapter = userAdapter

        prepareActionBar()

        gravityController = GravityControllerImpl(this, root_layout)

        shakeBuilder = InterfaceInteractorImpl().shake(this).build()

    }

    override fun addNewUser() {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_stub, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_enable_physics -> gravityController?.start()
            R.id.action_disable_physics -> gravityController?.stop()
            R.id.action_start_shake -> shakeBuilder?.shakeMyActivity()
            R.id.action_stop_shake -> shakeBuilder?.stopAnimation()
            R.id.action_code -> {
                Utils.navigateToGithub("https://github.com/agilie/InterfaceInteraction",this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun prepareActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun getUsersList(): List<User> {
        return listOf(
                User("John", R.drawable.john_pic_big),
                User("Olivia", R.drawable.olivia_pic_big),
                User("Add", R.drawable.add_member)
        )
    }
}
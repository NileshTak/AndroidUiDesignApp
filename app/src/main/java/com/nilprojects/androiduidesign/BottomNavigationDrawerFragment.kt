package com.nilprojects.androiduidesign

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView
import android.widget.FrameLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import android.content.DialogInterface
import android.net.Uri
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import com.airbnb.lottie.LottieAnimationView
import com.nil.productionapp.maulifresh.CommonUtils.Configure
import kotlinx.android.synthetic.main.bottom_sheet.*


class BottomNavigationDrawerFragment: BottomSheetDialogFragment() {


    var mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet, container, false)


        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem.itemId) {

                R.id.itemRate -> {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.nilprojects.androiduidesign")
                    )
                    startActivity(intent)
                }

                R.id.itemYoutube -> {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCJgpimQkfBV1VqAZYuEG6cQ/videos")
                    )
                    startActivity(intent)
                }

                R.id.itemExit -> {

                    val exitBottomSheetFragment = ExitBottomSheetFragment()
                    exitBottomSheetFragment.show(activity!!.supportFragmentManager, exitBottomSheetFragment.tag)

                }

                R.id.itemShare -> {

                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Download and Install https://play.google.com/store/apps/details?id=com.nilprojects.androiduidesign for latest " +
                                "Android UI Designs with Source Code.")
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(sendIntent, null)
                    startActivity(shareIntent)
                }

             }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            true
        }

        disableNavigationViewScrollbars(navigation_view)

    }

    private fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
        val navigationMenuView = navigationView?.getChildAt(0) as NavigationMenuView
        navigationMenuView.isVerticalScrollBarEnabled = false
    }


}
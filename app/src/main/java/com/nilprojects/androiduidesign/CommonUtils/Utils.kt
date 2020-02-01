package com.nilprojects.androiduidesign.CommonUtils

import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Handler
import android.preference.PreferenceManager
import android.view.View
import java.io.IOException
import java.util.*


object Utils {


    fun navigateToGithub(url : String,context: Context) {
        val intentGithub = Intent(Intent.ACTION_VIEW)
        intentGithub.data = Uri.parse(url)
        context.startActivity(intentGithub)
    }

    fun writeStringToPreferences(key: String, value: String, activity: Context?) {
        if (activity == null) {
            return
        }
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        val sharedPrefEditor = sharedPreferences.edit()
        sharedPrefEditor.putString(key, value)
        sharedPrefEditor.apply()
    }

    fun getStringFromPreferences(key: String, defaultValue: String, activity: Context?): String? {
        if (activity == null) {
            return defaultValue
        }
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        return sharedPreferences.getString(key, defaultValue)
    }





}


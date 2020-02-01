package com.nilprojects.androiduidesign

import android.app.Application
import com.nilprojects.androiduidesign.R

import uk.co.chrisjenx.calligraphy.CalligraphyConfig


public class App : Application()
{
    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("Bitter-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}
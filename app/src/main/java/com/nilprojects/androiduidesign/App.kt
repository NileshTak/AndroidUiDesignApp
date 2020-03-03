package com.nilprojects.androiduidesign

import android.app.Application
import com.nilprojects.androiduidesign.R
import io.github.inflationx.calligraphy3.CalligraphyConfig

import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump





public class App : Application()
{
    override fun onCreate() {
        super.onCreate()
//        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
//                .setDefaultFontPath("Bitter-Bold.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("Bitter-Bold.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )

    }
}
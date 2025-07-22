package com.mobile.soccerleague.application

import android.app.Application
import com.mobile.petra.di.initKoin
import org.koin.android.ext.koin.androidContext


class SLApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@SLApplication)
//            AndroidLogger(Level.ALL)
        }
    }

//    private fun AndroidLogger(all: Level) {
//
//    }
}
package com.mobile.soccerleague.application

import android.app.Application
import com.mobile.soccerleague.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.logger.Level


class SLApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@SLApplication)
            AndroidLogger(Level.INFO)
        }
    }

//    private fun AndroidLogger(all: Level) {
//
//    }
}
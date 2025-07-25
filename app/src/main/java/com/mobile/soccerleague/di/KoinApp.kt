package com.mobile.soccerleague.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes


fun initKoin(config : KoinAppDeclaration? = null){
    startKoin {
        includes(config)
        modules(sharedKoinModules)
    }
}
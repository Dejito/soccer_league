package com.mobile.soccerleague.di.livescore

import com.mobile.soccerleague.data.remote.SLRepositoryImpl
import com.mobile.soccerleague.presentation.matches.viewmodel.MatchesViewModel
import org.koin.dsl.module

val matchesModule = module {
    single { SLRepositoryImpl() }
    single { MatchesViewModel(get()) }
}

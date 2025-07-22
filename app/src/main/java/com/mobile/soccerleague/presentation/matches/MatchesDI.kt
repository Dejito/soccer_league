package com.mobile.soccerleague.presentation.matches

import com.mobile.soccerleague.data.remote.SLRepository
import com.mobile.soccerleague.data.remote.SLRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.viewModelOf

val matchesModule = module {
    singleOf(::SLRepositoryImpl){bind<SLRepository>()}
    viewModelOf(::MatchesViewModel)
}

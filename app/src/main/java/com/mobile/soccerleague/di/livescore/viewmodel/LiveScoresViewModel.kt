package com.mobile.soccerleague.di.livescore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.remote.SLRepositoryImpl
import kotlinx.coroutines.launch


class LiveScoresViewModel(private val slRepository: SLRepositoryImpl) : ViewModel() {

    fun getPlayerDetail(
        onFailure: (String) -> Unit,
        onSuccess: (PlayerResponse) -> Unit,
    ) {
        viewModelScope.launch {
            slRepository.getPlayerDetail(
                onSuccess, onFailure,
            )
        }
    }

    fun getFootballMatches(
        onFailure: (String) -> Unit,
        onSuccess: (PlayerResponse) -> Unit,
    ) {
        viewModelScope.launch {
            slRepository.getPlayerDetail(
                onSuccess, onFailure,
            )
        }
    }


}
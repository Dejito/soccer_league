package com.mobile.soccerleague.presentation.livescores.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.soccerleague.data.entity.response.MatchesResponse
import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.remote.SLRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LiveScoresViewModel(private val slRepository: SLRepositoryImpl) : ViewModel() {

    private val _footballMatches: MutableStateFlow<MatchesResponse?> = MutableStateFlow<MatchesResponse?>(null)

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
        onSuccess: (MatchesResponse) -> Unit,
    ) {
        viewModelScope.launch {
            slRepository.getAllFootballMatches(
                onSuccess, onFailure,
            )
        }
    }


}
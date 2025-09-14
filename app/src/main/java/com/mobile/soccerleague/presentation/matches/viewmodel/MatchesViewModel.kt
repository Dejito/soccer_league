package com.mobile.soccerleague.presentation.matches.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.soccerleague.data.entity.response.MatchesResponse
import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.remote.SLRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MatchesViewModel(private val slRepository: SLRepositoryImpl) : ViewModel() {

    private val _footballMatches: MutableStateFlow<MatchesResponse?> = MutableStateFlow(null)
    val footballMatches: StateFlow<MatchesResponse?> = _footballMatches

    private val _fetchMatchesUiStates: MutableStateFlow<MatchesUiStates> = MutableStateFlow(
        MatchesUiStates.Default
    )
    val fetchMatchesUiStates: MutableStateFlow<MatchesUiStates> = _fetchMatchesUiStates



    fun getFootballMatches(
        onFailure: (String) -> Unit,
        onSuccess: (MatchesResponse) -> Unit,
    ) {
        viewModelScope.launch(context = Dispatchers.IO) {
            _fetchMatchesUiStates.emit(MatchesUiStates.Loading)
            slRepository.getAllFootballMatches(
                onSuccess = { successResponse ->
                    viewModelScope.launch(context = Dispatchers.IO) {
                        _fetchMatchesUiStates.emit(MatchesUiStates.Success(successResponse))
                    }
                },
                onFailure = { error ->
                    viewModelScope.launch(context = Dispatchers.IO) {
                        _fetchMatchesUiStates.emit(MatchesUiStates.Error(error))
                    }
                },
            )
        }
    }


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


}
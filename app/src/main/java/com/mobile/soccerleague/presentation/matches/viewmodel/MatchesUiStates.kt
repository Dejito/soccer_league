package com.mobile.soccerleague.presentation.matches.viewmodel

import com.mobile.soccerleague.data.entity.response.MatchesResponse

sealed class MatchesUiStates {
    data object Default: MatchesUiStates()
    data object Loading : MatchesUiStates()
    data class Error(val errorMessage: String? = null) : MatchesUiStates()
    data class Success(val matchResult: MatchesResponse) : MatchesUiStates()
}

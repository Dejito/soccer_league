package com.mobile.soccerleague.presentation.matches.viewmodel

sealed class MatchesUiStates {
    data object Default: MatchesUiStates()
    data object Loading : MatchesUiStates()
    data class Error(val errorMessage: String? = null) : MatchesUiStates()
    data class Success(val matchResult: MatchResult) : MatchesUiStates()
}

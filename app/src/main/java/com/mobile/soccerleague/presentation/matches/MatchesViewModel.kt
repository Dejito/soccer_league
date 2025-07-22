package com.mobile.soccerleague.presentation.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.entity.response.ResponseMessage
import com.mobile.soccerleague.data.remote.SLRepository
import kotlinx.coroutines.launch


//class AuthViewModel(
//    private val kegowRepository: KegowRepository
//) : ViewModel() {


class MatchesViewModel(private val slRepository: SLRepository) : ViewModel() {

    fun getTodayMatches(
        onFailure: (String) -> Unit,
        onSuccess: (PlayerResponse) -> Unit,
    ) {
        viewModelScope.launch {
            slRepository.getAllFootballMatches(
                onSuccess, onFailure,
            )
        }
    }


}
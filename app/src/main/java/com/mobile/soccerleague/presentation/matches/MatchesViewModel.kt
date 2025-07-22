package com.mobile.soccerleague.presentation.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.soccerleague.data.remote.SLRepository
import kotlinx.coroutines.launch


//class AuthViewModel(
//    private val kegowRepository: KegowRepository
//) : ViewModel() {


class MatchesViewModel(private val slRepository: SLRepository) : ViewModel() {

    fun getTodayMatches(

    ) {
        viewModelScope.launch {

        }
    }
//
//    fun authPhoneNumber(
//        phoneNumber: String,
//        onSuccess: (message: ResponseMessage) -> Unit,
//        onFailure: (message: String) -> Unit
//    ) {
//        viewModelScope.launch {
//            kegowRepository.authPhoneNumber(
//                isDeviceTypeIOS = false,
//                token = "",
//                phoneNumber,
//                onSuccess,
//                onFailure
//            )
//        }
//    }


}
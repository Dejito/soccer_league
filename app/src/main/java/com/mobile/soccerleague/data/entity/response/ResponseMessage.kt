package com.mobile.soccerleague.data.entity.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMessage(
    @SerialName("message")
    val message: String,
    @SerialName("id")
    val userId:Int?=0,
)
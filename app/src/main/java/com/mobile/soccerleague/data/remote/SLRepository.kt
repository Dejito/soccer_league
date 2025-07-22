package com.mobile.soccerleague.data.remote

import com.mobile.soccerleague.data.entity.response.ResponseMessage

interface SLRepository {

//    suspend fun detectFace(
//        detectFaceRequestBody: DetectFaceRequestBody,
//        onSuccess: (response: ResponseMessage) -> Unit,
//        onFailure: (error: String) -> Unit
//    )

    suspend fun getAllFootballMatches(
        onSuccess: (response: ResponseMessage) -> Unit,
        onFailure: (error: String) -> Unit
    )


}
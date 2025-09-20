package com.mobile.soccerleague.data.remote

import com.mobile.soccerleague.data.entity.response.MatchesResponse
import com.mobile.soccerleague.data.entity.response.PlayerResponse
import com.mobile.soccerleague.data.entity.response.ResponseMessage
import io.ktor.http.HttpMethod

interface SLRepository {

    suspend fun getAllFootballMatches(
        onSuccess: (response: MatchesResponse) -> Unit,
        onFailure: (error: String) -> Unit
    )

    suspend fun getPlayerDetail(
        onSuccess: (response: PlayerResponse) -> Unit,
        onFailure: (error: String) -> Unit
    )



}
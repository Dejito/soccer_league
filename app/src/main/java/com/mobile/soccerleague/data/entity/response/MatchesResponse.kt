package com.mobile.soccerleague.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchesResponse(
    @SerialName("filters")
    val filters: Filters,
    @SerialName("resultSet")
    val resultSet: ResultSet,
    @SerialName("matches")
    val matches: List<Match>
)

@Serializable
data class Filters(
    @SerialName("dateFrom")
    val dateFrom: String,
    @SerialName("dateTo")
    val dateTo: String,
    @SerialName("permission")
    val permission: String
)

@Serializable
data class ResultSet(
    @SerialName("count")
    val count: Int,
    @SerialName("competitions")
    val competitions: String,
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String,
    @SerialName("played")
    val played: Int
)

@Serializable
data class Match(
    @SerialName("area")
    val area: Area,
    @SerialName("competition")
    val competition: Competition,
    @SerialName("season")
    val season: Season,
    @SerialName("id")
    val id: Int,
    @SerialName("utcDate")
    val utcDate: String,
    @SerialName("status")
    val status: String,
    @SerialName("matchday")
    val matchday: Int,
    @SerialName("stage")
    val stage: String,
    @SerialName("group")
    val group: String? = null,
    @SerialName("lastUpdated")
    val lastUpdated: String,
    @SerialName("homeTeam")
    val homeTeam: Team,
    @SerialName("awayTeam")
    val awayTeam: Team,
    @SerialName("score")
    val score: Score,
    @SerialName("odds")
    val odds: Odds,
    @SerialName("referees")
    val referees: List<Referee>
)

@Serializable
data class Area(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("code")
    val code: String,
    @SerialName("flag")
    val flag: String? = null
)

@Serializable
data class Competition(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("code")
    val code: String,
    @SerialName("type")
    val type: String,
    @SerialName("emblem")
    val emblem: String? = null
)

@Serializable
data class Season(
    @SerialName("id")
    val id: Int,
    @SerialName("startDate")
    val startDate: String,
    @SerialName("endDate")
    val endDate: String,
    @SerialName("currentMatchday")
    val currentMatchday: Int,
    @SerialName("winner")
    val winner: String? = null
)

@Serializable
data class Team(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("shortName")
    val shortName: String,
    @SerialName("tla")
    val tla: String,
    @SerialName("crest")
    val crest: String
)

@Serializable
data class Score(
    @SerialName("winner")
    val winner: String? = null,
    @SerialName("duration")
    val duration: String,
    @SerialName("fullTime")
    val fullTime: ScoreDetail,
    @SerialName("halfTime")
    val halfTime: ScoreDetail
)

@Serializable
data class ScoreDetail(
    @SerialName("home")
    val home: Int? = null,
    @SerialName("away")
    val away: Int? = null
)

@Serializable
data class Odds(
    @SerialName("msg")
    val msg: String
)

@Serializable
data class Referee(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("role")
    val role: String? = null,
    @SerialName("nationality")
    val nationality: String? = null
)




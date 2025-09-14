package com.mobile.soccerleague.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchesResponse(
    @SerialName("filters")
    val filters: Filters? = null,
    @SerialName("resultSet")
    val resultSet: ResultSet? = null,
    @SerialName("matches")
    val matches: List<Match>? = emptyList()
)

@Serializable
data class Filters(
    @SerialName("dateFrom")
    val dateFrom: String? = null,
    @SerialName("dateTo")
    val dateTo: String? = null,
    @SerialName("permission")
    val permission: String? = null
)

@Serializable
data class ResultSet(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("competitions")
    val competitions: String? = null,
    @SerialName("first")
    val first: String? = null,
    @SerialName("last")
    val last: String? = null,
    @SerialName("played")
    val played: Int? = null
)

@Serializable
data class Match(
    @SerialName("area")
    val area: MatchArea? = null,
    @SerialName("competition")
    val competition: MatchCompetition? = null,
    @SerialName("season")
    val season: Season? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("utcDate")
    val utcDate: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("matchday")
    val matchday: Int? = null,
    @SerialName("stage")
    val stage: String? = null,
    @SerialName("group")
    val group: String? = null,
    @SerialName("lastUpdated")
    val lastUpdated: String? = null,
    @SerialName("homeTeam")
    val homeTeam: MatchTeam? = null,
    @SerialName("awayTeam")
    val awayTeam: MatchTeam? = null,
    @SerialName("score")
    val score: Score? = null,
    @SerialName("odds")
    val odds: Odds? = null,
    @SerialName("referees")
    val referees: List<Referee>? = null
)

@Serializable
data class MatchArea(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("code")
    val code: String? = null,
    @SerialName("flag")
    val flag: String? = null
)

@Serializable
data class MatchCompetition(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("code")
    val code: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("emblem")
    val emblem: String? = null
)

@Serializable
data class Season(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("startDate")
    val startDate: String? = null,
    @SerialName("endDate")
    val endDate: String? = null,
    @SerialName("currentMatchday")
    val currentMatchday: Int? = null,
    @SerialName("winner")
    val winner: String? = null
)

@Serializable
data class MatchTeam(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("shortName")
    val shortName: String? = null,
    @SerialName("tla")
    val tla: String? = null,
    @SerialName("crest")
    val crest: String? = null
)

@Serializable
data class Score(
    @SerialName("winner")
    val winner: String? = null,
    @SerialName("duration")
    val duration: String? = null,
    @SerialName("fullTime")
    val fullTime: ScoreDetail? = null,
    @SerialName("halfTime")
    val halfTime: ScoreDetail? = null
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
    val msg: String? = null
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

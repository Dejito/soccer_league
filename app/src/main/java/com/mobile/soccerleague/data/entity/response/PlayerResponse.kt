package com.mobile.soccerleague.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PlayerResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("lastName")
    val lastName: String,

    @SerialName("dateOfBirth")
    val dateOfBirth: String,

    @SerialName("nationality")
    val nationality: String,

    @SerialName("position")
    val position: String,

    @SerialName("shirtNumber")
    val shirtNumber: Int,

    @SerialName("lastUpdated")
    val lastUpdated: String,

    @SerialName("currentTeam")
    val currentTeam: PlayerTeam
)

@Serializable
data class PlayerTeam(
    @SerialName("area")
    val area: PlayerArea,

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("shortName")
    val shortName: String,

    @SerialName("tla")
    val tla: String,

    @SerialName("crest")
    val crest: String,

    @SerialName("address")
    val address: String,

    @SerialName("website")
    val website: String,

    @SerialName("founded")
    val founded: Int,

    @SerialName("clubColors")
    val clubColors: String,

    @SerialName("venue")
    val venue: String,

    @SerialName("runningCompetitions")
    val runningCompetitions: List<PlayerCompetition> = listOf(),

    @SerialName("contract")
    val contract: Contract
)

@Serializable
data class PlayerArea(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("code")
    val code: String,

    @SerialName("flag")
    val flag: String
)

@Serializable
data class PlayerCompetition(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("code")
    val code: String,

    @SerialName("type")
    val type: String,

    @SerialName("emblem")
    val emblem: String
)

@Serializable
data class Contract(
    @SerialName("start")
    val start: String,

    @SerialName("until")
    val until: String
)

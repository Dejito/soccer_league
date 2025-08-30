package com.mobile.soccerleague.data.local


data class Score (
    val utcDate: String,
    val currentMatchDay: Int,
    val homeTeam: String,
    val awayTeam: String,
    val timeSpent: Int,
    val awayScore: Int,
    val homeScore: Int,

)

data class ProdCategory (
    val id: Int,
    val name: String? = "",
    val image: String? = "",
    val slug: String? = ""
)
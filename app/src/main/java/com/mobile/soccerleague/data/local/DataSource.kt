package com.mobile.soccerleague.data.local

import com.mobile.soccerleague.data.local.Score


class DataSource {

//    fun loadDurations(): List<String> {
//        return listOf("Recent","Today","Last 7 Days","Last 14 Days","Last 30 Days","Last 3 Months","All Time","Custom")
//    }

    fun loadScores(): List<Score> {
        return listOf(
            Score(
                utcDate = "12:30",
                currentMatchDay = 3,
                awayTeam = "Fulham",
                homeTeam = "Chelsea",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "13:30",
                currentMatchDay = 3,
                awayTeam = "Man Utd",
                homeTeam = "Arsenal",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "14:30",
                currentMatchDay = 3,
                awayTeam = "Liverpool",
                homeTeam = "City",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "12:30",
                currentMatchDay = 3,
                awayTeam = "Nottingham Forest",
                homeTeam = "Astin Villa",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "12:30",
                currentMatchDay = 3,
                awayTeam = "Fulham",
                homeTeam = "Chelsea",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "12:30",
                currentMatchDay = 3,
                awayTeam = "Fulham",
                homeTeam = "Chelsea",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "19:30",
                currentMatchDay = 3,
                awayTeam = "Besiktas",
                homeTeam = "Fernabache",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "12:30",
                currentMatchDay = 3,
                awayTeam = "Fulham",
                homeTeam = "Chelsea",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),
            Score(
                utcDate = "12:30",
                currentMatchDay = 3,
                awayTeam = "Fulham",
                homeTeam = "Chelsea",
                awayScore = 1,
                homeScore = 3,
                timeSpent = 72
            ),

        )
    }


}
package com.mobile.soccerleague.presentation.livescores.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.soccerleague.di.livescore.viewmodel.LiveScoresViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.mobile.soccerleague.presentation.components.KegowDivider
import com.mobile.soccerleague.data.local.DataSource
import com.mobile.soccerleague.data.local.Score


@Composable
fun LiveScores(modifier: Modifier = Modifier, matchesViewModel: LiveScoresViewModel = koinViewModel()) {

    val scoresList = DataSource().loadScores()

    Scaffold(
//        topBar = TopAppBar(title = "", actions = {})
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyColumn(
//                contentPadding = PaddingValues(6.dp)
            ) {
                items(scoresList) { score ->
                    MatchCard(score)
                }
            }

        }
    }
}

@Composable
fun MatchCard(score: Score) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left column (status, time, MD)
            Column(
                modifier = Modifier.width(60.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "TIMED",
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = score.utcDate,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "MD: ${score.currentMatchDay}",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Middle column (teams)
            Column(
                modifier = Modifier.weight(1f)

            ) {
                Text(
                    text = score.homeTeam,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = score.awayTeam,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Right column (scores + minute)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "30",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = score.homeScore.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = score.awayScore.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }


        }

       KegowDivider(height = 1.0, color = Color.Gray)

    }

}

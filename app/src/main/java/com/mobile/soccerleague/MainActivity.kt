package com.mobile.soccerleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.soccerleague.di.SampleScreen
import com.mobile.soccerleague.presentation.livescores.view.LiveScores
import com.mobile.soccerleague.ui.theme.SoccerLeagueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerLeagueTheme {
//                LiveScores()
                SampleScreen()
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SoccerLeagueTheme {
//        Greeting("Android")
//    }
//}
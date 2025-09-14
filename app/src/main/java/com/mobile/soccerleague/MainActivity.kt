package com.mobile.soccerleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mobile.soccerleague.presentation.leagues.SampleScreen
import com.mobile.soccerleague.presentation.matches.view.LivescoreScreen
import com.mobile.soccerleague.ui.theme.SoccerLeagueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerLeagueTheme {
                LivescoreScreen()
//                SampleScreen()
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
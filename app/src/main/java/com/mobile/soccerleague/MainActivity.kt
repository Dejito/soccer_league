package com.mobile.soccerleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mobile.soccerleague.presentation.leagues.TestingView
import com.mobile.soccerleague.presentation.matches.view.LivescoresScreen
import com.mobile.soccerleague.ui.theme.SoccerLeagueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerLeagueTheme {
                LivescoresScreen()
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
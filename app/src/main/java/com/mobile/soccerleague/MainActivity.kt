package com.mobile.soccerleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.soccerleague.presentation.matches.SampleScreen
import com.mobile.soccerleague.ui.theme.SoccerLeagueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerLeagueTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SampleScreen(
//                        modifier = Modifier.padding(innerPadding)
                    )

                    //                        modifier = Modifier.padding(innerPadding)

//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                            .clickable(
//                                onClick = {
//
//                                }
//                            )
//                    )
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SoccerLeagueTheme {
        Greeting("Android")
    }
}
package com.animeapp.animeappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.animeapp.animeappproject.ui.screen.trending_anime_list.TrendingAnimeListScreen
import com.animeapp.animeappproject.ui.theme.AnimeAppProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeAppProjectTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = TrendingAnimeListRoute) {
                    composable<TrendingAnimeListRoute> {
                        TrendingAnimeListScreen()
                    }
                }
            }
        }
    }
}

@Serializable
object TrendingAnimeListRoute
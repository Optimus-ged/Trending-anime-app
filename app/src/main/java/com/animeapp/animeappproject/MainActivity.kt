package com.animeapp.animeappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.animeapp.animeappproject.ui.screen.trending_anime_list.TrendingAnimeListScreen
import com.animeapp.animeappproject.ui.theme.AnimeAppProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeAppProjectTheme {
                val navController = rememberNavController()
                val trendingAnimeListRoute = "trending_anime_list"
                NavHost(navController = navController, startDestination = trendingAnimeListRoute) {
                    composable(route = trendingAnimeListRoute) {
                        TrendingAnimeListScreen()
                    }
                }
            }
        }
    }
}
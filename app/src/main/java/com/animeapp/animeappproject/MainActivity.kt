@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.animeapp.animeappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.animeapp.animeappproject.ui.screen.anime.TrendingAnimeScreen
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
                SharedTransitionLayout {
                    NavHost(
                        navController = navController,
                        startDestination = TrendingAnimeListRoute
                    ) {
                        composable<TrendingAnimeListRoute> {
                            TrendingAnimeListScreen(
                                navController = navController,
                                animatedVisibilityScope = this
                            )
                        }
                        composable<AnimeScreen> {
                            val args = it.toRoute<AnimeScreen>()
                            TrendingAnimeScreen(
                                args.id,
                                args.coverImage,
                                animatedVisibilityScope = this
                            )
                        }
                    }
                }

            }
        }
    }
}

@Serializable
object TrendingAnimeListRoute

@Serializable
data class AnimeScreen(val id: String, val coverImage: String)
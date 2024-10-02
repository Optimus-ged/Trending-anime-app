package com.animeapp.animeappproject.ui.screen.trending_anime_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.animeapp.animeappproject.ui.screen.trending_anime_list.composable.AnimeCard

@Composable
fun TrendingAnimeListScreen(
    trendingAnimeViewModel: TrendingAnimeListScreenViewModel = hiltViewModel()
) {
    val state = trendingAnimeViewModel.state.value

    Scaffold {
            innerPadding -> Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(
                PaddingValues(
                    top = 15.dp + innerPadding.calculateTopPadding(),
                    bottom = 15.dp + innerPadding.calculateBottomPadding(),
                )
            )
    )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                if(state.isLoading){
                    CircularProgressIndicator()
                }else{
                    LazyColumn(
                        contentPadding = PaddingValues(
                            top = innerPadding.calculateTopPadding() + 10.dp,
                            start = 20.dp,
                            end = 20.dp,
                            bottom = innerPadding.calculateBottomPadding() + 10.dp,
                        ),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Text(
                                text = "Trending Anime",
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        items(state.trendingAnimeItems) { anime ->
                            AnimeCard(
                                anime = anime,
//                                onClick = {
//                                    onAnimeClick(anime.attributes.posterImage.original, anime.id)
//                                },
//                                animatedVisibilityScope = animatedVisibilityScope
                            )
                        }
                    }
                }
            }
        }
    }
}
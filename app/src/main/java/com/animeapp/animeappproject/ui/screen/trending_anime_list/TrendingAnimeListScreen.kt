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
                    top = 0.dp + innerPadding.calculateTopPadding(),
                    bottom = 0.dp + innerPadding.calculateBottomPadding(),
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
                            top = innerPadding.calculateTopPadding() + 0.dp,
                            start = 0.dp,
                            end = 0.dp,
                            bottom = innerPadding.calculateBottomPadding() + 0.dp,
                        ),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        item {
                            Text(
                                text = "Trending Anime",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    bottom = 10.dp
                                )
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
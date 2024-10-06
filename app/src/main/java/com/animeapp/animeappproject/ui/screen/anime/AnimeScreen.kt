@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.animeapp.animeappproject.ui.screen.anime

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun SharedTransitionScope.TrendingAnimeScreen(
    id: String,
    coverImage: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    animeScreenViewModel: AnimeScreenViewModel = hiltViewModel()
){
    LaunchedEffect(key1 = true) {
        animeScreenViewModel.fetchAnime(id)
    }
    val state = animeScreenViewModel.state.value

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding() + 0.dp)
        ) {
            item {
                AsyncImage(
                    model = coverImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 20.dp,
                                bottomEnd = 20.dp,
                            )
                        )
                        .sharedElement(
                            rememberSharedContentState(key = id),
                            animatedVisibilityScope = animatedVisibilityScope,
                        )
                )
            }

            item {
                if (state.isLoading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(
                                    height = 20.dp,
                                    width = 20.dp
                                )
                                .padding(PaddingValues(top = 20.dp))

                        )
                    }
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(
                                horizontal = 20.dp,
                                vertical = 16.dp,
                            )
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "${state.trendingAnime?.attributes?.canonicalTitle}",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = state.trendingAnime?.attributes?.startDate?.split("-")?.first() ?: "",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = " - ",
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(1.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Star,
                                    contentDescription = null,
                                    modifier = Modifier.padding(end = 4.dp)
                                )

                                Text(
                                    text = state.trendingAnime?.attributes?.averageRating ?: "", style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "Synopsis",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = state.trendingAnime?.attributes?.synopsis ?: "")
                        }
                    }
                }
            }

        }
    }

}
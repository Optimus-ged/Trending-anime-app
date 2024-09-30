package com.animeapp.animeappproject.ui.screen.trending_anime_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TrendingAnimeListScreen(
    trendingAnimeViewModel: TrendingAnimeListScreenViewModel = hiltViewModel()
) {
    val state = trendingAnimeViewModel.state.value

    Scaffold {
            innerPadding -> Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(PaddingValues(
            top = 15.dp + innerPadding.calculateTopPadding(),
            bottom = 15.dp + innerPadding.calculateBottomPadding(),
        )))
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                if(state.isLoading){
                    CircularProgressIndicator()
                }else{
                    Text(text = state.trendingAnimeItems.first().id,
                        fontSize = 72.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
    }
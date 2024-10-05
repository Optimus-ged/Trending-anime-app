package com.animeapp.animeappproject.ui.screen.anime

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SharedTransitionScope(
    animeScreenViewModel: AnimeScreenViewModel = hiltViewModel()
){
    val state = animeScreenViewModel.state.value
}
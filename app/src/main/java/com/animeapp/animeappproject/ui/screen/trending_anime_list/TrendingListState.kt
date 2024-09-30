package com.animeapp.animeappproject.ui.screen.trending_anime_list

import com.animeapp.animeappproject.domain.model.AnimeData

data class TrendingListState(
    val trendingAnimeItems : List<AnimeData> = emptyList(),
    val isLoading : Boolean = false
)
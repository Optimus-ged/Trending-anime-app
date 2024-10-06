package com.animeapp.animeappproject.ui.screen.anime

import com.animeapp.animeappproject.domain.model.AnimeData

data class TrendingAnimeState(
    val trendingAnime : AnimeData? = null,
    val isLoading : Boolean = false
)

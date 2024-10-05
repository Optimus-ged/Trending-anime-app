package com.animeapp.animeappproject.ui.screen.anime

import com.animeapp.animeappproject.domain.model.AnimeData

data class TrendingAnimeState(
    private val trendingAnime : AnimeData? = null,
    private val isLoading : Boolean = false
)

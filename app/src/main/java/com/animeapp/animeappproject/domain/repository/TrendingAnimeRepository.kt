package com.animeapp.animeappproject.domain.repository

import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.domain.model.AnimeData
import kotlinx.coroutines.flow.Flow

interface TrendingAnimeRepository {
    fun getTrendingAnime(): Flow<Resource<List<AnimeData>>>
    fun getAnimeById(id: Int): Flow<Resource<AnimeData?>>
}
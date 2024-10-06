package com.animeapp.animeappproject.domain.use_case

import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.domain.model.AnimeData
import com.animeapp.animeappproject.domain.repository.TrendingAnimeRepository
import kotlinx.coroutines.flow.Flow

class GetTrendingAnimeById(
    private val repository: TrendingAnimeRepository
) {
    operator fun invoke(id : String) : Flow<Resource<AnimeData?>> {
        return  repository.getAnimeById(id)
    }
}
package com.animeapp.animeappproject.domain.use_case

import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.domain.model.AnimeData
import com.animeapp.animeappproject.domain.repository.TrendingAnimeRepository
import kotlinx.coroutines.flow.Flow

class GetTrendingAnimeList(
    private val repository: TrendingAnimeRepository
) {
    operator fun invoke() : Flow<Resource<List<AnimeData>>>  {
        return repository.getTrendingAnime()
    }
}
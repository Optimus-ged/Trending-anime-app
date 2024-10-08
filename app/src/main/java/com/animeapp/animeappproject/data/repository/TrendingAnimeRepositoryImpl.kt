package com.animeapp.animeappproject.data.repository

import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.data.network.AnimeAppApi
import com.animeapp.animeappproject.domain.model.AnimeData
import com.animeapp.animeappproject.domain.repository.TrendingAnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class TrendingAnimeRepositoryImpl(
    private val api : AnimeAppApi
) : TrendingAnimeRepository {
    override fun getTrendingAnime(): Flow<Resource<List<AnimeData>>> = flow {
        emit(Resource.Loading())
        try {
            val result = api.getTrendingAnime()
            emit(Resource.Success(
                data = result.data.map { it.toModel() }
            ))
        } catch(e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
            ))
        }
    }

    override fun getAnimeById(id: String): Flow<Resource<AnimeData?>> = flow {
        emit(Resource.Loading())
        try {
            val result : AnimeData = api.getAnime(id).data.toModel()
            println("nzolani ---> ${result.id}")
            emit(Resource.Success(data = result))
        } catch(e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
            ))
        }
    }

}
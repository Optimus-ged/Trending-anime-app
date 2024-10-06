package com.animeapp.animeappproject.data.network

import com.animeapp.animeappproject.data.network.dto.*
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeAppApi {
    @GET("trending/anime")
    suspend fun getTrendingAnime(): TrendingAnimeListDto

    @GET("anime/{id}")
    suspend fun getAnime(
        @Path("id") id: String
    ): AnimeResponseDto

    companion object {
        const val BASE_URL = "https://kitsu.io/api/edge/"
    }
}
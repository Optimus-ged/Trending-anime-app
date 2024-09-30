package com.animeapp.animeappproject.di

import com.animeapp.animeappproject.data.network.AnimeAppApi
import com.animeapp.animeappproject.data.repository.TrendingAnimeRepositoryImpl
import com.animeapp.animeappproject.domain.repository.TrendingAnimeRepository
import com.animeapp.animeappproject.domain.use_case.GetTrendingAnimeById
import com.animeapp.animeappproject.domain.use_case.GetTrendingAnimeList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrendingAnimeModule {
    @Provides
    @Singleton
    fun providesGetTrendingAnimeList(repository: TrendingAnimeRepository) : GetTrendingAnimeList {
        return GetTrendingAnimeList(repository)
    }

    @Provides
    @Singleton
    fun providesGetTrendingAnimeById(repository: TrendingAnimeRepository): GetTrendingAnimeById {
        return GetTrendingAnimeById(repository)
    }

    @Provides
    @Singleton
    fun providesRepository(api: AnimeAppApi) : TrendingAnimeRepository{
        return TrendingAnimeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesTrendingAnimeApi() : AnimeAppApi{
        return Retrofit.Builder()
            .baseUrl(AnimeAppApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeAppApi::class.java)
    }
}
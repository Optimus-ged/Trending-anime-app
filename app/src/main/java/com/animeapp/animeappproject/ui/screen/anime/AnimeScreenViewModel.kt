package com.animeapp.animeappproject.ui.screen.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.domain.use_case.GetTrendingAnimeById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeScreenViewModel @Inject constructor(
    private val getTrendingAnimeById: GetTrendingAnimeById
) : ViewModel(){

    private val _state = MutableStateFlow(TrendingAnimeState())
    val state = _state.asStateFlow()


    fun fetchAnime(id : String){
        viewModelScope.launch {
            getTrendingAnimeById(id).onEach { result -> when (result){
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        trendingAnime = result.data,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false
                    )
                }
            }
            }.launchIn(this)
        }
    }


}
package com.animeapp.animeappproject.ui.screen.anime

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.domain.use_case.GetTrendingAnimeById
import com.animeapp.animeappproject.ui.screen.trending_anime_list.TrendingListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeScreenViewModel @Inject constructor(
    private val getTrendingAnimeById: GetTrendingAnimeById
) : ViewModel(){

    private val _state = mutableStateOf(TrendingAnimeState())
    var state : State<TrendingAnimeState> = _state

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
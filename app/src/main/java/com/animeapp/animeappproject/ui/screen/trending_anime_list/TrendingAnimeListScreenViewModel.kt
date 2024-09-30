package com.animeapp.animeappproject.ui.screen.trending_anime_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animeapp.animeappproject.core.util.Resource
import com.animeapp.animeappproject.domain.use_case.GetTrendingAnimeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingAnimeListScreenViewModel @Inject constructor(
    private val getTrendingAnimeList: GetTrendingAnimeList
) : ViewModel() {

    private val _state = mutableStateOf(TrendingListState())
    var state : State<TrendingListState> = _state
    private fun fetchData(){
        viewModelScope.launch {
            getTrendingAnimeList().onEach {
                    result -> when (result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        trendingAnimeItems = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
            }
            }.launchIn(this)
        }
    }

    init {
        fetchData()
    }
}
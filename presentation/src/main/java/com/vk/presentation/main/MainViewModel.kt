package com.vk.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vk.domain.models.Pokemon
import com.vk.domain.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  val getPokemonsUseCase: GetPokemonsUseCase,
) : ViewModel() {

  private var _data = MutableStateFlow<PagingData<Pokemon>>(PagingData.empty())
  val data = _data.asStateFlow()

  fun load() {
    viewModelScope.launch {
      getPokemonsUseCase()
        .cachedIn(viewModelScope)
        .collect {
          _data.value = it
        }
    }
  }

  init {
    load()
  }
}
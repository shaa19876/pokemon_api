package com.vk.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.domain.repository.RequestResult
import com.vk.domain.usecase.GetDetailPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
  val getDetailPokemonUseCase: GetDetailPokemonUseCase,
) : ViewModel() {

  private var _state = MutableStateFlow<State>(State.None)
  val state = _state.asStateFlow()

  fun load(name: String) {
    viewModelScope.launch{
      getDetailPokemonUseCase(name)
        .collect {
          _state.value = it.toState()
        }
    }
  }
}

private fun RequestResult.toState(): State {
  return when (this) {
    is RequestResult.Error -> State.Error
    is RequestResult.Loading -> State.Loading
    is RequestResult.Success<*> -> State.Success(data)
  }
}
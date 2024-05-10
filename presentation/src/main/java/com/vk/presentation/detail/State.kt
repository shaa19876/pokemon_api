package com.vk.presentation.detail

sealed class State {
    data object None : State()
    data object Loading : State()
    data object Error : State()
    class Success<T>(val data: T) : State()
}
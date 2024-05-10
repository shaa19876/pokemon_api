package com.vk.domain.repository

sealed class RequestResult {
    class Success<T>(val data: T) : RequestResult()
    data object Loading : RequestResult()
    data object Error : RequestResult()
}

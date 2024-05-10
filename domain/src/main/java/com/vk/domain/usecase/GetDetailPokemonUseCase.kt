package com.vk.domain.usecase

import com.vk.domain.repository.PokemonRepository
import com.vk.domain.repository.RequestResult
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetDetailPokemonUseCase @Inject constructor(
  private val repository: PokemonRepository
) {
  operator fun invoke(name: String): Flow<RequestResult> = repository.getDetailPokemon(name)
}
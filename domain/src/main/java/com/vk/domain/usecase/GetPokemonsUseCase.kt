package com.vk.domain.usecase

import androidx.paging.PagingData
import com.vk.domain.models.Pokemon
import com.vk.domain.repository.PokemonRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetPokemonsUseCase @Inject constructor(
  private val repository: PokemonRepository
) {

  operator fun invoke(): Flow<PagingData<Pokemon>> = repository.getPokemons()
}
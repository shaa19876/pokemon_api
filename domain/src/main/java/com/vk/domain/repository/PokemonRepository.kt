package com.vk.domain.repository

import androidx.paging.PagingData
import com.vk.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
  fun getPokemons(): Flow<PagingData<Pokemon>>

  fun getDetailPokemon(name: String): Flow<RequestResult>
}
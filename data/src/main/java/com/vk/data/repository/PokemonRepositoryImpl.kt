package com.vk.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vk.data.api.PokemonApi
import com.vk.data.paging.PokemonPagingSource
import com.vk.data.util.toDetailPokemonDomain
import com.vk.domain.models.Pokemon
import com.vk.domain.repository.PokemonRepository
import com.vk.domain.repository.RequestResult
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge

class PokemonRepositoryImpl @Inject constructor(
  private val api: PokemonApi
) : PokemonRepository {

  override fun getPokemons(): Flow<PagingData<Pokemon>> = Pager(
    PagingConfig(
      pageSize = PokemonApi.DEFAULT_PAGE_SIZE
    ),
    pagingSourceFactory = { PokemonPagingSource(api) }
  ).flow

  override fun getDetailPokemon(name: String): Flow<RequestResult> {
    val start = flowOf(RequestResult.Loading)

    val response = flow {
      emit(api.getDetailPokemon(name))
    }.map { result ->
      if (result.isSuccess) {
        result.getOrThrow()
          .toDetailPokemonDomain()
          .let { RequestResult.Success(it) }
      } else {
        RequestResult.Error
      }
    }
    return merge(start, response)
  }
}
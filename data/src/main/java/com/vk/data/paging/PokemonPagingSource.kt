package com.vk.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vk.data.api.PokemonApi
import com.vk.data.util.toPokemonDomain
import com.vk.domain.models.Pokemon
import jakarta.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val api: PokemonApi
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            val pageNumber = params.key ?: 0
            val pageSize = params.loadSize.coerceAtMost(PokemonApi.DEFAULT_PAGE_SIZE)
            val response =
                api.getAllPokemon(
                    offset = pageNumber * PokemonApi.DEFAULT_PAGE_SIZE,
                    limit = pageSize
                )

            return if (response.isSuccess) {

                val results = response.getOrThrow().results
                    .map { pokemonDTO -> pokemonDTO.toPokemonDomain() }

                val nextPageNumber = if (results.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null

                LoadResult.Page(results, prevPageNumber, nextPageNumber)
            } else {
                LoadResult.Error(Exception())
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}
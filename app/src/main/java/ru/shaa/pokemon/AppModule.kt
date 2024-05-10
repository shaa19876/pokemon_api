package ru.shaa.pokemon

import com.vk.data.api.PokemonApi
import com.vk.data.api.pokemonApi
import com.vk.data.repository.PokemonRepositoryImpl
import com.vk.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  private const val BASE_URL = "https://pokeapi.co/api/v2/"

  @Provides
  @Singleton
  fun providePokemonApi(): PokemonApi {
    return pokemonApi(BASE_URL)
  }

  @Provides
  @Singleton
  fun provideRepository(): PokemonRepository {
    return PokemonRepositoryImpl(api = providePokemonApi())
  }
}
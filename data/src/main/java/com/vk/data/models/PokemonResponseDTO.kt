package com.vk.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponseDTO(
  val count: Int,
  val next: String?,
  val previous: String?,
  val results: List<PokemonDTO>,
)
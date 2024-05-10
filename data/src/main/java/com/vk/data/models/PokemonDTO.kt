package com.vk.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO(
    val name: String,
    val url: String,
)

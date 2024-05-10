package com.vk.domain.models

data class DetailPokemon(
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<String>,
    val baseExperience: Int,
    val abilities: List<String>,
    val imageUrl: String,
)

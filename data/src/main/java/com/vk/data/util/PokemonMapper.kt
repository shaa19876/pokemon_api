package com.vk.data.util

import com.vk.data.models.PokemonDTO
import com.vk.data.models.PokemonDetailDTO
import com.vk.domain.models.DetailPokemon
import com.vk.domain.models.Pokemon
import okhttp3.internal.format
import java.lang.StringBuilder

fun PokemonDTO.toPokemonDomain() = Pokemon(
    id = format(
        "#%3d",
        url.removeSuffix("/").split("/").last().toInt()
    ),
    name = name,
    imageUrl = url.toImageUrl()
)

fun PokemonDetailDTO.toDetailPokemonDomain() = DetailPokemon(
    name = name.replaceFirstChar { it.uppercase() },
    height = height,
    weight = weight,
    baseExperience = baseExperience,
    types = types.map { it.type.name },
    abilities = abilities.map { it.ability.name },
    imageUrl = sprites.other.home.frontDefault
)
package com.vk.data.util

fun String.toImageUrl(): String {
    val baseImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/"
    val extensionFile = ".png"
    val id = this.removeSuffix("/").split("/").last()
    return baseImageUrl + id + extensionFile
}
package com.turingalan.pokemon.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations(val route: String) {
    @Serializable
    object List: Destinations("listScreen")
    @Serializable
    data class Details(val id: Int): Destinations("detailsScreen/$id")
}
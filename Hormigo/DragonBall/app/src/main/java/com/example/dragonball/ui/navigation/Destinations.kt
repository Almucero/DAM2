package com.example.dragonball.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations(val route: String) {
    @Serializable
    data object CharacterList: Destinations("character_list")
    @Serializable
    data class CharacterDetail(val id: Long): Destinations("character_detail[$id]")
}
package com.example.dragonball.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations(val route: String) {
    @Serializable
    data object CharacterList: Destinations("character_list")
    @Serializable
    data class CharacterDetail(val id: Long): Destinations("character_detail[$id]")
    @Serializable
    data object PlanetList: Destinations("planet_list")
    @Serializable
    data class PlanetDetail(val id: Long): Destinations("planet_detail[$id]")
    @Serializable
    data object TransformationList: Destinations("transformation_list")
    @Serializable
    data class TransformationDetail(val id: Long): Destinations("transformation_detail[$id]")
}
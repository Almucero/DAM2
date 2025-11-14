package com.example.dragonball.data.remote.model

//Characters
data class CharacterListRemote(
    val results: List<CharacterListItemRemote>
)
data class CharacterListItemRemote(
    val id: Long,
    val name: String,
    val image: String,
)
data class CharacterRemote(
    val id: Long,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String,
//    val originPlanet: PlanetRemote,
//    val transformations: TransformationRemote
)

//Planets
data class PlanetListRemote(
    val results: List<PlanetListItemRemote>
)
data class PlanetListItemRemote(
    val id: Long,
    val name: String,
    val image: String
)
data class PlanetRemote(
    val id: Long,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
//    val characters: CharacterRemote
)

//Transformations
data class TransformationListRemote(
    val results: List<TransformationListItemRemote>
)
data class TransformationListItemRemote(
    val id: Long,
    val name: String,
    val image: String,
)
data class TransformationRemote(
    val id: Long,
    val name: String,
    val image: String,
    val ki: String,
//    val character: CharacterRemote
)
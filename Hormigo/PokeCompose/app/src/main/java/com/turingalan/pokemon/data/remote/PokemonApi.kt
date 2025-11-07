package com.turingalan.pokemon.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("/api/v2/pokemon/{id}")
    suspend fun readPokemon(@Path("id") id: Long): PokemonResponse
    @GET("/api/v2/pokemon/")
    suspend fun readAllPokemon(): PokemonListResponse
}

data class PokemonResponse(
    val id: Long,
    val name: String
)

data class PokemonListResponse(
    val results: List<PokemonResponse>
)
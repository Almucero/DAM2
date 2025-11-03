package com.example.lazyapp.data.repository

import com.example.lazyapp.data.model.Ability
import com.example.lazyapp.data.model.Champion
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    suspend fun readOne(id:Int): Champion?
    fun observeAll(): Flow<List<Champion>>
    suspend fun getNextId(): Int
    suspend fun removeChampion(id: Int)
    suspend fun addChampion(
        imageUrl: String,
        splashImageUrl: String,
        name: String,
        title: String,
        description: String,
        longDescription: String,
        hpBase: Double,
        hpPerLevel: Double,
        mpBase: Double,
        mpPerLevel: Double,
        adBase: Double,
        adPerLevel: Double,
        armorBase: Double,
        armorPerLevel: Double,
        mrBase: Double,
        mrPerLevel: Double,
        attackSpeedBase: Double,
        attackSpeedPerLevel: Double,
        moveSpeed: Int,
        range: Int,
        abilities: List<Ability>
    ): Boolean
}
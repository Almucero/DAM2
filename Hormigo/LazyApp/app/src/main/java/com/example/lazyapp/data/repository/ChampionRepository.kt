package com.example.lazyapp.data.repository

import com.example.lazyapp.data.model.Champion

interface ChampionRepository {
    suspend fun readOne(id:Int): Champion?
    suspend fun readAll():List<Champion>
}
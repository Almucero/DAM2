package com.gamesage.marvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 2)
abstract class MarvelDatabase(): RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
}
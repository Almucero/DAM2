package com.gamesage.marvel.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gamesage.marvel.data.model.Character

@Entity("character")
data class CharacterEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val image: String?,
    val originName: String
)

fun Character.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        image = this.image,
        originName = this.originName
    )
}

fun List<Character>.toEntity():List<CharacterEntity> = this.map(Character::toEntity)

fun CharacterEntity.toModel(): Character {
    return Character(
        id = this.id,
        name = this.name,
        image = this.image ?: "",
        originName = this.originName
    )
}

fun List<CharacterEntity>.toModel():List<Character> {
    return this.map(CharacterEntity::toModel)
}
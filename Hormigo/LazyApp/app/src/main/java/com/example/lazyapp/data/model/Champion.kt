package com.example.lazyapp.data.model

sealed class LocalizedString {
    data class Res(val resId: Int) : LocalizedString()
    data class Plain(val text: String) : LocalizedString()
}

data class Stats(
    val hpBase: Double,
    val hpPerLevel: Double,
    val mpBase: Double,
    val mpPerLevel: Double,
    val adBase: Double,
    val adPerLevel: Double,
    val armorBase: Double,
    val armorPerLevel: Double,
    val mrBase: Double,
    val mrPerLevel: Double,
    val attackSpeedBase: Double,
    val attackSpeedPerLevel: Double,
    val moveSpeed: Int,
    val range: Int
)

data class Ability(
    val id: String,
    val imageUrl: String,
    val name: LocalizedString,
    val description: LocalizedString,
    val cooldowns: String?,
    val costs: String?,
    val effects: LocalizedString?
)

data class Champion(
    val id: Int,
    val imageUrl: String,
    val name: LocalizedString,
    val title: LocalizedString,
    val description: LocalizedString,
    val splashImageUrl: String,
    val longDescription: LocalizedString,
    val stats: Stats,
    val abilities: List<Ability>,
    val deletable: Boolean
)
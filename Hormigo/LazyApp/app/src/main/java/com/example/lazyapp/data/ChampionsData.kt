package com.example.lazyapp.data

import com.example.lazyapp.R

data class Champion(val imageUrl: String, val name: Int, val title: Int, val description: Int)

val champions: List<Champion> = listOf(
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Annie_0.jpg",
        R.string.annie_label,
        R.string.annie_title,
        R.string.annie_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Diana_0.jpg",
        R.string.diana_label,
        R.string.diana_title,
        R.string.diana_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Fizz_0.jpg",
        R.string.fizz_label,
        R.string.fizz_title,
        R.string.fizz_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Irelia_0.jpg",
        R.string.irelia_label,
        R.string.irelia_title,
        R.string.irelia_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Leona_0.jpg",
        R.string.leona_label,
        R.string.leona_title,
        R.string.leona_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Mordekaiser_0.jpg",
        R.string.mordekaiser_label,
        R.string.mordekaiser_title,
        R.string.mordekaiser_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Neeko_0.jpg",
        R.string.neeko_label,
        R.string.neeko_title,
        R.string.neeko_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Senna_0.jpg",
        R.string.senna_label,
        R.string.senna_title,
        R.string.senna_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Taric_0.jpg",
        R.string.taric_label,
        R.string.taric_title,
        R.string.taric_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Teemo_0.jpg",
        R.string.teemo_label,
        R.string.teemo_title,
        R.string.teemo_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Vi_0.jpg",
        R.string.vi_label,
        R.string.vi_title,
        R.string.vi_description),
    Champion(
        "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ziggs_0.jpg",
        R.string.ziggs_label,
        R.string.ziggs_title,
        R.string.ziggs_description)
)
package com.example.lazyapp.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.example.lazyapp.R
import com.example.lazyapp.data.model.Ability
import com.example.lazyapp.data.model.Champion
import com.example.lazyapp.data.model.LocalizedString
import com.example.lazyapp.data.model.Stats
import kotlinx.coroutines.delay
import javax.inject.Inject

class ChampionInMemoryRepository @Inject constructor(): ChampionRepository {
    override suspend fun readOne(id: Int): Champion? {
        val champion = championList.firstOrNull() {
                c -> c.id == id
        }
        return champion
    }
    override suspend fun readAll(): List<Champion> {
        delay(5000L)
        return this.championList
    }
    val championList: MutableList<Champion> = mutableStateListOf( //champions
        Champion(
            1,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Annie.png",
            LocalizedString.Res(R.string.annie_label),
            LocalizedString.Res(R.string.annie_title),
            LocalizedString.Res(R.string.annie_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Annie_0.jpg",
            LocalizedString.Res(R.string.annie_longDescription),
            Stats(
                hpBase = 574.4,
                hpPerLevel = 92.0,
                mpBase = 334.0,
                mpPerLevel = 50.0,
                adBase = 50.41,
                adPerLevel = 2.625,
                armorBase = 19.22,
                armorPerLevel = 3.5,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.579,
                attackSpeedPerLevel = 0.0211,
                moveSpeed = 330,
                range = 625
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/annie/hud/icons2d/annie_passive.png",
                    LocalizedString.Res(R.string.annie_passive_label),
                    LocalizedString.Res(R.string.annie_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.annie_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/AnnieQ.png",
                    LocalizedString.Res(R.string.annie_q_label),
                    LocalizedString.Res(R.string.annie_q_description),
                    "4s / 4s / 4s / 4s / 4s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.annie_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/AnnieW.png",
                    LocalizedString.Res(R.string.annie_w_label),
                    LocalizedString.Res(R.string.annie_w_description),
                    "8s / 8s / 8s / 8s / 8s",
                    "50 / 55 / 60 / 65 / 70",
                    LocalizedString.Res(R.string.annie_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/AnnieE.png",
                    LocalizedString.Res(R.string.annie_e_label),
                    LocalizedString.Res(R.string.annie_e_description),
                    "12s / 12s / 12s / 12s / 12s",
                    "60 / 60 / 60 / 60 / 60",
                    LocalizedString.Res(R.string.annie_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/AnnieR.png",
                    LocalizedString.Res(R.string.annie_r_label),
                    LocalizedString.Res(R.string.annie_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.annie_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            2,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Diana.png",
            LocalizedString.Res(R.string.diana_label),
            LocalizedString.Res(R.string.diana_title),
            LocalizedString.Res(R.string.diana_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Diana_0.jpg",
            LocalizedString.Res(R.string.diana_longDescription),
            Stats(
                hpBase = 610.0,
                hpPerLevel = 92.0,
                mpBase = 288.0,
                mpPerLevel = 30.0,
                adBase = 57.0,
                adPerLevel = 3.2,
                armorBase = 25.0,
                armorPerLevel = 3.3,
                mrBase = 32.1,
                mrPerLevel = 1.25,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 345,
                range = 150
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/diana/hud/icons2d/diana_passive.png",
                    LocalizedString.Res(R.string.diana_passive_label),
                    LocalizedString.Res(R.string.diana_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.diana_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/DianaQ.png",
                    LocalizedString.Res(R.string.diana_q_label),
                    LocalizedString.Res(R.string.diana_q_description),
                    "4s / 4s / 4s / 4s / 4s",
                    "40 / 45 / 50 / 55 / 60",
                    LocalizedString.Res(R.string.diana_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/DianaOrbs.png",
                    LocalizedString.Res(R.string.diana_w_label),
                    LocalizedString.Res(R.string.diana_w_description),
                    "11s / 11s / 11s / 11s / 11s",
                    "30 / 35 / 40 / 45 / 50",
                    LocalizedString.Res(R.string.diana_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/DianaTeleport.png",
                    LocalizedString.Res(R.string.diana_e_label),
                    LocalizedString.Res(R.string.diana_e_description),
                    "10s / 10s / 10s / 10s / 10s",
                    "40 / 45 / 50 / 55 / 60",
                    LocalizedString.Res(R.string.diana_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/DianaR.png",
                    LocalizedString.Res(R.string.diana_r_label),
                    LocalizedString.Res(R.string.diana_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.diana_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            3,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Fizz.png",
            LocalizedString.Res(R.string.fizz_label),
            LocalizedString.Res(R.string.fizz_title),
            LocalizedString.Res(R.string.fizz_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Fizz_0.jpg",
            LocalizedString.Res(R.string.fizz_longDescription),
            Stats(
                hpBase = 582.0,
                hpPerLevel = 95.0,
                mpBase = 265.0,
                mpPerLevel = 40.0,
                adBase = 59.0,
                adPerLevel = 2.7,
                armorBase = 21.0,
                armorPerLevel = 3.4,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.694,
                attackSpeedPerLevel = 0.025,
                moveSpeed = 335,
                range = 125
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/fizz/hud/icons2d/fizz_passive.png",
                    LocalizedString.Res(R.string.fizz_passive_label),
                    LocalizedString.Res(R.string.fizz_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.fizz_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/FizzQ.png",
                    LocalizedString.Res(R.string.fizz_q_label),
                    LocalizedString.Res(R.string.fizz_q_description),
                    "6s / 6s / 6s / 6s / 6s",
                    "30 / 35 / 40 / 45 / 50",
                    LocalizedString.Res(R.string.fizz_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/FizzW.png",
                    LocalizedString.Res(R.string.fizz_w_label),
                    LocalizedString.Res(R.string.fizz_w_description),
                    "9s / 9s / 9s / 9s / 9s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.fizz_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/FizzE.png",
                    LocalizedString.Res(R.string.fizz_e_label),
                    LocalizedString.Res(R.string.fizz_e_description),
                    "20s / 18s / 16s / 14s / 12s",
                    "50 / 50 / 50 / 50 / 50",
                    LocalizedString.Res(R.string.fizz_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/FizzR.png",
                    LocalizedString.Res(R.string.fizz_r_label),
                    LocalizedString.Res(R.string.fizz_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.fizz_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            4,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Irelia.png",
            LocalizedString.Res(R.string.irelia_label),
            LocalizedString.Res(R.string.irelia_title),
            LocalizedString.Res(R.string.irelia_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Irelia_0.jpg",
            LocalizedString.Res(R.string.irelia_longDescription),
            Stats(
                hpBase = 580.0,
                hpPerLevel = 95.0,
                mpBase = 0.0,
                mpPerLevel = 0.0,
                adBase = 64.0,
                adPerLevel = 4.0,
                armorBase = 26.0,
                armorPerLevel = 4.0,
                mrBase = 32.1,
                mrPerLevel = 1.25,
                attackSpeedBase = 0.665,
                attackSpeedPerLevel = 0.027,
                moveSpeed = 345,
                range = 125
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/irelia/hud/icons2d/irelia_passive.png",
                    LocalizedString.Res(R.string.irelia_passive_label),
                    LocalizedString.Res(R.string.irelia_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.irelia_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/IreliaQ.png",
                    LocalizedString.Res(R.string.irelia_q_label),
                    LocalizedString.Res(R.string.irelia_q_description),
                    "10s / 9s / 8s / 7s / 6s",
                    null,
                    LocalizedString.Res(R.string.irelia_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/IreliaW.png",
                    LocalizedString.Res(R.string.irelia_w_label),
                    LocalizedString.Res(R.string.irelia_w_description),
                    "14s / 14s / 14s / 14s / 14s",
                    null,
                    LocalizedString.Res(R.string.irelia_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/IreliaE.png",
                    LocalizedString.Res(R.string.irelia_e_label),
                    LocalizedString.Res(R.string.irelia_e_description),
                    "6s / 6s / 6s / 6s / 6s",
                    null,
                    LocalizedString.Res(R.string.irelia_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/IreliaR.png",
                    LocalizedString.Res(R.string.irelia_r_label),
                    LocalizedString.Res(R.string.irelia_r_description),
                    "120s / 90s / 60s",
                    null,
                    LocalizedString.Res(R.string.irelia_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            5,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Leona.png",
            LocalizedString.Res(R.string.leona_label),
            LocalizedString.Res(R.string.leona_title),
            LocalizedString.Res(R.string.leona_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Leona_0.jpg",
            LocalizedString.Res(R.string.leona_longDescription),
            Stats(
                hpBase = 576.6,
                hpPerLevel = 92.0,
                mpBase = 302.2,
                mpPerLevel = 40.0,
                adBase = 60.04,
                adPerLevel = 3.5,
                armorBase = 47.88,
                armorPerLevel = 3.8,
                mrBase = 32.1,
                mrPerLevel = 1.25,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 335,
                range = 125
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/leona/hud/icons2d/leona_passive.png",
                    LocalizedString.Res(R.string.leona_passive_label),
                    LocalizedString.Res(R.string.leona_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.leona_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/LeonaShieldOfDaybreak.png",
                    LocalizedString.Res(R.string.leona_q_label),
                    LocalizedString.Res(R.string.leona_q_description),
                    "9s / 9s / 9s / 9s / 9s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.leona_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/LeonaSolarBarrier.png",
                    LocalizedString.Res(R.string.leona_w_label),
                    LocalizedString.Res(R.string.leona_w_description),
                    "14s / 14s / 14s / 14s / 14s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.leona_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/LeonaZenithBlade.png",
                    LocalizedString.Res(R.string.leona_e_label),
                    LocalizedString.Res(R.string.leona_e_description),
                    "22s / 20s / 18s / 16s / 14s",
                    "70 / 75 / 80 / 85 / 90",
                    LocalizedString.Res(R.string.leona_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/LeonaSolarFlare.png",
                    LocalizedString.Res(R.string.leona_r_label),
                    LocalizedString.Res(R.string.leona_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.leona_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            6,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Mordekaiser.png",
            LocalizedString.Res(R.string.mordekaiser_label),
            LocalizedString.Res(R.string.mordekaiser_title),
            LocalizedString.Res(R.string.mordekaiser_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Mordekaiser_0.jpg",
            LocalizedString.Res(R.string.mordekaiser_longDescription),
            Stats(
                hpBase = 610.0,
                hpPerLevel = 100.0,
                mpBase = 0.0,
                mpPerLevel = 0.0,
                adBase = 60.0,
                adPerLevel = 3.5,
                armorBase = 36.0,
                armorPerLevel = 4.0,
                mrBase = 32.1,
                mrPerLevel = 1.25,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0211,
                moveSpeed = 335,
                range = 125
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/mordekaiser/hud/icons2d/mordekaiser_passive.png",
                    LocalizedString.Res(R.string.mordekaiser_passive_label),
                    LocalizedString.Res(R.string.mordekaiser_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.mordekaiser_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/MordekaiserQ.png",
                    LocalizedString.Res(R.string.mordekaiser_q_label),
                    LocalizedString.Res(R.string.mordekaiser_q_description),
                    "10s / 9s / 8s / 7s / 6s",
                    "40 / 45 / 50 / 55 / 60",
                    LocalizedString.Res(R.string.mordekaiser_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/MordekaiserW.png",
                    LocalizedString.Res(R.string.mordekaiser_w_label),
                    LocalizedString.Res(R.string.mordekaiser_w_description),
                    "14s / 13s / 12s / 11s / 10s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.mordekaiser_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/MordekaiserE.png",
                    LocalizedString.Res(R.string.mordekaiser_e_label),
                    LocalizedString.Res(R.string.mordekaiser_e_description),
                    "18s / 17s / 16s / 15s / 14s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.mordekaiser_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/MordekaiserR.png",
                    LocalizedString.Res(R.string.mordekaiser_r_label),
                    LocalizedString.Res(R.string.mordekaiser_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.mordekaiser_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            7,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Neeko.png",
            LocalizedString.Res(R.string.neeko_label),
            LocalizedString.Res(R.string.neeko_title),
            LocalizedString.Res(R.string.neeko_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Neeko_0.jpg",
            LocalizedString.Res(R.string.neeko_longDescription),
            Stats(
                hpBase = 560.0,
                hpPerLevel = 92.0,
                mpBase = 350.0,
                mpPerLevel = 55.0,
                adBase = 55.0,
                adPerLevel = 3.0,
                armorBase = 21.0,
                armorPerLevel = 3.5,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 330,
                range = 550
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/neeko/hud/icons2d/neeko_passive.png",
                    LocalizedString.Res(R.string.neeko_passive_label),
                    LocalizedString.Res(R.string.neeko_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.neeko_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/NeekoQ.png",
                    LocalizedString.Res(R.string.neeko_q_label),
                    LocalizedString.Res(R.string.neeko_q_description),
                    "8s / 8s / 8s / 8s / 8s",
                    "50 / 55 / 60 / 65 / 70",
                    LocalizedString.Res(R.string.neeko_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/NeekoW.png",
                    LocalizedString.Res(R.string.neeko_w_label),
                    LocalizedString.Res(R.string.neeko_w_description),
                    "14s / 14s / 14s / 14s / 14s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.neeko_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/NeekoE.png",
                    LocalizedString.Res(R.string.neeko_e_label),
                    LocalizedString.Res(R.string.neeko_e_description),
                    "12s / 11s / 10s / 9s / 8s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.neeko_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/NeekoR.png",
                    LocalizedString.Res(R.string.neeko_r_label),
                    LocalizedString.Res(R.string.neeko_r_description),
                    "130s / 110s / 90s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.neeko_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            8,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Senna.png",
            LocalizedString.Res(R.string.senna_label),
            LocalizedString.Res(R.string.senna_title),
            LocalizedString.Res(R.string.senna_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Senna_0.jpg",
            LocalizedString.Res(R.string.senna_longDescription),
            Stats(
                hpBase = 580.0,
                hpPerLevel = 95.0,
                mpBase = 300.0,
                mpPerLevel = 50.0,
                adBase = 55.0,
                adPerLevel = 2.6,
                armorBase = 28.0,
                armorPerLevel = 3.0,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 330,
                range = 600
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/senna/hud/icons2d/senna_passive.png",
                    LocalizedString.Res(R.string.senna_passive_label),
                    LocalizedString.Res(R.string.senna_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.senna_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/SennaQ.png",
                    LocalizedString.Res(R.string.senna_q_label),
                    LocalizedString.Res(R.string.senna_q_description),
                    "7s / 6.5s / 6s / 5.5s / 5s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.senna_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/SennaW.png",
                    LocalizedString.Res(R.string.senna_w_label),
                    LocalizedString.Res(R.string.senna_w_description),
                    "16s / 16s / 16s / 16s / 16s",
                    "50 / 55 / 60 / 65 / 70",
                    LocalizedString.Res(R.string.senna_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/SennaE.png",
                    LocalizedString.Res(R.string.senna_e_label),
                    LocalizedString.Res(R.string.senna_e_description),
                    "13s / 12s / 11s / 10s / 9s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.senna_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/SennaR.png",
                    LocalizedString.Res(R.string.senna_r_label),
                    LocalizedString.Res(R.string.senna_r_description),
                    "100s / 85s / 70s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.senna_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            9,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Taric.png",
            LocalizedString.Res(R.string.taric_label),
            LocalizedString.Res(R.string.taric_title),
            LocalizedString.Res(R.string.taric_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Taric_0.jpg",
            LocalizedString.Res(R.string.taric_longDescription),
            Stats(
                hpBase = 590.0,
                hpPerLevel = 95.0,
                mpBase = 250.0,
                mpPerLevel = 40.0,
                adBase = 60.0,
                adPerLevel = 3.3,
                armorBase = 27.0,
                armorPerLevel = 3.8,
                mrBase = 32.1,
                mrPerLevel = 1.25,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 330,
                range = 175
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/taric/hud/icons2d/taric_passive.png",
                    LocalizedString.Res(R.string.taric_passive_label),
                    LocalizedString.Res(R.string.taric_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.taric_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TaricQ.png",
                    LocalizedString.Res(R.string.taric_q_label),
                    LocalizedString.Res(R.string.taric_q_description),
                    "9s / 9s / 9s / 9s / 9s",
                    "40 / 45 / 50 / 55 / 60",
                    LocalizedString.Res(R.string.taric_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TaricW.png",
                    LocalizedString.Res(R.string.taric_w_label),
                    LocalizedString.Res(R.string.taric_w_description),
                    "6s / 6s / 6s / 6s / 6s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.taric_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TaricE.png",
                    LocalizedString.Res(R.string.taric_e_label),
                    LocalizedString.Res(R.string.taric_e_description),
                    "22s / 20s / 18s / 16s / 14s",
                    "50 / 55 / 60 / 65 / 70",
                    LocalizedString.Res(R.string.taric_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TaricR.png",
                    LocalizedString.Res(R.string.taric_r_label),
                    LocalizedString.Res(R.string.taric_r_description),
                    "120s / 110s / 100s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.taric_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            10,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Teemo.png",
            LocalizedString.Res(R.string.teemo_label),
            LocalizedString.Res(R.string.teemo_title),
            LocalizedString.Res(R.string.teemo_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Teemo_0.jpg",
            LocalizedString.Res(R.string.teemo_longDescription),
            Stats(
                hpBase = 568.0,
                hpPerLevel = 86.0,
                mpBase = 268.0,
                mpPerLevel = 36.0,
                adBase = 54.0,
                adPerLevel = 2.7,
                armorBase = 24.0,
                armorPerLevel = 3.5,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.69,
                attackSpeedPerLevel = 0.0338,
                moveSpeed = 330,
                range = 500
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/teemo/hud/icons2d/teemo_passive.png",
                    LocalizedString.Res(R.string.teemo_passive_label),
                    LocalizedString.Res(R.string.teemo_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.teemo_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TeemoQ.png",
                    LocalizedString.Res(R.string.teemo_q_label),
                    LocalizedString.Res(R.string.teemo_q_description),
                    "16s / 14s / 12s / 10s / 8s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.teemo_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TeemoW.png",
                    LocalizedString.Res(R.string.teemo_w_label),
                    LocalizedString.Res(R.string.teemo_w_description),
                    "20s / 20s / 20s / 20s / 20s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.teemo_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TeemoE.png",
                    LocalizedString.Res(R.string.teemo_e_label),
                    LocalizedString.Res(R.string.teemo_e_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.teemo_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/TeemoR.png",
                    LocalizedString.Res(R.string.teemo_r_label),
                    LocalizedString.Res(R.string.teemo_r_description),
                    "120s / 110s / 100s",
                    "50 / 50 / 50",
                    LocalizedString.Res(R.string.teemo_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            11,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Vi.png",
            LocalizedString.Res(R.string.vi_label),
            LocalizedString.Res(R.string.vi_title),
            LocalizedString.Res(R.string.vi_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Vi_0.jpg",
            LocalizedString.Res(R.string.vi_longDescription),
            Stats(
                hpBase = 620.0,
                hpPerLevel = 95.0,
                mpBase = 100.0,
                mpPerLevel = 0.0,
                adBase = 64.0,
                adPerLevel = 4.0,
                armorBase = 36.0,
                armorPerLevel = 3.8,
                mrBase = 32.1,
                mrPerLevel = 1.25,
                attackSpeedBase = 0.644,
                attackSpeedPerLevel = 0.025,
                moveSpeed = 340,
                range = 125
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/vi/hud/icons2d/vi_passive.png",
                    LocalizedString.Res(R.string.vi_passive_label),
                    LocalizedString.Res(R.string.vi_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.vi_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ViQ.png",
                    LocalizedString.Res(R.string.vi_q_label),
                    LocalizedString.Res(R.string.vi_q_description),
                    "10s / 10s / 10s / 10s / 10s",
                    "30 / 35 / 40 / 45 / 50",
                    LocalizedString.Res(R.string.vi_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ViW.png",
                    LocalizedString.Res(R.string.vi_w_label),
                    LocalizedString.Res(R.string.vi_w_description),
                    "16s / 15s / 14s / 13s / 12s",
                    "0 / 0 / 0 / 0 / 0",
                    LocalizedString.Res(R.string.vi_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ViE.png",
                    LocalizedString.Res(R.string.vi_e_label),
                    LocalizedString.Res(R.string.vi_e_description),
                    "12s / 11s / 10s / 9s / 8s",
                    "30 / 35 / 40 / 45 / 50",
                    LocalizedString.Res(R.string.vi_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ViR.png",
                    LocalizedString.Res(R.string.vi_r_label),
                    LocalizedString.Res(R.string.vi_r_description),
                    "110s / 90s / 70s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.vi_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            12,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Ziggs.png",
            LocalizedString.Res(R.string.ziggs_label),
            LocalizedString.Res(R.string.ziggs_title),
            LocalizedString.Res(R.string.ziggs_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ziggs_0.jpg",
            LocalizedString.Res(R.string.ziggs_longDescription),
            Stats(
                hpBase = 556.0,
                hpPerLevel = 92.0,
                mpBase = 400.0,
                mpPerLevel = 50.0,
                adBase = 54.0,
                adPerLevel = 3.0,
                armorBase = 22.0,
                armorPerLevel = 3.0,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 325,
                range = 575
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/ziggs/hud/icons2d/ziggs_passive.png",
                    LocalizedString.Res(R.string.ziggs_passive_label),
                    LocalizedString.Res(R.string.ziggs_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.ziggs_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsQ.png",
                    LocalizedString.Res(R.string.ziggs_q_label),
                    LocalizedString.Res(R.string.ziggs_q_description),
                    "9s / 8s / 7s / 6s / 5s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.ziggs_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsW.png",
                    LocalizedString.Res(R.string.ziggs_w_label),
                    LocalizedString.Res(R.string.ziggs_w_description),
                    "14s / 14s / 14s / 14s / 14s",
                    "40 / 45 / 50 / 55 / 60",
                    LocalizedString.Res(R.string.ziggs_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsE.png",
                    LocalizedString.Res(R.string.ziggs_e_label),
                    LocalizedString.Res(R.string.ziggs_e_description),
                    "12s / 12s / 12s / 12s / 12s",
                    "50 / 55 / 60 / 65 / 70",
                    LocalizedString.Res(R.string.ziggs_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsR.png",
                    LocalizedString.Res(R.string.ziggs_r_label),
                    LocalizedString.Res(R.string.ziggs_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.ziggs_r_effect_1)
                )
            ),
            deletable = false
        ),

        Champion(
            13,
            "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/champion/Ziggs.png",
            LocalizedString.Res(R.string.ziggs_label),
            LocalizedString.Res(R.string.ziggs_title),
            LocalizedString.Res(R.string.ziggs_description),
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ziggs_0.jpg",
            LocalizedString.Res(R.string.ziggs_longDescription),
            Stats(
                hpBase = 556.0,
                hpPerLevel = 92.0,
                mpBase = 400.0,
                mpPerLevel = 50.0,
                adBase = 54.0,
                adPerLevel = 3.0,
                armorBase = 22.0,
                armorPerLevel = 3.0,
                mrBase = 30.0,
                mrPerLevel = 0.5,
                attackSpeedBase = 0.625,
                attackSpeedPerLevel = 0.0136,
                moveSpeed = 325,
                range = 575
            ),
            listOf(
                Ability(
                    "Passive",
                    "https://raw.communitydragon.org/latest/game/assets/characters/ziggs/hud/icons2d/ziggs_passive.png",
                    LocalizedString.Res(R.string.ziggs_passive_label),
                    LocalizedString.Res(R.string.ziggs_passive_description),
                    null,
                    null,
                    LocalizedString.Res(R.string.ziggs_passive_effect_1)
                ),
                Ability(
                    "Q",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsQ.png",
                    LocalizedString.Res(R.string.ziggs_q_label),
                    LocalizedString.Res(R.string.ziggs_q_description),
                    "9s / 8s / 7s / 6s / 5s",
                    "60 / 65 / 70 / 75 / 80",
                    LocalizedString.Res(R.string.ziggs_q_effect_1)
                ),
                Ability(
                    "W",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsW.png",
                    LocalizedString.Res(R.string.ziggs_w_label),
                    LocalizedString.Res(R.string.ziggs_w_description),
                    "14s / 14s / 14s / 14s / 14s",
                    "40 / 45 / 50 / 55 / 60",
                    LocalizedString.Res(R.string.ziggs_w_effect_1)
                ),
                Ability(
                    "E",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsE.png",
                    LocalizedString.Res(R.string.ziggs_e_label),
                    LocalizedString.Res(R.string.ziggs_e_description),
                    "12s / 12s / 12s / 12s / 12s",
                    "50 / 55 / 60 / 65 / 70",
                    LocalizedString.Res(R.string.ziggs_e_effect_1)
                ),
                Ability(
                    "R",
                    "https://ddragon.leagueoflegends.com/cdn/15.20.1/img/spell/ZiggsR.png",
                    LocalizedString.Res(R.string.ziggs_r_label),
                    LocalizedString.Res(R.string.ziggs_r_description),
                    "120s / 100s / 80s",
                    "100 / 100 / 100",
                    LocalizedString.Res(R.string.ziggs_r_effect_1)
                )
            ),
            deletable = true
        )
    )
}
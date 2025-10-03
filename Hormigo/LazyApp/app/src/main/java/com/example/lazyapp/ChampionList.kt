package com.example.lazyapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Text

data class Champion(@DrawableRes val image:Int, @StringRes val title: Int, @StringRes val description: Int)

val champions: List<Champion> = listOf(
    Champion(R.drawable.annie, R.string.annie_label, R.string.annie_description),
    Champion(R.drawable.diana, R.string.diana_label, R.string.diana_description),
    Champion(R.drawable.fizz, R.string.fizz_label, R.string.fizz_description),
    Champion(R.drawable.irelia, R.string.irelia_label, R.string.irelia_description),
    Champion(R.drawable.leona, R.string.leona_label, R.string.leona_description),
    Champion(R.drawable.mordekaiser, R.string.mordekaiser_label, R.string.mordekaiser_description),
    Champion(R.drawable.neeko, R.string.neeko_label, R.string.neeko_description),
    Champion(R.drawable.senna, R.string.senna_label, R.string.senna_description),
    Champion(R.drawable.taric, R.string.taric_label, R.string.taric_description),
    Champion(R.drawable.teemo, R.string.teemo_label, R.string.teemo_description),
    Champion(R.drawable.vi, R.string.vi_label, R.string.vi_description),
    Champion(R.drawable.ziggs, R.string.ziggs_label, R.string.ziggs_description)
)

@Composable
fun Screen(modifier: Modifier = Modifier) {
    LazyColumn {
        items(items = champions) { champion ->
            ChampionListItem(
                image = champion.image,
                title = stringResource(id = champion.title),
                description = stringResource(id = champion.description)
            )
        }
    }
}

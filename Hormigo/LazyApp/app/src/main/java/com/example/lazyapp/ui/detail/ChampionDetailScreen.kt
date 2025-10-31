package com.example.lazyapp.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.lazyapp.R
import com.example.lazyapp.data.model.Champion
import com.example.lazyapp.data.model.LocalizedString

@Composable
fun ChampionDetailsScreen(
    modifier: Modifier = Modifier,
    item: Champion,
    onCancel: () -> Unit,
    onDeleteItem: () -> Unit
) {
    @Composable
    fun lsText(ls: LocalizedString): String = when (ls) {
        is LocalizedString.Res -> stringResource(ls.resId)
        is LocalizedString.Plain -> ls.text
    }
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            // Splash image
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                ) {
                    AsyncImage(
                        model = item.splashImageUrl,
                        contentDescription = stringResource(R.string.splash_desc),
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 12.dp).padding(bottom = 12.dp)
                )
            }
            // Champion info
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = item.imageUrl,
                        contentDescription = lsText(item.name),
                        modifier = Modifier.size(96.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = lsText(item.name),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = lsText(item.title),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = lsText(item.description),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }
                }
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 12.dp).padding(bottom = 12.dp)
                )
            }
            // Champion long description
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = lsText(item.longDescription),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 12.dp).padding(bottom = 12.dp)
                )
            }
            // Champion stats
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.stats_label),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text("${stringResource(R.string.stat_hp_label)}: ${item.stats.hpBase} (+${item.stats.hpPerLevel}/${stringResource(R.string.per_level)})")
                    Text("${stringResource(R.string.stat_mp_label)}: ${item.stats.mpBase} (+${item.stats.mpPerLevel}/${stringResource(R.string.per_level)})")
                    Text("${stringResource(R.string.stat_ad_label)}: ${item.stats.adBase} (+${item.stats.adPerLevel}/${stringResource(R.string.per_level)})")
                    Text("${stringResource(R.string.stat_armor_label)}: ${item.stats.armorBase} (+${item.stats.armorPerLevel}/${stringResource(R.string.per_level)})")
                    Text("${stringResource(R.string.stat_mr_label)}: ${item.stats.mrBase} (+${item.stats.mrPerLevel}/${stringResource(R.string.per_level)})")
                    Text("${stringResource(R.string.stat_as_label)}: ${item.stats.attackSpeedBase} (+${item.stats.attackSpeedPerLevel}/${stringResource(R.string.per_level)})")
                    Text("${stringResource(R.string.stat_ms_label)}: ${item.stats.moveSpeed}")
                    Text("${stringResource(R.string.stat_range_label)}: ${item.stats.range}")
                }
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 12.dp).padding(bottom = 12.dp)
                )
            }
            // Champion skills
            item {
                Text(
                    text = stringResource(R.string.abilities_label),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp).padding(horizontal = 12.dp)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp)
                ) {
                    items(item.abilities) { ability ->
                        Surface(
                            tonalElevation = 2.dp,
                            modifier = Modifier.width(260.dp).height(230.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(10.dp).fillMaxWidth().verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = ability.imageUrl,
                                        contentDescription = stringResource(R.string.ability_image_desc),
                                        modifier = Modifier.size(48.dp).clip(CircleShape),
                                        contentScale = ContentScale.Crop
                                    )
                                    Column(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(
                                            text = lsText(ability.name),
                                            style = MaterialTheme.typography.bodyLarge,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = ability.id,
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                }
                                Text(
                                    text = lsText(ability.description),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Column {
                                    if (!ability.cooldowns.isNullOrEmpty()) {
                                        Text(
                                            "${stringResource(R.string.cooldowns_label)}: ${ability.cooldowns}",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                    if (!ability.costs.isNullOrEmpty()) {
                                        Text(
                                            "${stringResource(R.string.costs_label)}: ${ability.costs}",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                    ability.effects?.let { eff ->
                                        Text(
                                            "${stringResource(R.string.effects_label)}: ${lsText(eff)}",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // Delete & Cancel buttons
            item {
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 24.dp).padding(bottom = 12.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = onDeleteItem,
                        modifier = Modifier.weight(1f),
                        enabled = item.deletable
                    ) {
                        Text(stringResource(R.string.delete_label))
                    }
                    Button(
                        onClick = onCancel,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.back_label))
                    }
                }
            }
        }
    }
}

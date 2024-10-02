package com.animeapp.animeappproject.ui.screen.trending_anime_list.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import coil.compose.AsyncImage
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.animeapp.animeappproject.domain.model.AnimeData

@Composable
fun AnimeCard(
    anime : AnimeData,
//    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
//        onClick = onClick,
        modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(6.dp)
        ) {
            AsyncImage(
                model = anime.attributes.posterImage.original,
                contentDescription = "anime image",
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(10.dp))
                    ,
                contentScale = ContentScale.Crop,
            )

            Column {
                Row(
                    modifier = Modifier
                        .background(
                            Color(0xFFC4C7EB),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "rating",
                        tint = Color.Yellow
                    )
                    Text(text = anime.attributes.averageRating.toString())
                }

                Text(
                    text = anime.attributes.canonicalTitle.toString(),
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = anime.attributes.synopsis.toString(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
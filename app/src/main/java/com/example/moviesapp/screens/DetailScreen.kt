package com.example.moviesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.moviesapp.utils.Constants.Fonts.fontFamily
import com.example.moviesapp.utils.HtmlText
import com.example.moviesapp.utils.backgroundColor
import com.example.moviesapp.viewmodels.MainViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(
    viewModel: MainViewModel,
    itemId: String
) {
    val currentItem = viewModel.allMovies
        .observeAsState(listOf()).value
        .firstOrNull { it.id == itemId.toInt() }
    val genres = currentItem?.genres?.joinToString { it -> it }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                contentDescription = null,
                painter = rememberImagePainter(currentItem?.image?.original),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = currentItem?.name ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 16.dp),
                color = MaterialTheme.colors.backgroundColor,
                fontFamily = fontFamily
            )
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Rating: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.backgroundColor,
                    fontFamily = fontFamily
                )
                Text(
                    text = currentItem?.rating?.average.toString(),
                    fontSize = 18.sp
                )

            }
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Genre: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.backgroundColor,
                    fontFamily = fontFamily
                )

                Text(text = genres ?: "", fontSize = 18.sp)

            }
            HtmlText(
                html = currentItem?.summary ?: "",
                modifier = Modifier
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            )
        }

    }
}
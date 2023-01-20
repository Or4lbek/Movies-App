package com.example.moviesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.moviesapp.Screen
import com.example.moviesapp.data.models.Movies
import com.example.moviesapp.utils.Constants.Fonts.fontFamily
import com.example.moviesapp.utils.backgroundColor
import com.example.moviesapp.viewmodels.MainViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.backgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(12.dp)
                .background(color = MaterialTheme.colors.backgroundColor)
        ) {
            items(allMovies.take(15)) { it ->
                MovieItem(item = it, navController)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieItem(
    item: Movies,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.Detail.route + "/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image.medium),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Column() {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.backgroundColor,
                    fontFamily = fontFamily
                )
                Row {
                    Text(
                        text = "Rating: ",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.backgroundColor,
                        fontFamily = fontFamily
                    )
                    Text(text = item.rating.average.toString())
                }
                Row {
                    Text(
                        text = "Genre: ",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.backgroundColor,
                        fontFamily = fontFamily
                    )
                    item.genres.take(2).forEach { genre ->
                        Text(text = "$genre ")
                    }
                }
                Row {
                    Text(
                        text = "Premiered: ",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.backgroundColor,
                        fontFamily = fontFamily
                    )
                    Text(text = item.premiered)
                }
            }
        }
    }
}
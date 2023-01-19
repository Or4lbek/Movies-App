package com.example.moviesapp.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.moviesapp.data.models.Movies
import com.example.moviesapp.viewmodels.MainViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value


    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies.take(10)) { it ->
                MovieItem(item = it)
            }
        }
    }
}

@Composable
fun MovieItem(
    item: Movies
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = item.id.toString())
        Text(text = item.name)
    }
}
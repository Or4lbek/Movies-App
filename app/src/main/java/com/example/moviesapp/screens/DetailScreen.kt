package com.example.moviesapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.moviesapp.viewmodels.MainViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: MainViewModel,
    itemId: String
) {
    Text(text = "Detail screen item id: $itemId")
}
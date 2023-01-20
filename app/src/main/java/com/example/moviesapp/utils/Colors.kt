package com.example.moviesapp.utils

import android.graphics.Color.parseColor
import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Colors.backgroundColor
    get() = if (isLight) "#1A434B".color else Color.Black

val String.color
    get() = Color(parseColor(this))
package com.example.moviesapp.utils

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.example.moviesapp.R

class Constants {
    object Screens {
        const val SPLASH_SCREEN = "splash_screen"
        const val MAIN_SCREEN = "main_screen"
        const val DETAILS_SCREEN = "details_screen"

    }

    object Fonts{
        val fontFamily = FontFamily(
            Font(R.font.varenda_regular, FontWeight.Bold),
            Font(R.font.varenda_regular, FontWeight.Normal)
        )
    }
}

@Composable
fun HtmlText(html : String, modifier: Modifier){
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context)},
        update = {it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)}

    )
}


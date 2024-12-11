package com.declercq.bloom.ui.vue

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.declercq.bloom.R
import com.declercq.bloom.model.MovieBean
import com.declercq.bloom.ui.DetailButtonItem
import com.declercq.bloom.ui.LikeButtonItem
import com.declercq.bloom.ui.WatchLaterButtonItem
import com.declercq.bloom.ui.theme.BloomTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailMovieVue(modifier : Modifier = Modifier, movie : MovieBean){

    Column(modifier = modifier.fillMaxSize().padding(vertical = 32.dp)) {

        GlideImage(modifier = Modifier.height(350.dp).fillMaxWidth(),
            model = movie.poster,
            alignment = Alignment.TopCenter,
            contentDescription = movie.title,
            loading = placeholder(R.drawable.poster),
            failure = placeholder(R.drawable.poster),
            contentScale = ContentScale.Fit
        )
        Text(modifier = Modifier.padding(12.dp), text = movie.title, color = Color.LightGray, fontSize = 38.sp, textAlign = TextAlign.Center, lineHeight = 42.sp, fontWeight = FontWeight.Bold, maxLines = 5)
        Row(modifier = Modifier.fillMaxWidth()){
            Text(modifier = Modifier.weight(1F), text = movie.year, color = Color.LightGray, textAlign = TextAlign.Center)
            Text(modifier = Modifier.weight(1F), text = movie.type, color = Color.LightGray, textAlign = TextAlign.Center)
            Text(modifier = Modifier.weight(1F), text = movie.imdbID, color = Color.LightGray, textAlign = TextAlign.Center)
        }
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom){
            WatchLaterButtonItem(Modifier.scale(5F))
            Spacer(Modifier.size(24.dp))
            DetailButtonItem()
            Spacer(Modifier.size(24.dp))
            LikeButtonItem()

        }

    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailMovieSearchVuePreview(modifier: Modifier = Modifier){
    BloomTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            DetailMovieVue(
                modifier = Modifier.padding(innerPadding),
                MovieBean(title = "Avengers d;f,klqsd dkflqsdkfj lskdfkl : endgame", year = "2017", poster = "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg", type = "film", imdbID = "tt4154796")
            )
        }
    }
}
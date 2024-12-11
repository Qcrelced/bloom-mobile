package com.declercq.bloom.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.declercq.bloom.R
import com.declercq.bloom.model.MovieBean
import com.declercq.bloom.ui.theme.BloomTheme


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchMovieRowItem(modifier : Modifier = Modifier, movie : MovieBean){

    Column(modifier = modifier.height(125.dp)) {

        Row(modifier = Modifier.fillMaxWidth()
            .background(Color.Black)
            .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically){

            GlideImage(modifier = Modifier.clip(RoundedCornerShape(8.dp))
                .fillMaxHeight(),
                model = movie.poster,
                alignment = Alignment.TopCenter,
                contentDescription = movie.title,
                loading = placeholder(R.drawable.poster),
                failure = placeholder(R.drawable.poster),
                contentScale = ContentScale.Fit
            )

            Column(modifier = Modifier.fillMaxSize()
                .padding(start = 12.dp)){
                Row(modifier = Modifier.fillMaxWidth()){
                    Text(modifier = Modifier.weight(1F).padding(end = 10.dp), text = movie.title, color = Color.LightGray, fontSize = 24.sp, fontWeight = FontWeight.Bold, maxLines = 3)
                    LikeButtonItem()
                }
                Spacer(modifier = Modifier.weight(1F))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom){
                    Text(text = movie.year, color = Color.LightGray)
                    Text(text = movie.imdbID, color = Color.LightGray)
                }
            }
        }

        HorizontalDivider(thickness = 2.dp, color = Color.Red)

    }

}

@Composable
fun LikeButtonItem(modifier: Modifier = Modifier){
    IconButton( onClick = { },
        modifier = Modifier
            .size(52.dp)
            .background(color = Color.DarkGray, shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(R.drawable.ribbon_svgrepo_com),
            contentDescription = "Favorite",
            tint = Color.LightGray,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
fun WatchLaterButtonItem(modifier: Modifier = Modifier){
    IconButton( onClick = { },
        modifier = Modifier
            .size(52.dp)
            .background(color = Color.DarkGray, shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(R.drawable.clock_svgrepo_com),
            contentDescription = "Watch later",
            tint = Color.LightGray,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
fun DetailButtonItem(modifier: Modifier = Modifier){
    IconButton( onClick = { },
        modifier = Modifier
            .size(52.dp)
            .background(color = Color.DarkGray, shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(R.drawable.eye_svgrepo_com),
            contentDescription = "Detail movie",
            tint = Color.LightGray,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Preview
@Composable
fun DetailButtonItemPreview(modifier: Modifier = Modifier){
    BloomTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            DetailButtonItem(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}


@Preview
@Composable
fun WatchLaterButtonItemPreview(modifier: Modifier = Modifier){
    BloomTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            WatchLaterButtonItem(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}

@Preview
@Composable
fun LikeButtonItemPreview(modifier: Modifier = Modifier){
    BloomTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LikeButtonItem(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}

@Preview
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchMovieRowItemPreview() {
    BloomTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SearchMovieRowItem(
                modifier = Modifier.padding(innerPadding),
                MovieBean(title = "Avengers d;f,klqsd dkflqsdkfj lskdfkl : endgame", year = "2017", poster = "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg", type = "film", imdbID = "tt4154796")
            )
        }
    }
}


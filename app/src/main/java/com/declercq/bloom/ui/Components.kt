package com.declercq.bloom.ui;

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

    Column(modifier = Modifier.fillMaxWidth().height(125.dp)) {

        Row(modifier = modifier.fillMaxWidth()
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
                .padding(12.dp, 0.dp)){
                Text(text = movie.title, color = Color.LightGray, fontSize = 24.sp, fontWeight = FontWeight.Bold, maxLines = 3)
                Spacer(modifier = modifier.weight(1F))
                Row(modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom){
                    Text(text = movie.year, color = Color.LightGray)
                    Text(text = movie.imdbID, color = Color.LightGray)
                }
            }
        }

        HorizontalDivider(modifier = modifier, thickness = 2.dp, color = Color.Red)

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
                MovieBean(title = "Qu'est-ce qu'on a encore fait au Bon Dieu ?", year = "2017", poster = "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg", type = "film", imdbID = "dlkslkf")
            )
        }
    }
}


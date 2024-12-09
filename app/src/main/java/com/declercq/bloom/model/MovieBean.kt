package com.declercq.bloom.model

data class MovieBean(
    val title: String,
    val year: String,
    val released: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val writer: String,
    val plot: String,
    val country: String,
    val poster: String,
    val imdbID: String,
    val type: String,
    val rating: RatingBean
)
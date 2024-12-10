package com.declercq.bloom.model

data class MovieBean(
    val imdbID: String,
    val title: String,
    val year: String,
    val poster: String,
    val type: String,
    val released: String? = null,
    val runtime: String? = null,
    val genre: String? = null,
    val director: String? = null,
    val writer: String? = null,
    val plot: String? = null,
    val country: String? = null,
    val rating: RatingBean? = null
)
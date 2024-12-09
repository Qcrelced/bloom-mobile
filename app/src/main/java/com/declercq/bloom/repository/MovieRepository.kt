package com.declercq.bloom.repository

import com.declercq.bloom.common.URL_API_MOVIE
import com.declercq.bloom.model.MovieBean
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object MovieRepository{
    private val okHttpClient = OkHttpClient()
    private val gson = Gson()

    /**
     * Get details about a movie by its imdbID
     *
     * @param imdbId The imdbID of the movie
     */
    fun loadMovie(imdbId : String): MovieBean {
        val json : String = sendGet(URL_API_MOVIE + imdbId)
        val movieBean = gson.fromJson(json, MovieBean::class.java)
        return movieBean
    }

    private fun sendGet(url: String): String {
        println("Request : $url")
        val request = Request.Builder().url(url).build()
        return okHttpClient.newCall(request).execute().use { //it:Response
            if (!it.isSuccessful) {
                throw Exception("Incorrect server response :${it.code}\n${it.body.string()}")
            }
            it.body.string()
        }
    }
}
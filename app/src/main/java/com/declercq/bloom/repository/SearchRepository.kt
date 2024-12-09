package com.declercq.bloom.repository

import com.declercq.bloom.common.URL_API_SEARCH
import com.declercq.bloom.model.SearchBean
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object SearchRepository {
    private val okHttpClient = OkHttpClient()
    private val gson = Gson()

    fun loadMovies(search : String): SearchBean {
        val json : String = sendGet(URL_API_SEARCH + search)
        val searchBean = gson.fromJson(json, SearchBean::class.java)
        return searchBean
    }

    private fun sendGet(url: String): String {
        println("request : $url")
        val request = Request.Builder().url(url).build()
        return okHttpClient.newCall(request).execute().use { //it:Response
            if (!it.isSuccessful) {
                throw Exception("Incorect server response :${it.code}\n${it.body.string()}")
            }
            it.body.string()
        }
    }
}
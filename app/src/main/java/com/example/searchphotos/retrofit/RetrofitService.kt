package com.example.searchphotos.retrofit

import com.example.unsplashgallery.models.Photos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search/photos")
    fun getImageResponse(
        @Query("query") query: String,
        @Query("client_id") key: String,
        @Query("per_page") per_page: Int
    ): Call<Photos>
}
package com.example.unsplashgallery.retrofit

import com.example.searchphotos.retrofit.RetrofitService

object Common {

    private const val BASEURL = "https://api.unsplash.com/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getRetrofit(BASEURL).create(RetrofitService::class.java)
}
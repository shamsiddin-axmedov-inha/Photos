package com.example.unsplashgallery.models

data class Photos(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)
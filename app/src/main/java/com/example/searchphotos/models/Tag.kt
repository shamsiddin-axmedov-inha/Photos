package com.example.searchphotos.models

import com.example.unsplashgallery.models.Source

data class Tag(
    val source: Source,
    val title: String,
    val type: String
)
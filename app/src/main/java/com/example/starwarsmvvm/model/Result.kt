package com.example.starwarsmvvm.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "uid")
    val uid: String? = null,
    @Json(name = "url")
    val url: String? = null
)
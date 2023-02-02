package com.example.starwarsmvvm.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailsResponse(
    @Json(name = "message")
    val message: String? = null,
    @Json(name = "result")
    val result: Result? = null
)
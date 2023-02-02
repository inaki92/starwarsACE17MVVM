package com.example.starwarsmvvm.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StarWarsResponse(
    @Json(name = "message")
    val message: String? = null,
    @Json(name = "next")
    val next: String? = null,
    @Json(name = "previous")
    val previous: Any? = null,
    @Json(name = "results")
    val results: List<Result>? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_records")
    val totalRecords: Int? = null
)
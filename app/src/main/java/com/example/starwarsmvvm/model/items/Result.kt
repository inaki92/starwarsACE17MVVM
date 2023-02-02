package com.example.starwarsmvvm.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "_id")
    val id: String? = null,
    @Json(name = "properties")
    val properties: Properties? = null,
    @Json(name = "uid")
    val uid: String? = null,
    @Json(name = "__v")
    val v: Int? = null
)
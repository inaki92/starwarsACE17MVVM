package com.example.starwarsmvvm.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Properties(
    // STARSHIPS
    @Json(name = "cargo_capacity")
    val cargoCapacity: String? = null,
    @Json(name = "consumables")
    val consumables: String? = null,
    @Json(name = "cost_in_credits")
    val costInCredits: String? = null,
    @Json(name = "created")
    val created: String? = null,
    @Json(name = "crew")
    val crew: String? = null,
    @Json(name = "edited")
    val edited: String? = null,
    @Json(name = "hyperdrive_rating")
    val hyperdriveRating: String? = null,
    @Json(name = "length")
    val length: String? = null,
    @Json(name = "MGLT")
    val mGLT: String? = null,
    @Json(name = "manufacturer")
    val manufacturer: String? = null,
    @Json(name = "max_atmosphering_speed")
    val maxAtmospheringSpeed: String? = null,
    @Json(name = "model")
    val model: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "passengers")
    val passengers: String? = null,
    @Json(name = "pilots")
    val pilots: List<Any?>? = null,
    @Json(name = "starship_class")
    val starshipClass: String? = null,
    @Json(name = "url")
    val url: String? = null,

    // PEOPLE
    @Json(name = "birth_year")
    val birthYear: String? = null,
    @Json(name = "eye_color")
    val eyeColor: String? = null,
    @Json(name = "gender")
    val gender: String? = null,
    @Json(name = "hair_color")
    val hairColor: String? = null,
    @Json(name = "height")
    val height: String? = null,
    @Json(name = "homeworld")
    val homeworld: String? = null,
    @Json(name = "mass")
    val mass: String? = null,
    @Json(name = "skin_color")
    val skinColor: String? = null,

    // PLANETS
    @Json(name = "climate")
    val climate: String? = null,
    @Json(name = "diameter")
    val diameter: String? = null,
    @Json(name = "gravity")
    val gravity: String? = null,
    @Json(name = "orbital_period")
    val orbitalPeriod: String? = null,
    @Json(name = "population")
    val population: String? = null,
    @Json(name = "rotation_period")
    val rotationPeriod: String? = null,
    @Json(name = "surface_water")
    val surfaceWater: String? = null,
    @Json(name = "terrain")
    val terrain: String? = null
)
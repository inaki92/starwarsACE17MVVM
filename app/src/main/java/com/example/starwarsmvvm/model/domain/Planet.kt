package com.example.starwarsmvvm.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.starwarsmvvm.model.items.Result

@Entity
data class Planet(
    @PrimaryKey
    val id: String,
    val name: String,
    val climate: String,
    val gravity: String,
    val diameter: String,
    val population: String,
    val surfaceWater: String,
    val terrain: String,
    val description: String
    )

fun Result?.mapToPlanet(): Planet =
    Planet(
        id = this?.id ?: " - ",
        name = this?.properties?.name ?: " - ",
        climate = this?.properties?.climate ?: " - ",
        gravity = this?.properties?.gravity ?: " - ",
        diameter = this?.properties?.diameter ?: " - ",
        population = this?.properties?.population ?: " - ",
        surfaceWater = this?.properties?.surfaceWater ?: " - ",
        terrain = this?.properties?.terrain ?: " - ",
        description = this?.description ?: "No description"
    )
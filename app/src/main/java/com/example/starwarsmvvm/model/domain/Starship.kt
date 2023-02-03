package com.example.starwarsmvvm.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.starwarsmvvm.model.items.Result

@Entity("someName")
data class Starship(
    @PrimaryKey
    val id: String,
    val name: String,
    val manufacturer: String,
    val model: String,
    val starshipClass: String,
    val maxAtmospheringSpeed: String,
    val costInCredits: String,
    val cargoCapacity: String,
    val description: String
    )

fun Result?.mapToStarship(): Starship =
    Starship(
        id = this?.id ?: " - ",
        name = this?.properties?.name ?: " - ",
        manufacturer = this?.properties?.manufacturer ?: " - ",
        model = this?.properties?.model ?: " - ",
        starshipClass = this?.properties?.starshipClass ?: " - ",
        maxAtmospheringSpeed = this?.properties?.maxAtmospheringSpeed ?: " - ",
        costInCredits = this?.properties?.costInCredits ?: " - ",
        cargoCapacity = this?.properties?.cargoCapacity ?: " - ",
        description = this?.description ?: "No description"
    )

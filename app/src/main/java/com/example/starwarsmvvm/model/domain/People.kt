package com.example.starwarsmvvm.model.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.starwarsmvvm.model.items.Result

@Entity
data class People(
    @PrimaryKey
    val id: String,
    @ColumnInfo("character_name") val name: String,
    val birthYear: String,
    val height: String,
    val homeWorld: String,
    val gender: String,
    val description: String
    )

fun Result?.mapToPeople(): People =
    People(
        id = this?.id ?: " - ",
        name = this?.properties?.name ?: " - ",
        birthYear = this?.properties?.birthYear ?: " - ",
        height = this?.properties?.height ?: " - ",
        homeWorld = this?.properties?.homeworld ?: " - ",
        gender = this?.properties?.gender ?: " - ",
        description = this?.description ?: "No description"
    )

package com.example.starwarsmvvm.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("someName")
data class Starship(
    @PrimaryKey
    val id: String,
    val name: String
    )

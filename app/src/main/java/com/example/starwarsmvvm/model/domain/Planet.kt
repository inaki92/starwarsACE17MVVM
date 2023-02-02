package com.example.starwarsmvvm.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Planet(
    @PrimaryKey
    val id: String,
    val name: String
    )

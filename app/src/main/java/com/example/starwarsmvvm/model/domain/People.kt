package com.example.starwarsmvvm.model.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class People(
    @PrimaryKey
    val id: String,
    @ColumnInfo("character_name") val name: String
    )

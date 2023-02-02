package com.example.starwarsmvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.starwarsmvvm.model.domain.People
import com.example.starwarsmvvm.model.domain.Planet
import com.example.starwarsmvvm.model.domain.Starship

@Database(
    entities = [
        People::class,
        Planet::class,
        Starship::class
    ],
    version = 2
)
abstract class StarWarsDatabase : RoomDatabase() {
    abstract fun getStarWarsDAO(): StarWarsDAO
}
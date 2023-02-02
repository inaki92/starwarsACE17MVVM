package com.example.starwarsmvvm.database

import android.media.Image.Plane
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.starwarsmvvm.model.domain.People
import com.example.starwarsmvvm.model.domain.Planet
import com.example.starwarsmvvm.model.domain.Starship

@Dao
interface StarWarsDAO {

    @Query("SELECT * FROM people")
    suspend fun getPeople(): List<People>

    @Query("SELECT * FROM people WHERE character_name LIKE :characterName LIMIT 1")
    suspend fun getCharacterByName(characterName: String): People

    @Query("SELECT * FROM planet")
    suspend fun getPlanets(): List<Planet>

    @Query("SELECT * FROM someName")
    suspend fun getStarships(): List<Starship>

    @Insert(
        entity = People::class,
        onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeople(vararg people: People)

    @Insert(
        entity = Planet::class,
        onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanets(vararg people: Planet)

    @Insert(
        entity = Starship::class,
        onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarships(vararg people: Starship)
}
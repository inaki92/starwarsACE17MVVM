package com.example.starwarsmvvm.rest

import com.example.starwarsmvvm.model.StarWarsResponse
import com.example.starwarsmvvm.model.items.DetailsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi {

    @GET(PEOPLE)
    suspend fun getPeople(): Response<StarWarsResponse>

    @GET(PEOPLE + ID_PATH)
    suspend fun getPeopleById(
        @Path("id") id: String
    ): Response<DetailsResponse>

    @GET(PLANETS)
    suspend fun getPlanets(): Response<StarWarsResponse>

    @GET(PLANETS + ID_PATH)
    suspend fun getPlanetById(
        @Path("id") id: String
    ): Response<DetailsResponse>

    @GET(STARSHIPS)
    fun getStarshipsAsync(): Deferred<Response<StarWarsResponse>>

    @GET(STARSHIPS + ID_PATH)
    fun getStarshipByIdAsync(
        @Path("id") id: String
    ): Deferred<Response<DetailsResponse>>

    companion object {
        // https://www.swapi.tech/api/starships
        const val BASE_URL = "https://www.swapi.tech/api/"
        private const val ID_PATH = "/{id}"
        private const val PEOPLE = "people"
        private const val PLANETS = "planets"
        private const val STARSHIPS = "starships"
    }
}
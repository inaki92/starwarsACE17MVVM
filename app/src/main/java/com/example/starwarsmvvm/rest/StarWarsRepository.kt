package com.example.starwarsmvvm.rest

import com.example.starwarsmvvm.model.StarWarsResponse
import com.example.starwarsmvvm.model.domain.*
import com.example.starwarsmvvm.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface StarWarsRepository {
    fun getAllPeople(): Flow<UIState<StarWarsResponse>>
    fun getPeopleById(id: String): Flow<UIState<People>>

    fun getStarships(): Flow<UIState<StarWarsResponse>>
    fun getStarShipById(id: String): Flow<UIState<Starship>>

    fun getPlanets(): Flow<UIState<StarWarsResponse>>
    fun getPlanetById(id: String): Flow<UIState<Planet>>
}

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsApi: StarWarsApi
) : StarWarsRepository {

    override fun getAllPeople(): Flow<UIState<StarWarsResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPeople()
            if (response.isSuccessful) {
                response.body()?.let {
                   emit(UIState.SUCCESS(it))
                } ?: throw NullPeopleResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getPeopleById(id: String): Flow<UIState<People>> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPeopleById(id)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it.result.mapToPeople()))
                } ?: throw NullPeopleResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getStarships(): Flow<UIState<StarWarsResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getStarshipsAsync().await()
            if (response.isSuccessful) {
                response.body()?.let {

                } ?: throw NullStarshipsResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }

    }

    override fun getStarShipById(id: String): Flow<UIState<Starship>> {
        TODO("Not yet implemented")
    }

    override fun getPlanets(): Flow<UIState<StarWarsResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPlanets()
            if (response.isSuccessful) {
                response.body()?.let {
                    // todo emit success value
                } ?: throw NullPlanetsResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getPlanetById(id: String): Flow<UIState<Planet>> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPlanetById(id)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it.result.mapToPlanet()))
                } ?: throw NullPeopleResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

}
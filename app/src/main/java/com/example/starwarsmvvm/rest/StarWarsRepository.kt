package com.example.starwarsmvvm.rest

import com.example.starwarsmvvm.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface StarWarsRepository {
    fun getAllPeople(): Flow<UIState>
    fun getPeopleById(id: String): Flow<UIState>

    fun getStarships(): Flow<UIState>
    fun getStarShipById(id: String): Flow<UIState>

    fun getPlanets(): Flow<UIState>
    fun getPlanetById(id: String): Flow<UIState>
}

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsApi: StarWarsApi
) : StarWarsRepository {

    override fun getAllPeople(): Flow<UIState> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPeople()
            if (response.isSuccessful) {
                response.body()?.let {
                    // todo emit success value
                } ?: throw NullPeopleResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getPeopleById(id: String): Flow<UIState> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPeopleById(id)
            if (response.isSuccessful) {
                response.body()?.let {
                    // todo emit success value
                } ?: throw NullPeopleResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getStarships(): Flow<UIState> = flow {
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

    override fun getStarShipById(id: String): Flow<UIState> {
        TODO("Not yet implemented")
    }

    override fun getPlanets(): Flow<UIState> = flow {
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

    override fun getPlanetById(id: String): Flow<UIState> = flow {
        emit(UIState.LOADING)

        try {
            val response = starWarsApi.getPlanetById(id)
            if (response.isSuccessful) {
                response.body()?.let {
                    // todo emit success value
                } ?: throw NullPeopleResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

}
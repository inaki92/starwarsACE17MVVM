package com.example.starwarsmvvm.rest

import com.example.starwarsmvvm.model.StarWarsResponse
import com.example.starwarsmvvm.model.domain.People
import com.example.starwarsmvvm.utils.UIState
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Test

class StarWarsRepositoryImplTest {

    private lateinit var testObject: StarWarsRepository

    private val mockStarWarsApi: StarWarsApi = mockk(relaxed = true)

    @Before
    fun setUp() {
        testObject = StarWarsRepositoryImpl(mockStarWarsApi)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `get all people when server provides a list of people should return a success state`() =
        runTest {
            // AAA
            // ASSIGNMENT
            coEvery { mockStarWarsApi.getPeople() } returns mockk {
                every { isSuccessful } returns true
                every { body() } returns StarWarsResponse(results = listOf(mockk(), mockk()))
            }
            val states = mutableListOf<UIState>()

            // ACTION
            testObject.getAllPeople().collect {
                states.add(it)
            }

            // ASSERTION
            assertThat(states).hasSize(2)
            assertThat(states.first()).isInstanceOf(UIState.LOADING::class.java)
            assertThat(states[1]).isInstanceOf(UIState.SUCCESS::class.java)
            assertThat(
                (states[1] as UIState.SUCCESS<List<com.example.starwarsmvvm.model.Result>>).response
            ).hasSize(2)
    }
}
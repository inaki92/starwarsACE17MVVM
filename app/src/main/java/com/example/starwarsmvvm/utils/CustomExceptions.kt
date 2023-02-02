package com.example.starwarsmvvm.utils

class NullPeopleResponse(message: String = "People response is null") : Exception(message)
class NullPlanetsResponse(message: String = "Planets response is null") : Exception(message)
class NullStarshipsResponse(message: String = "Starships response is null") : Exception(message)
class FailureResponse(message: String?) : Exception(message)
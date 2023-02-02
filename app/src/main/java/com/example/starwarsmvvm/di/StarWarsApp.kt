package com.example.starwarsmvvm.di

import android.app.Application

class StarWarsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        starWarsComponent = DaggerStarWarsComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var starWarsComponent: StarWarsComponent
    }
}
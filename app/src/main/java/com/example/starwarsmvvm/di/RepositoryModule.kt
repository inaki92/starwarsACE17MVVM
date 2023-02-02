package com.example.starwarsmvvm.di

import com.example.starwarsmvvm.rest.StarWarsRepository
import com.example.starwarsmvvm.rest.StarWarsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun providesStarWarsRepository(
        starWarsRepositoryImpl: StarWarsRepositoryImpl
    ): StarWarsRepository
}
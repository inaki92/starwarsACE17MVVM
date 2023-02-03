package com.example.starwarsmvvm.di

import com.example.starwarsmvvm.rest.StarWarsRepository
import com.example.starwarsmvvm.rest.StarWarsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesStarWarsRepository(
        starWarsRepositoryImpl: StarWarsRepositoryImpl
    ): StarWarsRepository
}
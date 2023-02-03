package com.example.starwarsmvvm.di

import android.content.Context
import androidx.room.Room
import com.example.starwarsmvvm.database.StarWarsDAO
import com.example.starwarsmvvm.database.StarWarsDatabase
import com.example.starwarsmvvm.database.migration_1_2
import com.example.starwarsmvvm.rest.StarWarsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providesStarWarsDatabase(
        @ApplicationContext context: Context
    ): StarWarsDatabase =
        Room.databaseBuilder(
            context,
            StarWarsDatabase::class.java,
            "starwars-db"
        ).addMigrations(migration_1_2)
            .build()

    @Provides
    fun providesStarWarsDAO(
        starWarsDatabase: StarWarsDatabase
    ): StarWarsDAO =
        starWarsDatabase.getStarWarsDAO()
}
package com.example.starwarsmvvm.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.starwarsmvvm.database.StarWarsDAO
import com.example.starwarsmvvm.database.StarWarsDatabase
import com.example.starwarsmvvm.database.migration_1_2
import com.example.starwarsmvvm.rest.StarWarsRepository
import com.example.starwarsmvvm.utils.StarWarsViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun providesContext(): Context =
        application.applicationContext

    @Provides
    fun providesStarWarsDatabase(context: Context): StarWarsDatabase =
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

    @Provides
    fun provideViewModelFactory(
        repository: StarWarsRepository,
        ioDispatcher: CoroutineDispatcher
    ): StarWarsViewModelFactory =
        StarWarsViewModelFactory(repository, ioDispatcher)
}
package com.example.popularlibraries.domain.di.modules

import android.content.Context
import androidx.room.Room
import com.example.popularlibraries.domain.storage.GithubStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideGithubStorage(context: Context) : GithubStorage =
        Room.databaseBuilder(context, GithubStorage::class.java, "github.db")
            .build()

}
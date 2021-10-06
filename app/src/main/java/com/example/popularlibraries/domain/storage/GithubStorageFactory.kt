package com.example.popularlibraries.domain.storage

import android.content.Context
import androidx.room.Room

object GithubStorageFactory {

    fun create(context: Context): GithubStorage =
        Room.databaseBuilder(context, GithubStorage::class.java, "github.db")
            .build()

    fun createInMemory(context: Context): GithubStorage =
        Room.inMemoryDatabaseBuilder(context, GithubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
}
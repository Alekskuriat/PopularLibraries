package com.example.popularlibraries.domain.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.domain.repositories.dao.GithubRepoDao
import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.user.dao.GithubUserDao

@Database(
    exportSchema = false,
    entities = [GithubUserModel::class, GithubRepositories::class],
    version = 1
)
abstract class GithubStorage : RoomDatabase() {

    abstract fun getGithubUserDao(): GithubUserDao

    abstract fun getGithubUserRepoDao(): GithubRepoDao
}
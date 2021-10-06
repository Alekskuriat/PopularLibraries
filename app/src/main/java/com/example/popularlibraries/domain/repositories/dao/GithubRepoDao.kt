package com.example.popularlibraries.domain.repositories.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popularlibraries.domain.repositories.GithubRepositories
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface GithubRepoDao {

    @Query("SELECT * FROM repositories")
    fun getRepositories(): Single<List<GithubRepositories>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GithubRepositories>): Completable

}
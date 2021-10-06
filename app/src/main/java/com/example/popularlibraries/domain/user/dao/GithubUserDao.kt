package com.example.popularlibraries.domain.user.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface GithubUserDao {
    @Query("SELECT * FROM users")
    fun getGithubUsers(): Single<List<GithubUserModel>>

    @Query("SELECT * FROM users WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login : String): Single<GithubUserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GithubUserModel>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(user: GithubUserModel): Completable
}
package com.example.popularlibraries.domain.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class GithubUserModel(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("login")
    @ColumnInfo(name = "login")
    val login: String,
    @SerializedName("repos_url")
    @ColumnInfo(name = "repos_url")
    val reposUrl: String,
    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String

)

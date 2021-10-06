package com.example.popularlibraries.domain.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class GithubUserModel(
    @SerializedName("id")
    @PrimaryKey
    val id : Int,
    @SerializedName("login")
    @ColumnInfo
    val login : String,
    @SerializedName("repos_url")
    @ColumnInfo
    val reposUrl: String,
    @SerializedName("avatar_url")
    @ColumnInfo
    val avatarUrl : String

    )

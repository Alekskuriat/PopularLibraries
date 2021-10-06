package com.example.popularlibraries.domain.repositories

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositories")
data class GithubRepositories(
    @PrimaryKey
    @SerializedName("id")
    val id : Int,
    @ColumnInfo
    @SerializedName("name")
    val name : String,
    @ColumnInfo
    @SerializedName("forks")
    val forks : Int
)

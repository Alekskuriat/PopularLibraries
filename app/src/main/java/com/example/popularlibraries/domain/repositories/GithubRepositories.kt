package com.example.popularlibraries.domain.repositories

import com.google.gson.annotations.SerializedName


data class GithubRepositories(
    @SerializedName("name") val name : String,
    @SerializedName("forks") val forks : Int
)

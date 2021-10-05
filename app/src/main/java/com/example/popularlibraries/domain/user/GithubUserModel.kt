package com.example.popularlibraries.domain.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class GithubUserModel(
    @SerializedName("id")  val id : Int,
    @SerializedName("login") val login : String,
    @SerializedName("repos_url") val reposUrl: String,
    @SerializedName("avatar_url") val avatarUrl : String

    )

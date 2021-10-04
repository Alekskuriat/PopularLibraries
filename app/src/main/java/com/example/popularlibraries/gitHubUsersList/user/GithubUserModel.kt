package com.example.popularlibraries.gitHubUsersList.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class GithubUserModel(
    val id : Int,
    val login : String,
    val repos_url: String,
    val avatar_url : String
)

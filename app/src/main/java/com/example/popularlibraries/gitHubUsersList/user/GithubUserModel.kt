package com.example.popularlibraries.gitHubUsersList.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUserModel(
    val id : Int,
    val login : String
) : Parcelable

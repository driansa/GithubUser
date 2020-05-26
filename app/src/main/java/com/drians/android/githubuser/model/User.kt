package com.drians.android.githubuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String?,
    val name: String?,
    val avatar: Int?,
    val company: String?,
    val location: String?,
    val repository: String?,
    val follower: String?,
    val following: String?
) : Parcelable

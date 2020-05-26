package com.example.populairmovies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageConfigurations(
    @SerializedName("base_url") val base_url : String,
    @SerializedName("secure_base_url") val secure_base_url : String,
    @SerializedName("backdrop_sizes") val backdrop_sizes : List<String>,
    @SerializedName("logo_sizes") val logo_sizes : List<String>,
    @SerializedName("poster_sizes") val poster_sizes : List<String>,
    @SerializedName("profile_sizes") val profile_sizes : List<String>,
    @SerializedName("still_sizes") val still_sizes : List<String>
) : Parcelable
package com.example.populairmovies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConfigurationsResult (
    @SerializedName("images") val imageConfigurations : ImageConfigurations,
    @SerializedName("change_keys") val change_change_keyss : List<String>
) : Parcelable
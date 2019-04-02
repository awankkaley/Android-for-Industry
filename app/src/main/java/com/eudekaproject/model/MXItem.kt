package com.eudekaproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MXItem(

    @field:SerializedName("exchange")
    val exchange: String? = null,

    @field:SerializedName("priority")
    val priority: Int? = null
) : Parcelable
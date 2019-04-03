package com.eudekaproject.model

import com.google.gson.annotations.SerializedName


data class MXItem(

    @field:SerializedName("exchange")
    val exchange: String? = null,

    @field:SerializedName("priority")
    val priority: Int? = null
)
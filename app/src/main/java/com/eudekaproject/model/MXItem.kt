package com.eudekaproject.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class MXItem(

    @field:SerializedName("exchange")
    val exchange: String? = null,

    @field:SerializedName("priority")
    val priority: Int? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(exchange)
        parcel.writeValue(priority)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MXItem> {
        override fun createFromParcel(parcel: Parcel): MXItem {
            return MXItem(parcel)
        }

        override fun newArray(size: Int): Array<MXItem?> {
            return arrayOfNulls(size)
        }
    }
}
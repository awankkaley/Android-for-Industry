package com.eudekaproject.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class DomainsItem(

	@field:SerializedName("A")
	val A: List<String?>? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("NS")
	val nS: List<String?>? = null,

	@field:SerializedName("expiry_date")
	val expiryDate: Any? = null,

	@field:SerializedName("MX")
	val mX: List<MXItem?>? = null,

	@field:SerializedName("suffix")
	val suffix: String? = null,

	@field:SerializedName("update_date")
	val updateDate: String? = null,

	@field:SerializedName("isDead")
	val isDead: Boolean? = null,

	@field:SerializedName("TXT")
	val tXT: Any? = null,

	@field:SerializedName("resolvable")
	val resolvable: Boolean? = null,

	@field:SerializedName("domain")
	val domain: String? = null,

	@field:SerializedName("CNAME")
	val cNAME: Any? = null,

	@field:SerializedName("create_date")
	val createDate: Any? = null,

	@field:SerializedName("robots_txt")
	val robotsTxt: Any? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("parser")
	val parser: Boolean? = null,

	@field:SerializedName("parser_error")
	val parserError: Any? = null,

	@field:SerializedName("apps")
	val apps: Any? = null
):Parcelable {

	constructor(parcel: Parcel) : this(
		parcel.createStringArrayList(),
		parcel.readString(),
		parcel.createStringArrayList(),
		TODO("expiryDate"),
		parcel.createTypedArrayList(MXItem.CREATOR),
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		TODO("tXT"),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readString(),
		TODO("cNAME"),
		TODO("createDate"),
		TODO("robotsTxt"),
		parcel.readString(),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		TODO("parserError"),
		TODO("apps")
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeStringList(A)
		parcel.writeString(country)
		parcel.writeStringList(nS)
		parcel.writeTypedList(mX)
		parcel.writeString(suffix)
		parcel.writeString(updateDate)
		parcel.writeValue(isDead)
		parcel.writeValue(resolvable)
		parcel.writeString(domain)
		parcel.writeString(url)
		parcel.writeValue(parser)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<DomainsItem> {
		override fun createFromParcel(parcel: Parcel): DomainsItem {
			return DomainsItem(parcel)
		}

		override fun newArray(size: Int): Array<DomainsItem?> {
			return arrayOfNulls(size)
		}
	}
}
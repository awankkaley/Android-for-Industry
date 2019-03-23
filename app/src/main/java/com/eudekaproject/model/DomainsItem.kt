package com.eudekaproject.model


import com.google.gson.annotations.SerializedName


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
)

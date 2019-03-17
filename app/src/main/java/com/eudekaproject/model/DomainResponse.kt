package com.eudekaproject.model


import com.google.gson.annotations.SerializedName


data class DomainResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("domains")
	val domains: List<DomainsItem?>,

	@field:SerializedName("time")
	val time: Int? = null
)
package com.eudekaproject.data

import com.eudekaproject.model.DomainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("/search")
    fun getAllDomain(@Query("query") search: String): Call<DomainResponse>
}
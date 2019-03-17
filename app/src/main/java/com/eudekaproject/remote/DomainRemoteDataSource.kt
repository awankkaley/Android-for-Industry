package com.eudekaproject.remote


import com.eudekaproject.model.DomainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DomainRemoteDataSource : DomainDataSource {
    override fun getDomainList(callback: GetDomainCallback) {
        val serviceCallDomain = ApiClient.create()
        serviceCallDomain.getAllDomain("harmoni").enqueue(object : Callback<DomainResponse> {
            override fun onFailure(call: Call<DomainResponse>, t: Throwable) {
                callback.onDataNotAvailable(t.message.toString())
            }

            override fun onResponse(call: Call<DomainResponse>, response: Response<DomainResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        callback.onDomainLoaded(data)
                    }
                }
            }
        })
    }

}
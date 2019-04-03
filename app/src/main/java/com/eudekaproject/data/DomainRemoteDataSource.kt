package com.eudekaproject.data


import android.util.Log
import com.eudekaproject.model.DomainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DomainRemoteDataSource : DomainDataSource {
    override fun getDomainList(key: String, callback: GetDomainCallback) {
        val serviceCallDomain = ApiClient.create()
        serviceCallDomain.getAllDomain(key).enqueue(object : Callback<DomainResponse> {
            override fun onFailure(call: Call<DomainResponse>, t: Throwable) {
                callback.onDataNotAvailable(t.message.toString())
            }

            override fun onResponse(call: Call<DomainResponse>, response: Response<DomainResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("cek","data masuk " + response.message())
                    if (data != null) {
                        callback.onDomainLoaded(data)
                    }
                }else callback.onDataNotAvailable(response.message())
            }
        })
    }

}
package com.eudekaproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eudekaproject.model.DomainResponse
import com.eudekaproject.model.DomainsItem
import com.eudekaproject.remote.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var nama: MutableList<DomainResponse?> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()

    }

    private fun getData() {
        val serviceCallDomain = ApiClient.create()
        serviceCallDomain.getAllDomain("harmoni").enqueue(object : Callback<DomainResponse> {
            override fun onFailure(call: Call<DomainResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<DomainResponse>, response: Response<DomainResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("cek","datanya :"+data?.domains)
                    if (data != null) {
                        tv.text = data.domains[0]?.domain
                    }
                }
            }
        })
    }
}

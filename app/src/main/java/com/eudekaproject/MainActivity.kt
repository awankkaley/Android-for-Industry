package com.eudekaproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eudekaproject.model.*
import com.eudekaproject.remote.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

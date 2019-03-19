package com.eudekaproject.feature.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eudekaproject.R
import com.eudekaproject.DomainNavigator
import com.eudekaproject.Injection
import com.eudekaproject.model.DomainsItem

class MainActivity : AppCompatActivity(), DomainNavigator {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()

        mainViewModel.getListTeam("tokopedia")

    }

    override fun loadListDomain(listDomain: List<DomainsItem?>) {
        Log.d("GET", "Data :" + listDomain.size)
    }

    override fun errorLoadListDomain(message: String) {
        Log.d("GET", "error :$message")
    }

    fun initViewModel() {
        mainViewModel = MainViewModel(Injection.provideDomainRepositorycontext(this))
        mainViewModel.setNavigator(this)
    }
}

package com.eudekaproject.feature.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.eudekaproject.R
import com.eudekaproject.DomainNavigator
import com.eudekaproject.Injection
import com.eudekaproject.model.DomainsItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity(), DomainNavigator {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        cariData()


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

    fun cariData() {
        btn_cari_domain.onClick {
            var isEmptyField = false
            if (TextUtils.isEmpty(eTxt_input_domain.text)) {
                isEmptyField = true
                eTxt_input_domain.error = "Tidak Boleh Kosong !"
            }
            if (!isEmptyField) {
                mainViewModel.getListTeam(eTxt_input_domain.text.toString().trim())
            }
        }
    }
}

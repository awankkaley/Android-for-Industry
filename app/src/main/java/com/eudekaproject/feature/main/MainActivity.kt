package com.eudekaproject.feature.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.eudekaproject.R
import com.eudekaproject.DomainNavigator
import com.eudekaproject.Injection
import com.eudekaproject.DomainViewModel
import com.eudekaproject.feature.list.ListDomainActivity
import com.eudekaproject.model.DomainsItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), DomainNavigator {
    private lateinit var domainViewModel: DomainViewModel
    private var data: MutableList<DomainsItem?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()

        btn_cari_domain.onClick {
            cariData()
        }
    }

    override fun loadListDomain(listDomain: List<DomainsItem?>) {
        data.addAll(listDomain)

    }

    override fun errorLoadListDomain(message: String) {
        toast(message)
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun initViewModel() {
        domainViewModel = DomainViewModel(Injection.provideDomainRepositorycontext(this))
        domainViewModel.setNavigator(this)
    }

    fun cariData() {
        var isEmptyField = false
        if (TextUtils.isEmpty(eTxt_input_domain.text)) {
            isEmptyField = true
            eTxt_input_domain.error = resources.getString(R.string.empty_field)
        }
        if (!isEmptyField) {
            val key = eTxt_input_domain.text.toString()
            startActivity(intentFor<ListDomainActivity>(Pair("key", key)))
        }
    }

}

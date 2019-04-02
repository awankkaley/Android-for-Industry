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
import com.eudekaproject.utils.gone
import com.eudekaproject.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), DomainNavigator {
    private lateinit var domainViewModel: DomainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()

        btn_cari_domain.onClick {
            cariCekData("cari")
        }
        btn_cek_domain.onClick {
            cariCekData("cek")
        }
    }

    override fun loadListDomain(listDomain: List<DomainsItem?>) {
        if (listDomain.isEmpty()) {
            tv_main_available.setText(R.string.domain_avail)
        } else tv_main_available.setText(R.string.domain_unavai)

    }

    override fun errorLoadListDomain(message: String) {
        toast(message)
    }

    override fun showProgress() {
        progress_bar_main.visible()
    }

    override fun hideProgress() {
        progress_bar_main.gone()
    }

    fun initViewModel() {
        domainViewModel = DomainViewModel(Injection.provideDomainRepositorycontext(this))
        domainViewModel.setNavigator(this)
    }

    fun cariCekData(key: String) {
        var isEmptyField = false
        if (TextUtils.isEmpty(eTxt_input_domain.text)) {
            isEmptyField = true
            eTxt_input_domain.error = resources.getString(R.string.empty_field)
        }
        if (!isEmptyField && key == "cari") {
            val keyword = eTxt_input_domain.text.toString()
            startActivity(intentFor<ListDomainActivity>(Pair("key", keyword)))
        }
        if (!isEmptyField && key == "cek") {
            val keyword = eTxt_input_domain.text.toString()
            domainViewModel.getListTeam(keyword)
        }
    }

}

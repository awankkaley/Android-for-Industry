package com.eudekaproject.feature.main

import com.eudekaproject.data.DomainRepository
import com.eudekaproject.data.GetDomainCallback
import com.eudekaproject.DomainNavigator
import com.eudekaproject.model.DomainResponse

class MainViewModel(private val domainRepository: DomainRepository) {
    lateinit var domainNavigator: DomainNavigator

    fun setNavigator(domainNavigator: DomainNavigator) {
        this.domainNavigator = domainNavigator
    }

    fun getListTeam(key: String) {
        domainRepository.getDomainList(key, object : GetDomainCallback {
            override fun onDomainLoaded(domain: DomainResponse?) {
                if (domain != null) {
                    domainNavigator.loadListDomain(domain.domains)
                }
            }

            override fun onDataNotAvailable(errorMessage: String) {
                domainNavigator.errorLoadListDomain(errorMessage)
            }
        })
    }
}
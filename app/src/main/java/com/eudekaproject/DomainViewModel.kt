package com.eudekaproject

import com.eudekaproject.data.DomainRepository
import com.eudekaproject.data.GetDomainCallback
import com.eudekaproject.DomainNavigator
import com.eudekaproject.model.DomainResponse

class DomainViewModel(private val domainRepository: DomainRepository) {
    lateinit var domainNavigator: DomainNavigator

    fun setNavigator(domainNavigator: DomainNavigator) {
        this.domainNavigator = domainNavigator
    }

    fun getListTeam(key: String) {
        domainNavigator.showProgress()
        domainRepository.getDomainList(key, object : GetDomainCallback {
            override fun onDomainLoaded(domain: DomainResponse?) {
                if (domain != null) {
                    domainNavigator.hideProgress()
                    domainNavigator.loadListDomain(domain.domains)
                }
            }

            override fun onDataNotAvailable(errorMessage: String) {
                domainNavigator.hideProgress()
                domainNavigator.errorLoadListDomain(errorMessage)
            }
        })
    }
}
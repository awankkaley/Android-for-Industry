package com.eudekaproject

import com.eudekaproject.model.DomainsItem

interface DomainNavigator {
    fun loadListDomain(listDomain: List<DomainsItem?>)
    fun errorLoadListDomain(message: String)
    fun showProgress()
    fun hideProgress()
}
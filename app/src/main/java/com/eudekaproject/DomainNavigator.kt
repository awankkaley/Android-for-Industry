package com.eudekaproject

import com.eudekaproject.model.DomainsItem

interface DomainNavigator {
    fun LoadListDomain(listDomain: List<DomainsItem?>)
    fun errorLoadListDomain(message: String)
}
package com.eudekaproject.data

import com.eudekaproject.model.DomainResponse

interface DomainDataSource {
    fun getDomainList(callback: GetDomainCallback)
}

interface GetDomainCallback {
    fun onDomainLoaded(domain: DomainResponse?)
    fun onDataNotAvailable(errorMessage: String)
}
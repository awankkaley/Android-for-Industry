package com.eudekaproject.remote

import com.eudekaproject.model.DomainResponse

interface DomainDataSource {
    fun getDomainList(callback: GetDomainCallback)
}

interface GetDomainCallback {
    fun onDomainLoaded(team: DomainResponse?)
    fun onDataNotAvailable(errorMessage: String)
}
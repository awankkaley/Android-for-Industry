package com.eudekaproject.data

import com.eudekaproject.model.DomainResponse

class DomainRepository(private val domainRemoteDataSource: DomainRemoteDataSource) :
    DomainDataSource {
    override fun getDomainList(key: String, callback: GetDomainCallback) {
        domainRemoteDataSource.getDomainList(key, object : GetDomainCallback {
            override fun onDomainLoaded(domain: DomainResponse?) {
                if (domain != null) {
                    callback.onDomainLoaded(domain)
                }
            }

            override fun onDataNotAvailable(errorMessage: String) {
                callback.onDataNotAvailable(errorMessage)
            }
        })
    }
}

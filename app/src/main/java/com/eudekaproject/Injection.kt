package com.eudekaproject

import android.content.Context
import com.eudekaproject.data.DomainRemoteDataSource
import com.eudekaproject.data.DomainRepository

class Injection {
    companion object {

        fun provideDomainRepositorycontext(context: Context): DomainRepository {
            return DomainRepository(
                DomainRemoteDataSource()
            )
        }
    }
}
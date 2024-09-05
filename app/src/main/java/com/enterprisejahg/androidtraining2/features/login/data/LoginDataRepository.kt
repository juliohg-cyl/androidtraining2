package com.enterprisejahg.androidtraining2.features.login.data

import com.enterprisejahg.androidtraining2.features.login.data.local.LoginXmlLocalDataSource
import com.enterprisejahg.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.enterprisejahg.androidtraining2.features.login.domain.LoginRepository

class LoginDataRepository (
    private val localDataSource: LoginXmlLocalDataSource,
    private val remoteDataSource: LoginMockRemoteDataSource
    ):

    LoginRepository {


    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName, password)
    }

    override fun saveUsername(userName: String) {
        localDataSource.saveUsername(userName)
    }

    override fun deleteUsername() {
        localDataSource.deleteUsername()
    }

    override fun getUsername(): String? {
        return localDataSource.getUsername()
    }
}

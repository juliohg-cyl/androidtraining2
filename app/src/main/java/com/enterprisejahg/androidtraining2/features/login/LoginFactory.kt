package com.enterprisejahg.androidtraining2.features.login

import com.enterprisejahg.androidtraining2.features.login.data.LoginDataRepository
import com.enterprisejahg.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.enterprisejahg.androidtraining2.features.login.domain.LoginRepository
import com.enterprisejahg.androidtraining2.features.login.domain.SignInUseCase
import com.enterprisejahg.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory {

    //Atributos de clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource =
        provideLoginMockRemoteDataSource()

    private val loginRepository : LoginRepository = provideLoginDataRepository()

    private val signInUseCase : SignInUseCase = proveideSignInUseCase()


    //Métodos de clase
    fun provideLoginViewModel(): LoginViewModel{
        return LoginViewModel(signInUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository() : LoginDataRepository{
        return LoginDataRepository(LoginMockRemoteDataSource())
    }

    fun proveideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)
    }

}
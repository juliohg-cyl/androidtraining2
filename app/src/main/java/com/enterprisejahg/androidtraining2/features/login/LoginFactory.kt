package com.enterprisejahg.androidtraining2.features.login

import android.content.Context
import com.enterprisejahg.androidtraining2.features.login.data.LoginDataRepository
import com.enterprisejahg.androidtraining2.features.login.data.local.LoginXmlLocalDataSource
import com.enterprisejahg.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.enterprisejahg.androidtraining2.features.login.domain.DeleteUsernameUseCase
import com.enterprisejahg.androidtraining2.features.login.domain.GetUsernameUseCase
import com.enterprisejahg.androidtraining2.features.login.domain.LoginRepository
import com.enterprisejahg.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.enterprisejahg.androidtraining2.features.login.domain.SignInUseCase
import com.enterprisejahg.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory (private val context: Context){

    //Atributos de clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource =
        provideLoginMockRemoteDataSource()

    private val loginXmlLocalDataSource: LoginXmlLocalDataSource = provideLoginXmlRemoteDataSource()

    private val loginRepository : LoginRepository = provideLoginDataRepository()

    private val signInUseCase : SignInUseCase = provideSignInUseCase()

    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUseCase()

    private val deleteUsernameUseCase: DeleteUsernameUseCase = provideDeleteUsernameUseCase()

    private val getUsernameUseCase: GetUsernameUseCase = provideGetUsernameUseCase()


    //Métodos de clase
    fun provideLoginViewModel(): LoginViewModel{
        return LoginViewModel(signInUseCase, saveUsernameUseCase, deleteUsernameUseCase, getUsernameUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository() : LoginDataRepository{
        return LoginDataRepository(loginXmlLocalDataSource, loginMockRemoteDataSource)
    }

    private fun provideLoginXmlRemoteDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }

    private fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase{
        return SaveUsernameUseCase(loginRepository)
    }

    private fun provideDeleteUsernameUseCase(): DeleteUsernameUseCase{
        return DeleteUsernameUseCase(loginRepository)
    }

    private fun provideGetUsernameUseCase(): GetUsernameUseCase{
        return GetUsernameUseCase(loginRepository)
    }


}
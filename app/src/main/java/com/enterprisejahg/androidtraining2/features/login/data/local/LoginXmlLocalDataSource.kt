package com.enterprisejahg.androidtraining2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource(private val context: Context) {

    //La interrogacion sirve para comprobar si activity es nulo o no. En caso de nulo, no se ejecuta

    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString("key_username",username)
        editor.commit()
    }
}
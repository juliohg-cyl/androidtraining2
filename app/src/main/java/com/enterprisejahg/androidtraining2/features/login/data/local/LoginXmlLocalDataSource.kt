package com.enterprisejahg.androidtraining2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource(private val context: Context) {

    //La interrogacion sirve para comprobar si activity es nulo o no. En caso de nulo, no se ejecuta

    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    private val keyUsername = "key_username"

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString(keyUsername,username)
        editor.commit()
    }

    fun deleteUsername(){
        val editor = sharedPref.edit()
        editor.remove(keyUsername)
        editor.commit()
    }

    //La interrogación indica que el valor puede ser nulo

    fun getUsername(): String? {

        return sharedPref.getString(keyUsername,null)
    }

}
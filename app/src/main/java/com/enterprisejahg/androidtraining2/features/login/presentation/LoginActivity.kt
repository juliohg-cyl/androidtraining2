package com.enterprisejahg.androidtraining2.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.enterprisejahg.androidtraining2.R
import com.enterprisejahg.androidtraining2.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {


    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()

        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView(){
        //Inmutabilidad
        val actionValidate = findViewById<Button>(R.id.action_validate)
        //Mutabilidad
        //var actionValidate = findViewById<Button>(R.id.action_validate)

        actionValidate.setOnClickListener {
            Log.d("@dev", "Clicked!!")

            val userName = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            val rememberIsChecked = findViewById<CheckBox>(R.id.check_remember).isChecked
            val isValid = loginViewModel.validateClicked(userName, password, rememberIsChecked)
            if (isValid){
                Snackbar.make(
                    findViewById<View>(R.id.main),
                    R.string.message_login_ok,
                    Snackbar.LENGTH_SHORT).show()
            }
            else {
                Snackbar.make(
                    findViewById<View>(R.id.main),
                    R.string.message_login_fails,
                    Snackbar.LENGTH_SHORT
                ).show()
            }



            Log.d("@dev", userName)
            Log.d("@dev", password)


        }

    }
}
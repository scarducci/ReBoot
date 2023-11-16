package com.example.reboot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.parse.ParseObject
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var  btnLogin: Button
    private lateinit var tvSignUpLink: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignUpLink = findViewById(R.id.tvSignUpLink)

        btnLogin.setOnClickListener(){
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if(TextUtils.isEmpty(email)){
                Toast.makeText(applicationContext, "Email is Required.", Toast.LENGTH_LONG).show()
            }
            else if(TextUtils.isEmpty(password)){
                Toast.makeText(applicationContext, "Password is Required.", Toast.LENGTH_LONG).show()
            }
            else {
                login(email, password)
            }
        }

        tvSignUpLink.setOnClickListener(){
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }

    private fun login(email: String, password: String){

        ParseUser.logInInBackground(email, password, ({ user, e ->
            if(user != null){
                Toast.makeText(applicationContext, "Welcome Back " + ParseUser.getCurrentUser().username + " !", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext, "Username or Password Incorrect.", Toast.LENGTH_LONG).show()
            }
        }))
    }

    private fun signUp(email: String, password: String){
        val user = ParseUser()

        user.setUsername(email)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if(e == null){

            }
            else{

            }
        }
    }


}
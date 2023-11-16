package com.example.reboot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
            login(email, password)
        }

        tvSignUpLink.setOnClickListener(){
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        val firstObject = ParseObject("FirstClass")
        firstObject.put("message", "Parse is now connected!")
        firstObject.saveInBackground{
            if(it != null){
                it.localizedMessage?.let { message -> Log.e("MainActivity", message) }
                print("Parse is now connected!")
            }
            else{
                Log.d("MainActivity", "Object saved.")
                print("Object Saved")
            }
        }
    }

    private fun login(email: String, password: String){

        ParseUser.logInInBackground(email, password, ({ user, e ->
            if(user != null){
                //Logged in
            }
            else{
                //Login failed
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
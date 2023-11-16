package com.example.reboot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.parse.ParseUser

class SignUp : AppCompatActivity() {

    lateinit var edtUserName: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSignUp: Button
    lateinit var tvLoginLink: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //Connect UI components to their respective values
        edtUserName = findViewById(R.id.edtUserName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        tvLoginLink = findViewById(R.id.tvLoginLink)

        //Activate the functionality of Sign Up button
        btnSignUp.setOnClickListener(){
            val username = edtUserName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(username, email, password)
        }

        //Activate the functionality of the Login Link
        tvLoginLink.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun signUp(username: String, email: String, password: String){

        val user = ParseUser()

        user.setUsername(username)
        user.setEmail(email)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if(e == null){
                println("Sign Up Successful")
            }
            else{
                println("Something went wrong")
            }
        }
    }
}
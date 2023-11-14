package com.example.reboot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.parse.ParseObject

class MainActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var  btnLogin: Button
    private lateinit var tvSignUpLink: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}
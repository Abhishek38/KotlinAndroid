 package com.example.mvvmexample.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmexample.R

 class LoginActivity : AppCompatActivity() ,AuthListner{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

     override fun onStarted() {
         TODO("Not yet implemented")
     }

     override fun onSuccess() {
         TODO("Not yet implemented")
     }

     override fun onFailure(message: String) {
         TODO("Not yet implemented")
     }
 }

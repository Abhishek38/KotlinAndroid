package com.example.mvvmexample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel :ViewModel() {
     var email :String?=null
     var password :String?=null

    fun onButtonClicked(view: View){

        if(email.isNullOrEmpty()||password.isNullOrEmpty()){
            // send an error msg
            return
        }
        //success
    }

}
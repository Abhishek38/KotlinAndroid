package com.example.mvvmproject1.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var email:String?=null
    var password:String?=null
    var authListner:AuthListner?=null

    fun onButtonClicked(view : View){
        authListner?.onStarted()
        if (email.isNullOrEmpty()||password.isNullOrEmpty()){
            //send an error message
            authListner?.onFailure("Empty either of the two fields")
            return
        }
        authListner?.onSuccess()
        //

    }
}
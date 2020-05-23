package com.example.mvvmproject1.ui.auth

interface AuthListner {
    fun onSuccess()
    fun onStarted()
    fun onFailure(msg:String)//to receive the error message
}
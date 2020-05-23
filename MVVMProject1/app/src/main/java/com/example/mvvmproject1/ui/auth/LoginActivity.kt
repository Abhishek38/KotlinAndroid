package com.example.mvvmproject1.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject1.R
import com.example.mvvmproject1.databinding.ActivityLoginBinding
import com.example.mvvmproject1.utils.toast

class LoginActivity : AppCompatActivity(), AuthListner {
    lateinit var name:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :ActivityLoginBinding=DataBindingUtil.
                setContentView(this,R.layout.activity_login)
        val viewModel=ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel=viewModel
        viewModel.authListner=this
        name= viewModel.email.toString()
    }

    override fun onSuccess() {
    toast("Welcome"+name)
    }

    override fun onStarted() {
        toast("on started")
    }

    override fun onFailure(msg: String) {
    toast(msg)
    }
}

package com.example.test

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var btnLog : Button
    lateinit var btnReg : Button
    lateinit var varEtEmail : EditText
    lateinit var varEtPasswd : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLog = findViewById(R.id.btn_login)
        btnReg = findViewById(R.id.btn_regist)
        varEtEmail = findViewById(R.id.et_email)
        varEtPasswd = findViewById(R.id.et_password)
        btnLog.setOnClickListener {
            login()
        }
    }

    fun login() {
        val request = UserRequest()
        request.email = varEtEmail.text.toString().trim()
        request.password = varEtPasswd.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.login(request).enqueue(object :Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                Log.d(TAG, "signInWithEmail:Erorr")
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d(TAG, "signInWithEmail:success")
            }

        })
    }
}
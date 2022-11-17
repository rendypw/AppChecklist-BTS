package com.example.test

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Retro {
    fun getRetroClientInstance(): Retrofit{
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("http://94.74.86.174:8080/login/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
    }
}
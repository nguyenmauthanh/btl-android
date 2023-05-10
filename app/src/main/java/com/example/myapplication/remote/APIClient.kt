package com.example.myapplication.remote

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

public class APIClient {
    companion object{
        fun getClient(): Retrofit {
            var retrofit : Retrofit? = null
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.thingspeak.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit
        }
    }
}
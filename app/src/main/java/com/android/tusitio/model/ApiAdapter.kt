package com.android.tusitio.model

import com.android.tusitio.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAdapter {

    fun getApiService(): ApiService {
        val url = Constants.URL_API

        val cliente = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(cliente)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
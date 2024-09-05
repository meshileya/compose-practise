package com.nasa.practise2.network

import com.nasa.practise2.model.CountryItem
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

object NetowrkUtil {
    private const val BASE_URL = "https://gist.githubusercontent.com/peymano-wmt/"

    fun create(): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(900, TimeUnit.SECONDS)
            .writeTimeout(900, TimeUnit.SECONDS)
            .readTimeout(900, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET("32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getPosts(): List<CountryItem>
}
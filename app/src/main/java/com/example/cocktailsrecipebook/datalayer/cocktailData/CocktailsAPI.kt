package com.example.cocktailsrecipebook.datalayer.cocktailData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CocktailsAPI {
    private val BASE_URL = "https://cocktail-by-api-ninjas.p.rapidapi.com"

    val cocktail_api: RapidAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RapidAPI::class.java)
    }
}
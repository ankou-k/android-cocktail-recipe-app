package com.example.cocktailsrecipebook.datalayer.cocktailData

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RapidAPI {

    @GET("v1/cocktail")
    suspend fun getCocktailsByName(
        @Query("name") name: String,
        @Header("X-RapidAPI-Key") apiKey: String = "51f7e67e00msh52226fd06e20adbp1a9cc8jsncf823865421b",
        @Header("X-RapidAPI-Host") host: String = "cocktail-by-api-ninjas.p.rapidapi.com"
    ): List<CocktailResponse>

    @GET("v1/cocktail")
    suspend fun getCocktailsByIngredients(
        @Query("ingredients") ingredients: String,
        @Header("X-RapidAPI-Key") apiKey: String = "51f7e67e00msh52226fd06e20adbp1a9cc8jsncf823865421b",
        @Header("X-RapidAPI-Host") host: String = "cocktail-by-api-ninjas.p.rapidapi.com"
    ): List<CocktailResponse>

    @GET("v1/cocktail")
    suspend fun getCocktails(
        @Query("name") name: String,
        @Query("ingredients") ingredients: String,
        @Header("X-RapidAPI-Key") apiKey: String = "51f7e67e00msh52226fd06e20adbp1a9cc8jsncf823865421b",
        @Header("X-RapidAPI-Host") host: String = "cocktail-by-api-ninjas.p.rapidapi.com"
    ): List<CocktailResponse>
}
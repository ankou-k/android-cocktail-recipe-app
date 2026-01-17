package com.example.cocktailsrecipebook.datalayer.cocktailData

class CocktailRepo {
    suspend fun getCocktailsByName(name: String): List<CocktailResponse> {
        if (name.isEmpty()) return emptyList()
        return CocktailsAPI.cocktail_api.getCocktailsByName(name)
    }

    suspend fun getCocktailsByIngredients(ingredients: String): List<CocktailResponse> {
        if (ingredients.isEmpty()) return emptyList()
        return CocktailsAPI.cocktail_api.getCocktailsByIngredients(ingredients)
    }

    suspend fun getCocktails(name: String, ingredients: String): List<CocktailResponse> {
        if (name.isEmpty() && ingredients.isEmpty()) return emptyList()
        return CocktailsAPI.cocktail_api.getCocktails(name = name, ingredients = ingredients)
    }
}
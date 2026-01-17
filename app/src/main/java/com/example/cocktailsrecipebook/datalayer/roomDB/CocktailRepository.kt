package com.example.cocktailsrecipebook.datalayer.roomDB

import com.example.cocktailsrecipebook.datalayer.cocktailData.CocktailClass

class CocktailRepository(private val dao: CocktailDAO) {

    suspend fun addNewCocktailToDB(cocktail: Cocktail) {
        dao.insertNewCocktail(newCocktail = cocktail)
    }

    suspend fun deleteOneCocktail(cocktail: Cocktail) {
        dao.deleteOneCocktail(cocktail)
    }

    suspend fun getFavCocktails(): List<Cocktail> {
        return dao.getAllCocktailsFromDB()
    }

    suspend fun searchInDB(t: String): List<Cocktail>  {
        return dao.searchForCocktail(t)
    }
}
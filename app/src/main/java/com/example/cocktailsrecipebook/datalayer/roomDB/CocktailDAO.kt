package com.example.cocktailsrecipebook.datalayer.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.cocktailsrecipebook.datalayer.cocktailData.CocktailClass

@Dao
interface CocktailDAO {

    @Insert
    suspend fun insertNewCocktail( newCocktail: Cocktail)

    @Query("select * from favcocktail")
    suspend fun getAllCocktailsFromDB() : List<Cocktail>

    @Delete
    suspend fun deleteOneCocktail(toDeleteCocktail: Cocktail)

    @Query("select * from favcocktail where name LIKE :startWith || '%'")
    suspend fun searchForCocktail(startWith: String) : List<Cocktail>
}
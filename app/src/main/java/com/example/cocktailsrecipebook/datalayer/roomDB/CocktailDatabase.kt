package com.example.cocktailsrecipebook.datalayer.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cocktail::class], version = 1)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun cocktailDAO(): CocktailDAO
}
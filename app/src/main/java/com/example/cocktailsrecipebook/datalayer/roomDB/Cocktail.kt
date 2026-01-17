package com.example.cocktailsrecipebook.datalayer.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favcocktail")
data class Cocktail(
    @PrimaryKey(autoGenerate = true) val cocktailId: Long,
    val name: String,
    val ingredients: String,
    val instructions: String
)
package com.example.cocktailsrecipebook.uilayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailsrecipebook.datalayer.cocktailData.CocktailRepo
import com.example.cocktailsrecipebook.datalayer.cocktailData.CocktailResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SearchCocktailsVM: ViewModel() {

    // bring instance of repository between data layer and ui layer
    private val repo = CocktailRepo()

    var cocktails = MutableStateFlow<List<CocktailResponse>>(emptyList())
    var searchJob : Job? = null

    fun onSearchClick(name: String, ingredients: String): Boolean {
        // check if name and ingredients are empty, return

        if (name.isEmpty() && ingredients.isEmpty()) {
                return false // do nothing
        }

        searchJob = viewModelScope.launch {
            cocktails.value = if (name.isEmpty()) {
                repo.getCocktailsByName(name)
            } else if (ingredients.isEmpty()) {
                repo.getCocktailsByIngredients(ingredients)
            } else {
                repo.getCocktails(name = name, ingredients = ingredients)
            }
            delay(300)
        }

        return true
    }
}
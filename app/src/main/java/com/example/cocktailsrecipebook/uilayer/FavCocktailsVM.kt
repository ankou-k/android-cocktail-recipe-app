package com.example.cocktailsrecipebook.uilayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailsrecipebook.datalayer.cocktailData.CocktailClass
import com.example.cocktailsrecipebook.datalayer.roomDB.Cocktail
import com.example.cocktailsrecipebook.datalayer.roomDB.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FavCocktailsVM @Inject constructor(
    private val repo: CocktailRepository
): ViewModel() {

    // state
    private var _favoritesCocktails = MutableStateFlow<List<Cocktail>?>(emptyList())
    val favoritesCocktails : MutableStateFlow<List<Cocktail>?> = _favoritesCocktails

    private val _currentCocktail= MutableStateFlow<Cocktail?>(null)
    val currentCocktail: MutableStateFlow<Cocktail?> = _currentCocktail

    fun saveCocktail( name: String, ingredients: String, instructions: String){
        viewModelScope.launch {
            repo.addNewCocktailToDB(Cocktail(0, name, ingredients, instructions))
        }
    }

    fun getAllSavedCocktails(){
        viewModelScope.launch {
            _favoritesCocktails.value = repo.getFavCocktails() as List<Cocktail>?
        }
    }

    fun deleteCocktail(cocktail: Cocktail){
        viewModelScope.launch {
            repo.deleteOneCocktail(cocktail)
        }
    }


    fun searchForCocktail(name: String){
        viewModelScope.launch {
            val result = repo.searchInDB(name)
            if (!result.isEmpty()) {
                _currentCocktail.value = result[0]
            }
        }
    }


}
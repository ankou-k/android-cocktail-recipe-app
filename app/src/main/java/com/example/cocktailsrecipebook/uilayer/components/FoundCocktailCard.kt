package com.example.cocktailsrecipebook.uilayer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cocktailsrecipebook.datalayer.cocktailData.CocktailResponse
import com.example.cocktailsrecipebook.ui.theme.FilledHeart
import com.example.cocktailsrecipebook.uilayer.FavCocktailsVM

@Composable
fun FoundCocktailCard(
    cocktail: CocktailResponse,
    navController: NavController,
    favCocktailsVM: FavCocktailsVM
) {
    Card(modifier = Modifier.padding(5.dp)) {
        Column() {
            Row(modifier = Modifier.padding(10.dp).wrapContentHeight()) {
                Text(cocktail.name, Modifier.weight(0.5f))
                FavoriteButton(Modifier.weight(1f))
            }
            Button(onClick = {
                navController.navigate("cocktails/${cocktail.name}")
            }) {
                Text("See recipe")
            }
        }

    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = FilledHeart,
    isFavorite: Boolean = false
) {

    var curFav by remember { mutableStateOf(isFavorite) }

    IconButton(
        onClick = {
            curFav != curFav
        }
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Filled.FavoriteBorder
            },
            contentDescription = null
        )
    }

}
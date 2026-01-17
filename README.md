# Cocktail Recipe Book

### Video link: https://youtu.be/zZ5Mu_JDbXc 

This app is for having a cocktail recipe book, users can find cocktails and discover new cocktails by ingredients, look at recipes, and save the recipes they like (saved locally). The app also integrates user analytics through Firebase.

## Implementations
1. 4 UI and navigation between them implemented using navController
2. Android Composables for UI design
3. App fetch data from RapidAPI to get cocktail recipes.
4. The app has persistent storage using Room DB for the user's favourited recipes.
5. The app uses the analytics service from Firebase.
6. The project follows the "MVVM" design pattern and structure with 2 ViewModels
7. The project uses Hilt injection to inject a ViewModel with DAO to communicate with RoomDB

## Future steps:
1. Fetching images correlating to ingredients and cocktail from other API and displaying to user
2. Sharing recipe dashboard with other users
